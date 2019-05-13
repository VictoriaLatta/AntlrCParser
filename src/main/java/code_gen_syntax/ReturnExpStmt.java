package code_gen_syntax;

public class ReturnExpStmt implements Stmt {
    public final Exp exp;

    public ReturnExpStmt(final Exp exp) {
        this.exp = exp;
    }

    public int hashCode() { return exp.hashCode(); }

    public boolean equals(final Object other) {
        return (other instanceof ReturnExpStmt &&
                ((ReturnExpStmt)other).exp.equals(exp));
    }

    public String toString() {
        return "return " + exp.toString();
    }
}
