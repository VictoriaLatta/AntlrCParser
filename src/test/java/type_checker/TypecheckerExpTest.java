package type_checker;

import type_checker.TypeErrorException;
import type_checker.Typechecker;
import type_checker_syntax.CharType;
import type_checker_syntax.BinopExp;
import type_checker_syntax.PlusOp;
import type_checker_syntax.Exp;
import type_checker_syntax.CastExp;
import type_checker_syntax.CharExp;
import type_checker_syntax.BoolType;
import type_checker_syntax.EqualsOp;
import type_checker_syntax.IntExp;
import type_checker_syntax.Type;
import type_checker_syntax.BoolExp;
import type_checker_syntax.IntType;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import type_checker.TypeErrorException;
import type_checker.Typechecker;

// Tests for expressions that need no scopes.
// This means:
// -No variables
// -No structures
// -No functions
// -No pointers (which depend on variables or structures)
public class TypecheckerExpTest {
    // use null if there should be a type error
    public void assertExpType(final Type expected, final Exp exp) {
        try {
            final Type received = Typechecker.expTypeForTesting(exp);
            assertTrue("Expected type error; got: " + received.toString(),
                       expected != null);
            assertEquals(expected, received);
        } catch (final TypeErrorException e) {
            assertTrue("Unexpected type error: " + e.getMessage(),
                       expected == null);
        }
    }

    @Test
    public void testIntExp() {
        assertExpType(new IntType(),
                      new IntExp(42));
    }

    @Test
    public void testBoolExp() {
        assertExpType(new BoolType(),
                      new BoolExp(true));
    }

    @Test
    public void testBinopPlusInts() {
        assertExpType(new IntType(),
                      new BinopExp(new IntExp(1),
                                   new PlusOp(),
                                   new IntExp(2)));
    }

    @Test
    public void testBinopPlusNonIntOrPointer() {
        assertExpType(null,
                      new BinopExp(new CharExp('a'),
                                   new PlusOp(),
                                   new IntExp(1)));
    }

    @Test
    public void testEqualSameType() {
        assertExpType(new BoolType(),
                      new BinopExp(new CharExp('a'),
                                   new EqualsOp(),
                                   new CharExp('b')));
    }

    @Test
    public void testEqualDifferentTypes() {
        assertExpType(null,
                      new BinopExp(new CharExp('a'),
                                   new EqualsOp(),
                                   new IntExp(1)));
    }

    @Test
    public void testCastWellTypedSubexpression() {
        assertExpType(new IntType(),
                      new CastExp(new IntType(),
                                  new CharExp('a')));
    }

    @Test
    public void testCastIllTypedSubexpression() {
        assertExpType(null,
                      new CastExp(new CharType(),
                                  new BinopExp(new IntExp(1),
                                               new PlusOp(),
                                               new CharExp('a'))));
    }
} // TypecheckerTest
