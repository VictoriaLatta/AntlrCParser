package code_gen;

import code_gen_syntax.StructureType;
import code_gen_syntax.IntType;
import code_gen_syntax.AssignmentStmt;
import code_gen_syntax.BoolType;
import code_gen_syntax.BinopExp;
import code_gen_syntax.MinusOp;
import code_gen_syntax.WhileStmt;
import code_gen_syntax.SequenceStmt;
import code_gen_syntax.FunctionCallStmt;
import code_gen_syntax.BoolExp;
import code_gen_syntax.FunctionCallExp;
import code_gen_syntax.BreakStmt;
import code_gen_syntax.PrintStmt;
import code_gen_syntax.VariableExp;
import code_gen_syntax.EqualsOp;
import code_gen_syntax.VariableDeclaration;
import code_gen_syntax.PlusOp;
import code_gen_syntax.ReturnVoidStmt;
import code_gen_syntax.Variable;
import code_gen_syntax.Type;
import code_gen_syntax.IntExp;
import code_gen_syntax.IfStmt;
import code_gen_syntax.ReturnExpStmt;
import code_gen_syntax.VoidType;
import code_gen_syntax.FieldName;
import code_gen_syntax.LessThanOp;
import code_gen_syntax.Exp;
import code_gen_syntax.Op;
import code_gen_syntax.DereferenceExp;
import code_gen_syntax.SizeofExp;
import code_gen_syntax.VariableLhs;
import code_gen_syntax.VariableDeclarationInitializationStmt;
import code_gen_syntax.Stmt;
import code_gen_syntax.AddressOfExp;
import code_gen_syntax.DereferenceLhs;
import code_gen_syntax.PointerType;
import code_gen_syntax.FunctionName;
import code_gen_syntax.FunctionDefinition;
import code_gen_syntax.Lhs;
import code_gen_syntax.StructureName;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

// MIPS documentation:
// - MIPS reference card: https://inst.eecs.berkeley.edu/~cs61c/resources/MIPS_Green_Sheet.pdf
// - MIPS system calls: https://www.doc.ic.ac.uk/lab/secondyear/spim/node8.html
//
// You will need SPIM (http://spimsimulator.sourceforge.net/) installed to run this; spim is
// usually available as a binary package though your distribution / Homebrew
//
public class MIPSCodeGenerator {
    // ---BEGIN CONSTANTS---
    // placeholder variable for return addresses
    public static final Variable RA_VARIABLE = new Variable("$ra");
    public static final FunctionName REAL_MAIN = new FunctionName("$REAL_MAIN");
    // ---END CONSTANTS

    // ---BEGIN INSTANCE VARIABLES---
    private final Map<StructureName, LinkedHashMap<FieldName, Type>> structDecs;
    private final Map<FunctionName, FunctionDefinition> functionDefs;
    private final List<MIPSEntry> entries;
    private final VariableTable variables;
    private FunctionName currentFunction;
    private int expressionOffset;
    private int ifCounter;
    private int whileCounter;
    private MIPSLabel currentWhileStart;
    private MIPSLabel currentWhileEnd;
    private VariableTableResetPoint currentWhileReset;
    // ---END INSTANCE VARIABLES
    
    public MIPSCodeGenerator(final Map<StructureName, LinkedHashMap<FieldName, Type>> structDecs,
                             final Map<FunctionName, FunctionDefinition> functionDefs) {
        this.structDecs = structDecs;
        this.functionDefs = functionDefs;
        entries = new ArrayList<MIPSEntry>();
        variables = new VariableTable();
        expressionOffset = 0;
        currentFunction = null;
        ifCounter = 0;
        whileCounter = 0;
        currentWhileStart = null;
        currentWhileEnd = null;
        currentWhileReset = null;
    }

    // specifically used in statement contexts, when a statement finishes evaluating an
    // expression inside
    private void resetExpressionOffset() {
        assert(expressionOffset >= 0);
        assert(expressionOffset % 4 == 0);
        expressionOffset = 0;
    }

