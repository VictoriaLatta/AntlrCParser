package code_gen_syntax;

public class IntExp implements Exp {
    public final int value;

    public IntExp(final int value) {
        this.value = value;
    }

    public int hashCode() { return value; }
    public boolean equals(final Object other) {
        return (other instanceof IntExp &&
                ((IntExp)other).value == value);
    }
    public String toString() {
        return Integer.toString(value);
    }
}
