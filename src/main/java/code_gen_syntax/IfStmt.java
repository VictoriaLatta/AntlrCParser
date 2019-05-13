package code_gen_syntax;

public class IfStmt implements Stmt {
    public final Exp guard;
    public final Stmt ifTrue;
    public final Stmt ifFalse;

    public IfStmt(final Exp guard,
                  final Stmt ifTrue,
                  final Stmt ifFalse) {
        this.guard = guard;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    public int hashCode() {
        return (guard.hashCode() +
                ifTrue.hashCode() +
                ifFalse.hashCode());
    }

    public boolean equals(final Object other) {
        if (other instanceof IfStmt) {
            final IfStmt otherStmt = (IfStmt)other;
            return (otherStmt.guard.equals(guard) &&
                    otherStmt.ifTrue.equals(ifTrue) &&
                    otherStmt.ifFalse.equals(ifFalse));
        } else {
            return false;
        }
    }

    public String toString() {
        return ("if (" + guard.toString() + ") { " +
                ifTrue.toString() + " } else { " +
                ifFalse.toString() + "}");
    }
}
