package code_gen;

public class Sub extends ThreeRegisterInstruction {
    public Sub(final MIPSRegister rd,
               final MIPSRegister rs,
               final MIPSRegister rt) {
        super("sub", rd, rs, rt);
    }
} // Sub
