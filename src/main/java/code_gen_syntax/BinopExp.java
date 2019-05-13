package code_gen_syntax;

public class BinopExp implements Exp {
    public final Exp left;
    public final Op op;
    public final Exp right;

    public BinopExp(final Exp left,
                    final Op op,
                    final Exp right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public int hashCode() {
        return (left.hashCode() +
                op.hashCode() +
                right.hashCode());
    }

    public boolean equals(final Object other) {
        if (other instanceof BinopExp) {
            final BinopExp otherBinop = (BinopExp)other;
            return (otherBinop.left.equals(left) &&
                    otherBinop.op.equals(op) &&
                    otherBinop.right.equals(right));
        } else {
            return false;
        }
    }

    public String toString() {
        return ("(" + left.toString() +
                " " + op.toString() + " " +
                right.toString() + ")");
    }
}

                    
