import java.lang.Integer;
public interface Scalar {
    /*
     * TODO: find how to implement the IntegerScalar and why its needed
     *       try and understand how the scalar fits in this system exactly.
     */

    Scalar add(Scalar s);
    Scalar mul(Scalar s);
    Scalar neg();
    Scalar power(int exponent);
    int sign();
    @Override
    boolean equals(Object o);
}
