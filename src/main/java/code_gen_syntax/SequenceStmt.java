package code_gen_syntax;

public class SequenceStmt implements Stmt {
    public final Stmt first;
    public final Stmt second;

    public SequenceStmt(final Stmt first,
                        final Stmt second) {
        this.first = first;
        this.second = second;
    }

    public int hashCode() {
        return first.hashCode() + second.hashCode();
    }

    public boolean equals(final Object other) {
        if (other instanceof SequenceStmt) {
            final SequenceStmt otherStmt = (SequenceStmt)other;
            return (otherStmt.first.equals(first) &&
                    otherStmt.second.equals(second));
        } else {
            return false;
        }
    }

    public String toString() {
        return first.toString() + "; " + second.toString();
    }
}