    public static boolean containsReturn(final Stmt stmt) {
        if (stmt instanceof VariableDeclarationInitializationStmt ||
            stmt instanceof AssignmentStmt ||
            stmt instanceof PrintStmt ||
            stmt instanceof FunctionCallStmt ||
            stmt instanceof BreakStmt) {
            return false;
        } else if (stmt instanceof SequenceStmt) {
            final SequenceStmt asSeq = (SequenceStmt)stmt;
            return containsReturn(asSeq.first) || containsReturn(asSeq.second);
        } else if (stmt instanceof ReturnVoidStmt ||
                   stmt instanceof ReturnExpStmt) {
            return true;
        } else if (stmt instanceof IfStmt) {
            final IfStmt asIf = (IfStmt)stmt;
            return containsReturn(asIf.ifTrue) || containsReturn(asIf.ifFalse);
        } else if (stmt instanceof WhileStmt) {
            return containsReturn(((WhileStmt)stmt).body);
        } else {
            assert(false);
            return false;
        }
    }

    private void doReturn() {
        // the stack looks like the following at this point:
        //
        // before_call
        // argument1
        // argument2
        // ...
        // argumentN
        // return_address
        // local_variable_1
        // local_variable_2
        // ...
        // local_variable_N
        // return_value
        //
        //
        // we need to adjust it so it looks like the following:
        //
        // before_call
        // return_value
        //
        // SP_before_call = SP_current + sizeof(allVariables) + expressionOffset
        // finalSP = SP_current + sizeof(allVariables)
        //

        
        // save return value in a register
        final int raOffset = variables.variableOffset(RA_VARIABLE) + expressionOffset;
        final MIPSRegister sp = MIPSRegister.SP;
        final MIPSRegister ra = MIPSRegister.RA;
        add(new Lw(ra, raOffset, sp));

        // copy return value to correct place
        final int sizeOfAllVariables = variables.totalSizeOfAllVariables();
        final int copyReturnValueToOffset =
            sizeOfAllVariables + expressionOffset;
        int copyFrom = expressionOffset - 4;
        int copyTo = copyReturnValueToOffset - 4;
        while (copyFrom >= 0) {
            final MIPSRegister t0 = MIPSRegister.T0;
            add(new Lw(t0, copyFrom, sp));
            add(new Sw(t0, copyTo, sp));
            copyFrom -= 4;
            copyTo -= 4;
        }

        // Put sp at final position
        add(new Addi(sp, sp, sizeOfAllVariables));

        // do the return
        add(new Jr(ra));
    }

    // will create a wrapper that calls this function and then exits
    public void compileMainFunctionDefinition(final FunctionDefinition def) {
        assert(def.returnType.equals(new VoidType()));
        assert(def.name.name.equals("main"));
        assert(def.parameters.length == 0);

        // call into the user's main and then exit
        add(functionNameToLabel(REAL_MAIN));
        compileFunctionCallExp(new FunctionCallExp(def.name, new Exp[0]));
        mainEnd();
        
        compileFunctionDefinition(def);
    }
    
    public void compileFunctionDefinition(final FunctionDefinition def) {
        assert(expressionOffset == 0);
        assert(variables.isEmpty());
        assert(currentFunction == null);

        currentFunction = def.name;
        add(functionNameToLabel(def.name));
        
        for (final VariableDeclaration param : def.parameters) {
            variables.pushVariable(param.variable,
                                   param.type,
                                   sizeof(param.type));
        }

        // return address always follows parameters
        // we treat this like a special variable
        push(MIPSRegister.RA);
        variables.pushVariable(RA_VARIABLE,
                               new PointerType(new VoidType()), // meaningless
                               4);
        resetExpressionOffset();
        compileStatement(def.body);
        assert(expressionOffset == 0);

        // return will handle putting the return value on the stack
        // return is not always requires, so see if we need to put one here
        if (!containsReturn(def.body)) {
            doReturn();
        }
        variables.clear();
        currentFunction = null;
    }

    private MIPSLabel freshIfLabel(final String baseName) {
        return new MIPSLabel(currentFunction.name + "_if_" + baseName, ifCounter++);
    }

    private MIPSLabel freshWhileLabel(final String baseName) {
        return new MIPSLabel(currentFunction.name + "_while_" + baseName, whileCounter++);
    }
    
