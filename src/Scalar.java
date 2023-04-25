public interface Scalar {

// --------------- addition methods ----------------
    Scalar add(Scalar s);

    Scalar add_int(IntegerScalar i);

    Scalar add_rati(RationalScalar r);

// ----------- multiplication methods ---------------
    Scalar mul(Scalar s);

    Scalar mul_int(IntegerScalar i);

    Scalar mul_rati(RationalScalar r);

// --------------- Scalar methods -------------------
    Scalar neg();

    Scalar power(int exponent);

    int sign();

    @Override
    boolean equals(Object o);
}
