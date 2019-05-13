package code_gen;

public class VariableTableResetPoint {
    public final int resetTo;

    public VariableTableResetPoint(final int resetTo) {
        this.resetTo = resetTo;
    }

    public int hashCode() {
        return resetTo;
    }

    public boolean equals(final Object other) {
        return (other instanceof VariableTableResetPoint &&
                ((VariableTableResetPoint)other).resetTo == resetTo);
    }

    public String toString() {
        return "VariableTableResetPoint(" + resetTo + ")";
    }
} // VariableTableResetPoint