    public void compileIfStmt(final IfStmt stmt) {
        compileExpression(stmt.guard);

        // Guaranteed that guard is a boolean, from the typechecker.
        // Put it in t0.
        assert(expressionOffset == 4);
        final MIPSRegister t0 = MIPSRegister.T0;
        pop(t0);

        // If it's false, make a jump.  If it's true, fall through to true branch.
        // True branch needs to jump to after the false, which ends the if/else
        final MIPSLabel falseStart = freshIfLabel("false_start");
        final MIPSLabel falseEnd = freshIfLabel("false_end");
        add(new Beq(t0, MIPSRegister.ZERO, falseStart));

        compileStatementInNestedScope(false, stmt.ifTrue);
        add(new J(falseEnd));
        add(falseStart);
        compileStatementInNestedScope(false, stmt.ifFalse);
        add(falseEnd);
    }

    private void freeSizeForVariables(final int size) {
        assert(size >= 0);
        if (size > 0) {
            final MIPSRegister sp = MIPSRegister.SP;
            add(new Addi(sp, sp, size));
        }
    }
    
    private void compileStatementInNestedScope(final boolean isWhile, final Stmt stmt) {
        final VariableTableResetPoint oldWhileReset = currentWhileReset;
        final VariableTableResetPoint reset = variables.makeResetPoint();
        if (isWhile) {
            currentWhileReset = reset;
        }
        compileStatement(stmt);
        freeSizeForVariables(variables.resetTo(reset));
        if (isWhile) {
            currentWhileReset = oldWhileReset;
        }
    }
    
    public void compileVariableDeclarationInitializationStmt(final VariableDeclarationInitializationStmt stmt) {
        compileExpression(stmt.exp);
        resetExpressionOffset();
        final VariableDeclaration dec = stmt.varDec;
        // variable's value is now on top of stack
        variables.pushVariable(dec.variable,
                               dec.type,
                               sizeof(dec.type));
    }

    public void compileSequenceStmt(final SequenceStmt stmt) {
        compileStatement(stmt.first);
        compileStatement(stmt.second);
    }

    public int variableOffset(final Variable variable) {
        return variables.variableOffset(variable) + expressionOffset;
    }
    
    public void putLhsAddressIntoRegister(final MIPSRegister destination,
                                          final Lhs lhs) {
        if (lhs instanceof VariableLhs) {
            final int offset = variableOffset(((VariableLhs)lhs).variable);
            add(new Addi(destination, MIPSRegister.SP, offset));
        }else if (lhs instanceof DereferenceLhs) {
            final DereferenceLhs asDeref = (DereferenceLhs)lhs;
            putLhsAddressIntoRegister(destination, asDeref.lhs);
            add(new Lw(destination, 0, destination));
        } else {
            assert(false);
        }
    }

    public int lhsSize(final Lhs lhs) {
        if (lhs instanceof VariableLhs) {
            return variables.variableSize(((VariableLhs)lhs).variable);
        } else if (lhs instanceof DereferenceLhs) {
            final DereferenceLhs asDereference = (DereferenceLhs)lhs;
            return sizeof(asDereference.getTypeAfterDereference());
        } else {
            assert(false);
            return 0;
        }
    }
    
    public void compileAssignmentStmt(final AssignmentStmt stmt) {        
        // determine new value
        compileExpression(stmt.exp);

        // establish where we're going to copy
        final int size = lhsSize(stmt.lhs);
        assert(size % 4 == 0);
        final MIPSRegister t0 = MIPSRegister.T0;
        putLhsAddressIntoRegister(t0, stmt.lhs);
        resetExpressionOffset();

        // copy this value into the variable
        final MIPSRegister sp = MIPSRegister.SP;
        for (int base = 0; base < size; base += 4) {
            final MIPSRegister t1 = MIPSRegister.T1;
            add(new Lw(t1, base, sp));
            add(new Sw(t1, base, t0));
        }

        add(new Addi(sp, sp, size));
    }

    public void printA0() {
        add(new Li(MIPSRegister.V0, 1));
        add(new Syscall());

        // print a newline
        add(new Li(MIPSRegister.V0, 4));
        add(new La(MIPSRegister.A0, "newline"));
        add(new Syscall());
    }
    
    public void compilePrintStmt(final PrintStmt stmt) {
        compileExpression(stmt.exp);
        assert(expressionOffset == 4);
        pop(MIPSRegister.A0);
        printA0();
    }

