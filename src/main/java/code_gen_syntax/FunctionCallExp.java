package code_gen_syntax;

import java.util.Arrays;

public class FunctionCallExp implements Exp {
    public final FunctionName name;
    public final Exp[] parameters;

    public FunctionCallExp(final FunctionName name,
                           final Exp[] parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public int hashCode() {
        return name.hashCode() + Arrays.deepHashCode(parameters);
    }

    public boolean equals(final Object other) {
        if (other instanceof FunctionCallExp) {
            final FunctionCallExp otherExp = (FunctionCallExp)other;
            return (otherExp.name.equals(name) &&
                    Arrays.deepEquals(parameters,
                                      otherExp.parameters));
        } else {
            return false;
        }
    }
    
    public String toString() {
        return (name.toString() + "(" +
                Join.join(", ", parameters) + ")");
    }
}
