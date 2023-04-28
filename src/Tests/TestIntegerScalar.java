package Tests;
import Polynomial.Scalar.*;
import org.junit.jupiter.api.Assertions;
import Tests.TestsMain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIntegerScalar {
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
        System.out.println("First test:");
        for (int i = 1 ; i < 8; i++) {
            result = result.add(varArray[i]).reduce();
            System.out.printf("i: %d %s\n",i ,result);
        }
        assertEquals(new RationalScalar(475, 63), result);

        // Second test including reduce in mind. Calculated to be 1113/8.
        // Passed the test.
        result = varArray[8];
        System.out.println("Second test:");
        for (int i = 9 ; i < 16; i++) {
            result = result.add(varArray[i]).reduce();
            System.out.printf("i: %d %s\n",i ,result);
        }
        assertEquals(new RationalScalar(1113, 8), result);
        System.out.println();
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
        System.out.println("First test:");
        Scalar result = varArray[8];
        for (int i = 9 ; i < 16; i++) {
            result = result.mul(varArray[i]).reduce();
            System.out.printf("i: %d %s\n",i ,result);
        }
        assertEquals(new RationalScalar(0), result);

        // Second test does not result in 0. Calculated to be -62320/21.
        // Passed the test.
        System.out.println("Second test:");
        result = varArray[16];
        for (int i = 17 ; i < 22; i++) {
            result = result.mul(varArray[i]).reduce();
            System.out.printf("i: %d %s\n",i ,result);
        }
        assertEquals(new RationalScalar(-62320, 21), result);
    }
}
