package code_gen_syntax;

public class SizeofExp implements Exp {
    public final Type type;

    public SizeofExp(final Type type) {
        this.type = type;
    }

    public int hashCode() { return type.hashCode(); }
    public boolean equals(final Object other) {
        return (other instanceof SizeofExp &&
                ((SizeofExp)other).type.equals(type));
    }
    public String toString() {
        return "sizeof(" + type.toString() + ")";
    }
}
