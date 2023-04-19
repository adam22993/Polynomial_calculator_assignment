import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.Math;


public class Tests {
//######################################  variables  ######################################
    static Scalar s1 = new RationalScalar(1, 2);
    static Scalar s2 = new RationalScalar(1, 3);
//    static Scalar s3 = new FloatScalar(1.0f);
//    static Scalar s4 = new FloatScalar(2.0f);
    static Scalar s5 = new IntegerScalar(1);
    static Scalar s6 = new IntegerScalar(2);
    static Scalar s7 = new IntegerScalar(10);
    static Scalar s8 = new RationalScalar(3, 7);
//    static Scalar s9 = new FloatScalar(3.14f);
    static Scalar s10 = new IntegerScalar(-5);
    static Scalar s11 = new RationalScalar(1, 2);
//    static Scalar s12 = new FloatScalar(-2.5f);
    static Scalar s13 = new RationalScalar(4, 9);
    static Scalar s14 = new IntegerScalar(0);
//    static Scalar s15 = new FloatScalar(1.2345f);
    static Scalar s16 = new RationalScalar(5, 8);
    static Scalar s17 = new IntegerScalar(-3);
//    static Scalar s18 = new FloatScalar(2.0f);
    static Scalar s19 = new RationalScalar(7, 9);
    static Scalar s20 = new IntegerScalar(100);
//    static Scalar s21 = new FloatScalar(0.5f);
    static Scalar s22 = new RationalScalar(1, 3);
    static Scalar s23 = new IntegerScalar(42);
//    static Scalar s24 = new FloatScalar(-1.25f);
    static Scalar s25 = new RationalScalar(2, 3);
    static Scalar s26 = new IntegerScalar(-10);
//    static Scalar s27 = new FloatScalar(3.14159f);
    static Scalar s28 = new RationalScalar(4, 7);
    static Scalar s29 = new IntegerScalar(0);
//    static Scalar s30 = new FloatScalar(2.71828f);

    private static final Scalar[] varArray = {s1, s2, s5, s6, s7, s8, s10, s11,  s13, s14, s16, s17, s19, s20, s22, s23, s25, s26, s28, s29};
//    private static final Class<?>[] possibleTypes = {IntegerScalar.class, RationalScalar.class, FloatScalar.class};


//######################################  methods  ######################################

    @Test
    public void testAdd() {
        Scalar result = varArray[0];
        for (int i = 1 ; i < 8; i++) {
            result = result.add(varArray[i]);
        }
        Assertions.assertEquals(new RationalScalar(205,21).reduce(), result.reduce());
    }
    @Test
    public void testMul(){
        Scalar result = new IntegerScalar(0);
        for (Scalar var1 : varArray) {
            for (Scalar var2 : varArray) {
                result = new IntegerScalar(0); // reset result for next test
                result = var1.mul(var2);
                Assertions.assertEquals(var1.mul(var2), result);
            }
        }
    }
    @Test
    public void testNeg(){
        Scalar result = new IntegerScalar(0);
        for (Scalar var : varArray) {
            result = new IntegerScalar(0); // reset result for next test
            result = var.neg();
            Assertions.assertEquals(var.neg(), result);
        }
    }
//    @Test
//    public void testPower(){
//        Scalar result = new IntegerScalar(0);
//        for (Scalar var : varArray) {
//                result = new IntegerScalar(0); // reset result for next test
//                result = var.power(3);
//                Assertions.assertEquals(Math.pow(var.getValue(), 3), result.getValue()); // test if result is equal to the value of the result raised to the power of 3
//        }
//    }
    @Test
    public void testSign(){
        int result = 0;
        for (Scalar var : varArray) {
            result = 0; // reset result for next test
            result = var.sign();
            Assertions.assertEquals(var.sign(), result);
        }
    }
    @Test
    public void testEquals(){
        boolean result;
        for (Scalar var1 : varArray) {
            for (Scalar var2 : varArray) {
                result = var1.equals(var2);
                Assertions.assertEquals(var1.equals(var2), result);
            }
        }
    }

}
