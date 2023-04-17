package Calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerScalarTest {

    @Test
    void testAdd() {
        Scalar s1 = new IntegerScalar(5);
        Scalar s2 = new IntegerScalar(3);
        Scalar s3 = new IntegerScalar(-2);
        Scalar result = s1.add(s2);
        Assertions.assertEquals(new IntegerScalar(8), result);
        result = s1.add(s3);
        Assertions.assertEquals(new IntegerScalar(3), result);
    }

    @Test
    void testMul() {
        Scalar s1 = new IntegerScalar(5);
        Scalar s2 = new IntegerScalar(3);
        Scalar s3 = new IntegerScalar(-2);
        Scalar result = s1.mul(s2);
        Assertions.assertEquals(new IntegerScalar(15), result);
        result = s1.mul(s3);
        Assertions.assertEquals(new IntegerScalar(-10), result);
    }

    @Test
    void testNeg() {
        Scalar s1 = new IntegerScalar(5);
        Scalar result = s1.neg();
        Assertions.assertEquals(new IntegerScalar(-5), result);
    }

    @Test
    void testPower() {
        Scalar s1 = new IntegerScalar(5);
        Scalar result = s1.power(3);
        Assertions.assertEquals(new IntegerScalar(125), result);
    }

    @Test
    void testSign() {
        Scalar s1 = new IntegerScalar(5);
        Scalar s2 = new IntegerScalar(-3);
        Scalar s3 = new IntegerScalar(0);
        Assertions.assertEquals(1, s1.sign());
        Assertions.assertEquals(-1, s2.sign());
        Assertions.assertEquals(0, s3.sign());
    }

    @Test
    void testEquals() {
        Scalar s1 = new IntegerScalar(5);
        Scalar s2 = new IntegerScalar(5);
        Scalar s3 = new IntegerScalar(-2);
        Assertions.assertTrue(s1.equals(s2));
        Assertions.assertFalse(s1.equals(s3));
    }

    @Test
    void testToString() {
        Scalar s1 = new IntegerScalar(5);
        Assertions.assertEquals("5", s1.toString());
    }
}
