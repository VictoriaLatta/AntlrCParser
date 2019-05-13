package code_gen;

public class Jal extends SingleLabelInstruction {
    public Jal(final MIPSLabel label) {
        super("jal", label);
    }
} // Jal
