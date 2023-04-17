package Calculator;

import Calculator.RationalScalar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class tests {
    @Test
    public void testRationals(){
        RationalScalar a = new RationalScalar(6, 9);
        RationalScalar b = new RationalScalar(4, 2);
        RationalScalar c = new RationalScalar(2, 3);
        RationalScalar d = new RationalScalar(3);
        assertEquals(new RationalScalar(2,3), c);
        assertNotEquals(new RationalScalar(1,1), a);
        assertEquals(new RationalScalar(2,1), b);
        assertNotEquals(new RationalScalar(3,1), b);
        assertEquals(new RationalScalar(2,3), c);
        assertEquals(new RationalScalar(3,1), d); // test for constructor with only one parameter
        assertNotEquals(new RationalScalar(2,1), d);
        assertEquals(new RationalScalar(2,3), c.reduce());
        assertNotEquals(new RationalScalar(1,1), a.reduce());
        assertEquals(new RationalScalar(2,1), b.reduce()); // test for reduce()
        assertNotSame(new RationalScalar(2,1), b.reduce());
        assertEquals(new RationalScalar(2,1), b.reduce(4,2)); // test for reduce(int a, int b)
        assertNotSame(new RationalScalar(2,1), b.reduce(4,2));
        assertEquals(new RationalScalar(3,1), d.reduce());

    }

    @Test
    public void testPolynomial(){

    }
    @Test
    private void testCalculator(){

    }
//    @Test
//    private void testMonomial(){
//        Calculator.Monomial a = new Calculator.Monomial(2, 3);
//        Calculator.Monomial b = new Calculator.Monomial(3, 4);
//        Calculator.Monomial c = new Calculator.Monomial(4, 5);
//        assertEquals(new Calculator.Monomial(2, 3), a);
//        assertNotEquals(new Calculator.Monomial(3, 4), a);
//        assertEquals(new Calculator.Monomial(3, 4), b);
//        assertNotEquals(new Calculator.Monomial(4, 5), b);
//        assertEquals(new Calculator.Monomial(4, 5), c);
//        assertNotEquals(new Calculator.Monomial(2, 3), c);
//    }
}
