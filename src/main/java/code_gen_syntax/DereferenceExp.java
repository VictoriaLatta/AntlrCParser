package code_gen_syntax;

public class DereferenceExp implements Exp {
    public final Exp exp;
    private Type typeAfterDereference; // typechecker is expected to fill this in
    
    public DereferenceExp(final Exp exp) {
        this.exp = exp;
        typeAfterDereference = null;
    }

    public int hashCode() { return exp.hashCode(); }
    public boolean equals(final Object other) {
        return (other instanceof DereferenceExp &&
                ((DereferenceExp)other).exp.equals(exp));
    }
    public String toString() {
        return "*" + exp.toString();
    }

    public Type getTypeAfterDereference() {
        assert(typeAfterDereference != null);
        return typeAfterDereference;
    }

    public void setTypeAfterDereference(final Type typeAfterDereference) {
        assert(typeAfterDereference != null);
        this.typeAfterDereference = typeAfterDereference;
    }    
} // DereferenceExp
