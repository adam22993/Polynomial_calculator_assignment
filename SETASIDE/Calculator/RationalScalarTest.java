package Calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class RationalScalarTest {
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
        Assertions.assertNotSame(new RationalScalar(2,1), b.reduce());
        assertEquals(new RationalScalar(2,1), b.reduce(4,2)); // test for reduce(int a, int b)
        Assertions.assertNotSame(new RationalScalar(2,1), b.reduce(4,2));
        assertEquals(new RationalScalar(3,1), d.reduce());

    }
}
