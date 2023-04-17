package GenericCalculator;

public interface Scalar {
    /*
     * TODO: find how to implement the Calculator.IntegerScalar and why its needed
     *       try and understand how the scalar fits in this system exactly.
     */

    Scalar add(Scalar s);
    Scalar mul(Scalar s);
    Scalar neg();
    Scalar power(int exponent);
    int sign();
    @Override
    boolean equals(Object o);
    //<T> T accept(ScalarVisitor<T> visitor);
}

