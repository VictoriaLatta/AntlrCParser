package code_gen_syntax;

import java.util.Arrays;

public class FunctionDefinition {
    public final Type returnType;
    public final FunctionName name;
    public final VariableDeclaration[] parameters;
    public final Stmt body;

    public FunctionDefinition(final Type returnType,
                              final FunctionName name,
                              final VariableDeclaration[] parameters,
                              final Stmt body) {
        this.returnType = returnType;
        this.name = name;
        this.parameters = parameters;
        this.body = body;
    }

    public int hashCode() {
        return (returnType.hashCode() +
                name.hashCode() +
                Arrays.deepHashCode(parameters) +
                body.hashCode());
    }

    public boolean equals(final Object other) {
        if (other instanceof FunctionDefinition) {
            final FunctionDefinition otherDef =
                (FunctionDefinition)other;
            return (otherDef.returnType.equals(returnType) &&
                    otherDef.name.equals(name) &&
                    Arrays.deepEquals(otherDef.parameters, parameters) &&
                    otherDef.body.equals(body));
        } else {
            return false;
        }
    }

    public String toString() {
        return (returnType.toString() + " " +
                name.toString() + "(" +
                Join.join(", ", parameters) +
                ") { " + body.toString() + " }");
    }
}
