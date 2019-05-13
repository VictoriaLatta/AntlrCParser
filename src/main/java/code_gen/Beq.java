package code_gen;

public class Beq implements MIPSInstruction {
    public final MIPSRegister rs;
    public final MIPSRegister rd;
    public final MIPSLabel jumpTo;

    public Beq(final MIPSRegister rs,
               final MIPSRegister rd,
               final MIPSLabel jumpTo) {
        this.rs = rs;
        this.rd = rd;
        this.jumpTo = jumpTo;
    }

    public String toString() {
        return (MIPSInstruction.INDENT + "beq " +
                rs.toString() + ", " +
                rd.toString() + ", " +
                jumpTo.getName());
    }

    public boolean equals(final Object other) {
        if (other instanceof Beq) {
            final Beq asBeq = (Beq)other;
            return (asBeq.rs.equals(rs) &&
                    asBeq.rd.equals(rd) &&
                    asBeq.jumpTo.equals(jumpTo));
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (rs.hashCode() +
                rd.hashCode() +
                jumpTo.hashCode());
    }
}
