package code_gen_syntax;

import java.util.Arrays;

public class Program {
    
    public final FunctionDefinition[] functionDefs;

    public Program(final FunctionDefinition[] functionDefs) {
       
        this.functionDefs = functionDefs;
    }

    public int hashCode() {
        return (Arrays.deepHashCode(functionDefs));
    }

    public boolean equals(final Object other) {
        if (other instanceof Program) {
            final Program otherProgram = (Program)other;
            return (Arrays.deepEquals(otherProgram.functionDefs, functionDefs));
        } else {
            return false;
        }
    }

    public String toString() {
        return (Join.join("\n", functionDefs) + "\n");
    }
}
