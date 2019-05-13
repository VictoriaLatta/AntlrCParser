package code_gen;

public class MIPSComment implements MIPSEntry {
    public final String comment;

    public MIPSComment(final String comment) {
        this.comment = comment;
    }

    public String toString() {
        return "; " + comment;
    }

    public int hashCode() {
        return comment.hashCode();
    }

    public boolean equals(final Object other) {
        return (other instanceof MIPSComment &&
                ((MIPSComment)other).comment.equals(comment));
    }
}
