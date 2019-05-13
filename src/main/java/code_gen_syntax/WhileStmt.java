package code_gen_syntax;

public class WhileStmt implements Stmt {
    public final Exp guard;
    public final Stmt body;

    public WhileStmt(final Exp guard,
                     final Stmt body) {
        this.guard = guard;
        this.body = body;
    }

    public int hashCode() {
        return guard.hashCode() + body.hashCode();
    }

    public boolean equals(final Object other) {
        if (other instanceof WhileStmt) {
            final WhileStmt otherWhile = (WhileStmt)other;
            return (otherWhile.guard.equals(guard) &&
                    otherWhile.body.equals(body));
        } else {
            return false;
        }
    }

    public String toString() {
        return ("while (" + guard.toString() +
                ") { " + body.toString() + " }");
    }
}
