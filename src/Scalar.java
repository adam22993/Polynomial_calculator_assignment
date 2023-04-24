public interface Scalar {
    //    <T> Class<?> getItems();
    Scalar add(Scalar s);

    Scalar add_int(IntegerScalar i);

    Scalar add_rati(RationalScalar r);

    Scalar mul(Scalar s);

    Scalar mul_int(IntegerScalar i);

    Scalar mul_rati(RationalScalar r);

    Scalar neg();

    Scalar power(int exponent);

    int sign();

    @Override
    boolean equals(Object o);

    Scalar reduce();
}
