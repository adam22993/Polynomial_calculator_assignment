package Final;

public class RationalScalar implements Scalar {
    private final int numerator;
    private final int denominator;

    public RationalScalar(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.add_rati(this);
    }

    @Override
    public Scalar add_int(IntegerScalar i) {
        return new RationalScalar(this.denominator * i.getNumber() + this.numerator, this.denominator);
    }

    public Scalar add_rati(RationalScalar r) {
        return new RationalScalar(this.numerator * r.denominator + this.denominator * r.numerator, this.denominator * r.denominator);
    }

    @Override
    public Scalar add_float(FloatScalar f) {
        return new FloatScalar(f.getNumber() + this.numerator / this.denominator);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mul_rati(this);
    }

    @Override
    public Scalar mul_int(IntegerScalar i) {
        return new RationalScalar(this.numerator * i.getNumber(), this.denominator);
    }

    public Scalar mul_rati(RationalScalar r) {
        return new RationalScalar(this.numerator * r.numerator, this.denominator * r.denominator);
    }

    @Override
    public Scalar mul_float(FloatScalar f) {
        return null;
    }

    public RationalScalar neg() {
        return new RationalScalar(-numerator, denominator);
    }

    public RationalScalar power(int exponent) {
        return new RationalScalar((int) Math.pow(numerator, exponent), (int) Math.pow(denominator, exponent));
    }

    public int sign() {
        return Integer.signum(numerator);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof RationalScalar))
            return false;
        RationalScalar r = (RationalScalar) obj;
        return r.numerator == this.numerator && r.denominator == this.denominator;
    }
}
