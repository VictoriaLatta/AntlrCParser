package code_gen;

public class Jr extends SingleRegisterInstruction {
    public Jr(final MIPSRegister rd) {
        super("jr", rd);
    }
}
