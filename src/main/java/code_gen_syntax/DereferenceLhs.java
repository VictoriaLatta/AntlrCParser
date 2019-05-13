package code_gen_syntax;

public class DereferenceLhs implements Lhs {
    public final Lhs lhs;
    private Type typeAfterDereference; // typechecker is expected to fill this in
    
    public DereferenceLhs(final Lhs lhs) {
        this.lhs = lhs;
        typeAfterDereference = null;
    }

    public int hashCode() {
        return 1 + lhs.hashCode();
    }

    public boolean equals(final Object other) {
        return (other instanceof DereferenceLhs &&
                ((DereferenceLhs)other).lhs.equals(lhs));
    }

    public String toString() {
        return "*" + lhs.toString();
    }

    public Type getTypeAfterDereference() {
        assert(typeAfterDereference != null);
        return typeAfterDereference;
    }

    public void setTypeAfterDereference(final Type typeAfterDereference) {
        assert(typeAfterDereference != null);
        this.typeAfterDereference = typeAfterDereference;
    }    
}
