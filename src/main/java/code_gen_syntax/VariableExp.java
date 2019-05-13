package code_gen_syntax;

public class VariableExp implements Exp {
    public final Variable variable;

    public VariableExp(final Variable variable) {
        this.variable = variable;
    }

    public int hashCode() { return variable.hashCode(); }
    public boolean equals(final Object other) {
        return (other instanceof VariableExp &&
                ((VariableExp)other).variable.equals(variable));
    }
    public String toString() { return variable.toString(); }
}