    public void compileReturnExpStmt(final ReturnExpStmt stmt) {
        compileExpression(stmt.exp);
        doReturn();
        resetExpressionOffset();
    }

    public void compileReturnVoidStmt(final ReturnVoidStmt stmt) {
        assert(expressionOffset == 0);
        doReturn();
        assert(expressionOffset == 0);
    }

    public void compileWhileStmt(final WhileStmt stmt) {
        // save old start and end, as nested while is possible
        final MIPSLabel oldWhileStart = currentWhileStart;
        final MIPSLabel oldWhileEnd = currentWhileEnd;
        currentWhileStart = freshWhileLabel("start");
        currentWhileEnd = freshWhileLabel("end");

        add(currentWhileStart);
        compileExpression(stmt.guard);

        // Guaranteed that guard is a boolean, from the typechecker.
        // Put it in t0.
        assert(expressionOffset == 4);
        final MIPSRegister t0 = MIPSRegister.T0;
        pop(t0);

        // If the guard is false, go to the end.  Otherwise, fall
        // through to body.
        add(new Beq(t0, MIPSRegister.ZERO, currentWhileEnd));

        compileStatementInNestedScope(true, stmt.body);
        add(new J(currentWhileStart));
        add(currentWhileEnd);

        // restore old start and end
        currentWhileStart = oldWhileStart;
        currentWhileEnd = oldWhileEnd;
    }

    public void compileBreakStmt(final BreakStmt stmt) {
        assert(currentWhileStart != null);
        assert(currentWhileEnd != null);
        assert(currentWhileReset != null);
        freeSizeForVariables(variables.sizeAllocatedSinceResetPoint(currentWhileReset));
        add(new J(currentWhileEnd));
    }

    public void compileStatement(final Stmt stmt) {
        if (stmt instanceof VariableDeclarationInitializationStmt) {
            compileVariableDeclarationInitializationStmt((VariableDeclarationInitializationStmt)stmt);
        } else if (stmt instanceof AssignmentStmt) {
            compileAssignmentStmt((AssignmentStmt)stmt);
        } else if (stmt instanceof SequenceStmt) {
            compileSequenceStmt((SequenceStmt)stmt);
        } else if (stmt instanceof PrintStmt) {
            compilePrintStmt((PrintStmt)stmt);
        } else if (stmt instanceof ReturnExpStmt) {
            compileReturnExpStmt((ReturnExpStmt)stmt);
        } else if (stmt instanceof ReturnVoidStmt) {
            compileReturnVoidStmt((ReturnVoidStmt)stmt);
        } else if (stmt instanceof FunctionCallStmt) {
            compileFunctionCallStmt((FunctionCallStmt)stmt);
        } else if (stmt instanceof IfStmt) {
            compileIfStmt((IfStmt)stmt);
        } else if (stmt instanceof WhileStmt) {
            compileWhileStmt((WhileStmt)stmt);
        } else if (stmt instanceof BreakStmt) {
            compileBreakStmt((BreakStmt)stmt);
        }else {
            assert(false);
        }
    }
    
    // for simplicity, bools and chars are 4 bytes
    public int sizeof(final Type type) {
        if (type instanceof VoidType) {
            return 0;
        } else if (type instanceof IntType ||
                   type instanceof BoolType ||
                   type instanceof PointerType) { // 32-bit word
            return 4;
        } else if (type instanceof StructureType) {
            final LinkedHashMap<FieldName, Type> fields =
                structDecs.get(((StructureType)type).name);
            int sum = 0;
            for (final Type fieldType : fields.values()) {
                sum += sizeof(fieldType);
            }
            assert(sum >= 0);
            assert(sum % 4 == 0);
            return sum;
        } else {
            assert(false);
            return 0;
        }
    } // sizeof

    public void add(final MIPSEntry i) {
        entries.add(i);
    } // add

    // pushes the contents of this register onto the stack
    public void push(final MIPSRegister register) {
        // addi $sp, $sp, -4
        // sw register, 0($sp)
        final MIPSRegister sp = MIPSRegister.SP;
        add(new Addi(sp, sp, -4));
        add(new Sw(register, 0, sp));
        expressionOffset += 4;
    } // push

