package code_gen_syntax;

public class PointerType implements Type {
    public final Type pointsTo;
    
    public PointerType(final Type pointsTo) {
        this.pointsTo = pointsTo;
    }

    public int hashCode() { return 1 + pointsTo.hashCode(); }
    public boolean equals(final Object other) {
        return (other instanceof PointerType &&
                ((PointerType)other).pointsTo.equals(pointsTo));
    }
    public String toString() {
        return pointsTo.toString() + "*";
    }
}
