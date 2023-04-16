import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class tests {
    @Test
    public void testRationals(){
        Rational a = new Rational(6, 9);
        Rational b = new Rational(4, 2);
        Rational c = new Rational(2, 3);
        Assertions.assertEquals(new Rational(2,3), c.reduce());
    }
}
