package code_gen_syntax;

public class AddressOfExp implements Exp {
    public final Lhs lhs;

    public AddressOfExp(final Lhs lhs) {
        this.lhs = lhs;
    }

    public int hashCode() { return lhs.hashCode(); };
    public boolean equals(final Object other) {
        return (other instanceof AddressOfExp &&
                ((AddressOfExp)other).lhs.equals(lhs));
    }
    public String toString() {
        return "&" + lhs.toString();
    }
}
