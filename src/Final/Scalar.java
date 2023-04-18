package Final;

public interface Scalar {
    Scalar add(Scalar s);
    Scalar add_int(IntegerScalar i);
    Scalar add_rati(RationalScalar r);
    Scalar add_float(FloatScalar f);
    Scalar mul(Scalar s);
    Scalar mul_int(IntegerScalar i);
    Scalar mul_rati(RationalScalar r);
    Scalar mul_float(FloatScalar f);
    Scalar neg();
    Scalar power(int exponent);
    int sign();
    @Override
    boolean equals(Object o);
}
