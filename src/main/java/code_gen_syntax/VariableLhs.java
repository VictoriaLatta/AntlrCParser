package code_gen_syntax;

public class VariableLhs implements Lhs {
    public final Variable variable;

    public VariableLhs(final Variable variable) {
        this.variable = variable;
    }

    public int hashCode() { return 1 + variable.hashCode(); }
    public boolean equals(final Object other) {
        return (other instanceof VariableLhs &&
                ((VariableLhs)other).variable.equals(variable));
    }
    public String toString() { return variable.toString(); }
}
