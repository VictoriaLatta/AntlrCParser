package code_gen_syntax;

public class PlusOp implements Op {
    public int hashCode() { return 0; }
    public boolean equals(final Object other) {
        return other instanceof PlusOp;
    }
    public String toString() { return "+"; }
}

