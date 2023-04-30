package Tests;
import Polynomial.Monomial;
import Polynomial.Scalar.*;
import org.junit.jupiter.api.Assertions;
import Tests.TestsMain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestsMain {
    // -------------------------- variables --------------------------------
    static Scalar i0 = new IntegerScalar(1);
    static Scalar i1 = new IntegerScalar(2);
    static Scalar i2 = new IntegerScalar(10);
    static Scalar i3 = new IntegerScalar(-5);
    static Scalar i4 = new IntegerScalar(0);
    static Scalar i5 = new IntegerScalar(-3);
    static Scalar i6 = new IntegerScalar(100);
    static Scalar i7 = new IntegerScalar(42);
    static Scalar i8 = new IntegerScalar(-10);
    static Scalar i9 = new IntegerScalar(41);
    static Scalar i10 = new IntegerScalar(12);
    static Scalar r0 = new RationalScalar(7, 9);
    static Scalar r1 = new RationalScalar(0, 3);
    static Scalar r2 = new RationalScalar(2, -3);
    static Scalar r3 = new RationalScalar(-4, 7);
    static Scalar r4 = new RationalScalar(-2, 3);
    static Scalar r5 = new RationalScalar(1, 2);
    static Scalar r6 = new RationalScalar(-1, 3);
    static Scalar r7 = new RationalScalar(5, 8);
    static Scalar r8 = new RationalScalar(19, 7);
    static Scalar r9 = new RationalScalar(1, 2);
    static Scalar r10 = new RationalScalar(4, 9);
    public static final Scalar[] varArray = {i0, r0, i1, r1, i2, r2, i3, r3, i4, r4, i5, r5, i6, r6, i7, r7, i8, r8, i9, r9, i10, r10};
    //0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,  21

// ------------------------ Scalar Tests ----------------------------

    @Test
    public void testIntegerScalar() {
        System.out.println("Starting testIntegerScalar()");
        IntegerScalar s = new IntegerScalar(5);
        assertEquals(5, s.getNumber());
        IntegerScalar s2 = new IntegerScalar(-5);
        assertEquals(-5, s2.getNumber());
        IntegerScalar s3 = new IntegerScalar(0);
        assertEquals(0, s3.getNumber());
        IntegerScalar s4 = new IntegerScalar(6 / 3); // 6/3 = 2 check if constructor handles this
        assertEquals(2, s4.getNumber());
        IntegerScalar s5 = new IntegerScalar(6 / 4); // 6/4 = 1 check if constructor handles this, int rounds down
        assertEquals(1, s5.getNumber());
        //IntegerScalar s6 = new IntegerScalar((int) 1.5); // useless test because of forced casting by constructor
        IntegerScalar s7 = new IntegerScalar(5 / 2); // 5/2 = 2 check if constructor handles this, int rounds down
        System.out.println("Finished testIntegerScalar()\n");
    }

    @Test
    public void testRationalScalar() {
        // Not testing for 0 denominator because assignment says we don't check for this because we are big bois.
        System.out.println("Starting testRationalScalar()");
        RationalScalar s = new RationalScalar(5, 2);
        assertEquals(5, s.getNumerator());
        assertEquals(2, s.getDenominator());
        RationalScalar s2 = new RationalScalar(-5, 2);
        assertEquals(-5, s2.getNumerator());
        assertEquals(2, s2.getDenominator());
        RationalScalar s3 = new RationalScalar(5, -2); // check opposite signs to previous test
        assertEquals(-5, s3.getNumerator());
        assertEquals(2, s3.getDenominator());
        RationalScalar s4 = new RationalScalar(-5, -2); // check both negative signs
        assertEquals(5, s4.getNumerator());
        assertEquals(2, s4.getDenominator());
        RationalScalar s5 = new RationalScalar(0, 2);
        assertEquals(0, s5.getNumerator());
        assertEquals(1, s5.getDenominator());
        RationalScalar s6 = new RationalScalar(5, 1);
        assertEquals(5, s6.getNumerator());
        assertEquals(1, s6.getDenominator());
        RationalScalar s7 = new RationalScalar(5, 5);
        assertEquals(1, s7.getNumerator());
        assertEquals(1, s7.getDenominator());
        RationalScalar s8 = new RationalScalar(6 / 3, 2); // 6/3 = 2 check if constructor handles this
        assertEquals(1, s8.getNumerator());
        assertEquals(1, s8.getDenominator());
        assertNotEquals(2, s8.getNumerator());
        assertNotEquals(2, s8.getDenominator());
        RationalScalar s9 = new RationalScalar(6 / 4, 2); // 6/4 = 1 check if constructor handles this, int rounds down
        assertEquals(1, s9.getNumerator());
        assertEquals(2, s9.getDenominator());
        assertNotEquals((float) 3 / 2, s9.getNumerator());
        assertNotEquals(1, s9.getDenominator());
        System.out.println("Finished testRationalScalar()\n");
    }

    @Test
    public void testAdd() {
        // Calculated to be 205/21.
        // The only issue we had here was that the reduce() method was not called.
        // This raises the question will this test work if reduce actually reduced the fraction?
        // For this test, 205/21 is the the smallest fraction this result can be.
        // So, if reduce() is called, the test will still pass... but also if reduce() is not called, the test will pass.
        // This means we need to add another test to check if reduce() is called, does the test still pass?
        // Indexes were changed and the new result of the first test is 475/63.
        System.out.println("Starting testAdd()");
        Scalar result = varArray[0];
        System.out.println("First test: (result should be 475/63)");
        for (int i = 1; i < 8; i++) {
            result = result.add(varArray[i]).reduce();
            System.out.printf("i: %d %s\n", i, result);
        }
        assertEquals(new RationalScalar(475, 63), result);

        // Second test including reduce in mind. Calculated to be 1113/8.
        // Passed the test.
        result = varArray[8];
        System.out.println("Second test: (result should be 1113/8)");
        for (int i = 9; i < 16; i++) {
            result = result.add(varArray[i]).reduce();
            System.out.printf("i: %d %s\n", i, result);
        }
        assertEquals(new RationalScalar(1113, 8), result);
        System.out.println("Finished testAdd()\n");
    }

    @Test
    public void testMul() {
        // Calculated to be 0. actual value is 0/1944.
        // 0/1944 is the correct answer, but the test fails because the reduce() method is not called.
        // added if statement to reduce() method to fix this.
        // issue persists - raises the question - does the denominator need to be 1? does 0 even have a denominator?
        // TODO: ask about this. ^^^
        // Adding another test to check scenario where the answer is not 0.

        System.out.println("Starting testMul()");
        System.out.println("First test: (result should be 0)");
        Scalar result = varArray[8];
        for (int i = 9; i < 16; i++) {
            result = result.mul(varArray[i]).reduce();
            System.out.printf("i: %d %s\n", i, result);
        }
        assertEquals(new RationalScalar(0), result);

        // Second test does not result in 0. Calculated to be -62320/21.
        // Passed the test.
        System.out.println("Second test: (result should be -62320/21)");
        result = varArray[16];
        for (int i = 17; i < 22; i++) {
            result = result.mul(varArray[i]).reduce();
            System.out.printf("i: %d %s\n", i, result);
        }
        assertEquals(new RationalScalar(-62320, 21), result);
        System.out.println("Finished testMul()\n");
    }

    @Test
    public void testNeg_Sign() {
        // At start, was confusing how to test these methods.
        // Decided to test if the sign of the result is the opposite of the sign of the original while testing the
        // sign() method at the same time.
        // This test is dependent, meaning if one fails, the other method will fail as well.
        Scalar result;
        System.out.println("Starting testNeg_Sign()");
        System.out.println("First test: ");
        for (int i = 0; i < varArray.length; i++) {
            result = varArray[i].neg().reduce();
            System.out.printf("i: %d %s\n", i, result);
            assertEquals(varArray[i].sign(), -1 * result.sign()); // testing for opposite signs
            if (varArray[i].sign() == 0) {
                // If equals 0 then assertNotEquals basically does nothing. Also tested in assertEquals, so we skip.
                continue;
            } else {
                assertNotEquals(varArray[i].sign(), result.sign()); // testing for same signs
            }
        }
        System.out.println("Finished testNeg_Sign()... not much to test here ¯\\_(ツ)_/¯\n");
    }

    @Test
    public void testPower() {
        Scalar result;
        System.out.println("Starting testPower()");
        System.out.println("First test: ");
        for (int i = 0; i < varArray.length; i++) {
            result = varArray[i].power(2).reduce();
            System.out.printf("i: %d %s\n", i, result);
            assertEquals(varArray[i].mul(varArray[i]).reduce(), result);
        }
        System.out.println("Finished testPower()\n");
    }

    @Test
    public void testEquals() {
        // TODO am not sure how to implement this method.
        // really dont know wtf is going on here and what to do.
        Scalar result;
        System.out.println("Starting testEquals()");
        System.out.println("First test: ");
        for (int i = 0; i < varArray.length; i++) {
            result = varArray[i].reduce();
            System.out.printf("i: %d %s\n", i, result);
            assertEquals(varArray[i].reduce().toString(), result.reduce().toString());
        }
        System.out.println("Finished testEquals()\n");
    }

    @Test
    public void testDerivative() {
        // TODO am not sure how to implement this method.
        // Not the same value when comparing Monomial to Polynomial.
        Polynomial.Polynomial result;
        Monomial toTest;
        System.out.println("Starting testDerivative()");
        System.out.println("First test: ");
        for (int i = 0; i < varArray.length; i++) {
            result = Polynomial.Polynomial.build("0 0 " + new Monomial(varArray[i], 0).getCoefficient().toString()).derivative();
            System.out.printf("i: %d %s\n", i, result);
            toTest = new Monomial(varArray[i], 2).derivative();
            assertEquals(toTest, result + "^1");
        }
        System.out.println("Finished testDerivative()\n");
    }

    @Test
    public void testReduce() {
        // TODO am not sure how to implement this method.
        // what is the correct what to check this method?
        Scalar result;
        System.out.println("Starting testReduce()");
        System.out.println("First test: ");
        for (int i = 0; i < varArray.length; i++) {
            result = varArray[i].reduce();
            System.out.printf("i: %d %s\n", i, result);
            assertEquals(varArray[i], result);
        }
        System.out.println("Finished testReduce()\n");
    }

    @Test
    public void testEvaluate() {
        // TODO am not sure how to implement this method.
        // didnt even look into this one
        Scalar result;
        System.out.println("Starting testEvaluate()");
        System.out.println("First test: ");
        for (int i = 0; i < varArray.length; i++) {
            result = varArray[i];//.evaluate()
            System.out.printf("i: %d %s\n", i, result);
            assertEquals(varArray[i], result);
        }
        System.out.println("Finished testEvaluate()\n");
    }
}


