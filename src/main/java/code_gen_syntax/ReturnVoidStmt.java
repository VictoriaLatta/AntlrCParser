package code_gen_syntax;

public class ReturnVoidStmt implements Stmt {
    public int hashCode() { return 2; }
    public boolean equals(final Object other) {
        return other instanceof ReturnVoidStmt;
    }
    public String toString() { return "return"; }
}
