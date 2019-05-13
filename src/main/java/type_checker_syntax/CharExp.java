package type_checker_syntax;

public class CharExp implements Exp {
    public final char value;

    public CharExp(final char value) {
        this.value = value;
    }

    public int hashCode() { return (int)value; }
    public boolean equals(final Object other) {
        return (other instanceof CharExp &&
                ((CharExp)other).value == value);
    }
    public String toString() {
        return Character.toString(value);
    }
}
