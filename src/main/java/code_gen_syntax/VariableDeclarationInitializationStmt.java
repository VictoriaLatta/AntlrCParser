package code_gen_syntax;

public class VariableDeclarationInitializationStmt implements Stmt {
    public final VariableDeclaration varDec;
    public final Exp exp;
    
    public VariableDeclarationInitializationStmt(final VariableDeclaration varDec,
                                                 final Exp exp) {
        this.varDec = varDec;
        this.exp = exp;
    }

    public int hashCode() {
        return varDec.hashCode() + exp.hashCode();
    }

    public boolean equals(final Object other) {
        if (other instanceof VariableDeclarationInitializationStmt) {
            final VariableDeclarationInitializationStmt otherStmt =
                (VariableDeclarationInitializationStmt)other;
            return (otherStmt.varDec.equals(varDec) &&
                    otherStmt.exp.equals(exp));
        } else {
            return false;
        }
    }

    public String toString() {
        return varDec.toString() + " = " + exp.toString();
    }
}

                                                 
