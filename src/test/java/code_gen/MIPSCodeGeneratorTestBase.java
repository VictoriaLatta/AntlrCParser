package code_gen;

import code_gen_syntax.FieldName;
import code_gen_syntax.FunctionName;
import code_gen_syntax.Type;
import code_gen_syntax.StructureName;
import code_gen_syntax.FunctionDefinition;
import code_gen.MIPSCodeGenerator;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.*;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.rules.TestName;

public abstract class MIPSCodeGeneratorTestBase<A> {
    @Rule public TestName name = new TestName();

    public int parseOutput(final String[] spimOutput) {
        assert(spimOutput.length == 2);
        return Integer.parseInt(spimOutput[1]);
    } // parseOutput

    public void assertResult(final File expected,
                             final A compileMe,
                             final Map<StructureName, LinkedHashMap<FieldName, Type>> structDecs,
                             final Map<FunctionName, FunctionDefinition> functionDefs) throws IOException {
        

        final File outputFile = new File("src//outPut.txt");
        
            final MIPSCodeGenerator gen = new MIPSCodeGenerator(structDecs, functionDefs);
            doCompile(gen, compileMe);
            gen.writeCompleteFile(outputFile);
            boolean isTwoEqual = FileUtils.contentEquals(expected, outputFile);
            assertEquals(true, isTwoEqual);
    }

    public void assertResult(final File expected,
                             final A compileMe,
                             final Map<StructureName, LinkedHashMap<FieldName, Type>> structDecs) throws IOException {
        assertResult(expected, compileMe, structDecs, new HashMap<FunctionName, FunctionDefinition>());
    }

    public void assertResult(final File expected,
                             final A compileMe) throws IOException {
        assertResult(expected, compileMe, new HashMap<StructureName, LinkedHashMap<FieldName, Type>>());
    }
    
    // ---BEGIN ABSTRACT METHODS---
    protected abstract void doCompile(MIPSCodeGenerator gen, A input);
    // ---END ABSTRACT METHODS---
} // MIPSCodeGeneratorTestBase
