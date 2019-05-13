package code_gen_syntax;

public class LessThanOp implements Op {
    public int hashCode() { return 5; }
    public boolean equals(final Object other) {
        return other instanceof LessThanOp;
    }
    public String toString() { return "<"; }
}

