package code_gen_syntax;

public class IntType implements Type {
    public int hashCode() { return 0; }
    public boolean equals(final Object other) {
        return other instanceof IntType;
    }
    public String toString() { return "int"; }
}