    // uses $t0 as a temp
    public void pushValue(final int value) {
        pushValue(MIPSRegister.T0, value);
    } // pushValue
    
    public void pushValue(final MIPSRegister temp, final int value) {
        add(new Li(temp, value));
        push(temp);
    } // pushValue
    
    // pops top element of the stack into this register
    public void pop(final MIPSRegister register) {
        // lw register, 0($sp)
        // addi $sp, $sp, 4
        final MIPSRegister sp = MIPSRegister.SP;
        add(new Lw(register, 0, sp));
        add(new Addi(sp, sp, 4));
        expressionOffset -= 4;
    } // pop
    
    public void compileIntExp(final IntExp exp) {
        // push this integer onto the stack
        pushValue(exp.value);
    } // compileIntExp

    // boolean: integer that's 0 (false), or 1 (true)
    public void compileBoolExp(final BoolExp exp) {
        pushValue((exp.value) ? 1 : 0);
    } // compileBoolExp

    // char: integer in the range for a char
    
    public void compileSizeofExp(final SizeofExp exp) {
        pushValue(sizeof(exp.type));
    } // compileSizeof

    
    // This language just passes it along and blindly assumes
    // Depending, on the language, this might do something more
    // clever, like:
    // - Do some conversion (e.g., double -> int)
    // - Emit code that checks at runtime that the type makes sense
    //
    
    public void compileDereferenceExp(final DereferenceExp exp) {
        // since structures have differing size, this can push multiple values
        // on the stack.  Additionally, we need to know what the type of the
        // expression is (thanks typechecker!), which will tell us how much
        // to load in
        final int loadSize = sizeof(exp.getTypeAfterDereference());

        // memory address is on top of stack
        compileExpression(exp.exp);

        // this address is now in $t0
        final MIPSRegister t0 = MIPSRegister.T0;
        pop(t0);

        // Allocate space on the stack for everything.
        final MIPSRegister sp = MIPSRegister.SP;        
        add(new Addi(sp, sp, -loadSize));

        // load in from this address, one word at a time.
        // $t1 is used to read in / write out words.
        // first value of structure will be at offset N, next at N - 4, ... until 0
        final MIPSRegister t1 = MIPSRegister.T1;
        for (int offset = loadSize - 4; offset >= 0; offset -= 4) {
            add(new Lw(t1, offset, t0));
            add(new Sw(t1, offset, sp));
        }

        expressionOffset += loadSize;
    } // compileDereferenceExp
    
    

    public List<Map.Entry<FieldName, Type>> reverseFieldsFor(final StructureName structName) {
        final LinkedHashMap<FieldName, Type> fields = structDecs.get(structName);
        assert(fields != null);

        final List<Map.Entry<FieldName, Type>> asList =
            new ArrayList<Map.Entry<FieldName, Type>>(fields.entrySet());
        Collections.reverse(asList);
        return asList;
    }
    
    public int fieldOffset(final StructureName structureName,
                           final FieldName fieldName) {
        int offset = 0;
        // last value has offset zero
        for (final Map.Entry<FieldName, Type> entry : reverseFieldsFor(structureName)) {
            if (entry.getKey().equals(fieldName)) {
                return offset;
            }
            offset += sizeof(entry.getValue());
        }

        assert(false);
        return 0;
    } // fieldOffset
            
           
    public void compileOp(final MIPSRegister destination,
                          final MIPSRegister left,
                          final Op op,
                          final MIPSRegister right) {
        if (op instanceof PlusOp) {
            add(new Add(destination, left, right));
        } else if (op instanceof MinusOp) {
            add(new Sub(destination, left, right));
        } else if (op instanceof EqualsOp) {
            add(new Seq(destination, left, right));
        } else if (op instanceof LessThanOp) {
            add(new Slt(destination, left, right));
        } else {
            assert(false);
        }
    } // compileOp
    
    // compile left, which pushes onto stack
    // compile right, which pushed onto stack
    // pop both, do the operation, then push result onto stack
    public void compileBinopExp(final BinopExp exp) {
        compileExpression(exp.left);
        compileExpression(exp.right);
        final MIPSRegister t0 = MIPSRegister.T0;
        final MIPSRegister t1 = MIPSRegister.T1;
        pop(t1); // right is on top of the stack...
        pop(t0); // followed by left
        compileOp(t0, t0, exp.op, t1);
        push(t0);
    } // compileBinopExp

