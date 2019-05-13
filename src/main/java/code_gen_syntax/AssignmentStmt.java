package code_gen_syntax;

public class AssignmentStmt implements Stmt {
    public final Lhs lhs;
    public final Exp exp;

    public AssignmentStmt(final Lhs lhs, final Exp exp) {
        this.lhs = lhs;
        this.exp = exp;
    }

    public int hashCode() {
        return lhs.hashCode() + exp.hashCode();
    }

    public boolean equals(final Object other) {
        if (other instanceof AssignmentStmt) {
            final AssignmentStmt otherStmt = (AssignmentStmt)other;
            return (otherStmt.lhs.equals(lhs) &&
                    otherStmt.exp.equals(exp));
        } else {
            return false;
        }
    }

    public String toString() {
        return lhs.toString() + " = " + exp.toString();
    }
}
