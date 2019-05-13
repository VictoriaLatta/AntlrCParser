package code_gen_syntax;

public class VariableDeclaration {
    public final Type type;
    public final Variable variable;

    public VariableDeclaration(final Type type,
                               final Variable variable) {
        this.type = type;
        this.variable = variable;
    }

    public int hashCode() {
        return type.hashCode() + variable.hashCode();
    }

    public boolean equals(final Object other) {
        if (other instanceof VariableDeclaration) {
            final VariableDeclaration otherVar = (VariableDeclaration)other;
            return (otherVar.type.equals(type) &&
                    otherVar.variable.equals(variable));
        } else {
            return false;
        }
    }

    public String toString() {
        return type.toString() + " " + variable.toString();
    }
}