    public void compileVariableExp(final VariableExp exp) {
        // copy variable's value to top of stack
        final int size = variables.variableSize(exp.variable);
        assert(size % 4 == 0);
        final int copyFromOffset = variableOffset(exp.variable);
        
        final MIPSRegister sp = MIPSRegister.SP;
        for (int base = 0; base < size; base += 4) {
            final MIPSRegister t0 = MIPSRegister.T0;
            add(new Lw(t0, copyFromOffset + base, sp));
            add(new Sw(t0, -(size - base), sp));
        }
        add(new Addi(sp, sp, -size));
        expressionOffset += size;
    }

    public void compileAddressOfExp(final AddressOfExp exp) {
        final MIPSRegister t0 = MIPSRegister.T0;
        putLhsAddressIntoRegister(t0, exp.lhs);
        push(t0);
    }

    public static MIPSLabel functionNameToLabel(final FunctionName name) {
        return new MIPSLabel(name.name, 0);
    }
    
    // TODO: this does not conform to the typical MIPS calling convention;
    // it puts all arguments on the stack, and returns on the stack, ignoring
    // the $a* and $v* registers
    public void compileFunctionCallExp(final FunctionCallExp exp) {
        final int originalExpressionOffset = expressionOffset;

        // last argument will be on top of the stack
        for (final Exp parameter : exp.parameters) {
            compileExpression(parameter);
        }

        add(new Jal(functionNameToLabel(exp.name)));

        // return value is on stack
        final int returnTypeSize = sizeof(functionDefs.get(exp.name).returnType);
        expressionOffset = originalExpressionOffset + returnTypeSize;
    }

    public void compileFunctionCallStmt(final FunctionCallStmt stmt) {
        final FunctionCallExp exp = stmt.asExp;
        final int returnTypeSize = sizeof(functionDefs.get(exp.name).returnType);
        compileFunctionCallExp(exp);
        // ignore what's on the stack
        final MIPSRegister sp = MIPSRegister.SP;
        add(new Addi(sp, sp, returnTypeSize));
        expressionOffset -= returnTypeSize;
        assert(expressionOffset >= 0);
    }
    
    public void compileExpression(final Exp exp) {
        if (exp instanceof IntExp) {
            compileIntExp((IntExp)exp);
        } else if (exp instanceof BoolExp) {
            compileBoolExp((BoolExp)exp);
        } else if (exp instanceof BinopExp) {
            compileBinopExp((BinopExp)exp);
        } else if (exp instanceof VariableExp) {
            compileVariableExp((VariableExp)exp);
        } else if (exp instanceof SizeofExp) {
            compileSizeofExp((SizeofExp)exp);
        } else if (exp instanceof DereferenceExp) {
            compileDereferenceExp((DereferenceExp)exp);
        } else if (exp instanceof AddressOfExp) {
            compileAddressOfExp((AddressOfExp)exp);
        }else if (exp instanceof FunctionCallExp) {
            compileFunctionCallExp((FunctionCallExp)exp);
        } else {
            assert(false);
        }
    } // compileExpression

    public MIPSEntry[] getEntries() {
        return entries.toArray(new MIPSInstruction[entries.size()]);
    } // getInstructions

    private void mainEnd() {
        // exit
        add(new Li(MIPSRegister.V0, 10));
        add(new Syscall());
    } // mainEnd
    
    public void writeCompleteFile(final File file) throws IOException {
        final PrintWriter output =
            new PrintWriter(new BufferedWriter(new FileWriter(file)));
        mainEnd();
        try {
            output.println(".data");
            output.println("newline:");
            output.println(MIPSInstruction.INDENT + ".asciiz \"\\n\"");
            output.println(".text");
            output.println("main:");
            for (final MIPSEntry entry : entries) {
                output.println(entry.toString());
            }
        } finally {
            output.close();
        }
    } // writeCompleteFile

    // exclusively used in the test suite
    public void setCurrentFunctionForTesting(final FunctionName currentFunction) {
        assert(this.currentFunction == null);
        this.currentFunction = currentFunction;
    } // setCurrentFunctionForTesting
} // MIPSCodeGenerator

