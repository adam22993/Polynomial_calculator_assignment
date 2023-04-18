package Final;

public class IntegerScalar implements Scalar {
    private final int number;

    public IntegerScalar(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.add_int(this);
    }

    @Override
    public Scalar add_int(IntegerScalar i) {
        return new IntegerScalar(this.number + i.getNumber());
    }

    @Override
    public Scalar add_rati(RationalScalar r) {
        return new RationalScalar(this.number * r.getDenominator() + r.getNumerator(), r.getDenominator());
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mul_int(this);
    }

    @Override
    public Scalar mul_int(IntegerScalar i) {
        return new IntegerScalar(this.number * i.getNumber());
    }

    @Override
    public Scalar mul_rati(RationalScalar r) {
        return new RationalScalar(this.number * r.getNumerator(), r.getDenominator());
    }

    public IntegerScalar neg() {
        return new IntegerScalar(-number);
    }

    @Override
    public Scalar power(int exponent) {
        return null;
    }

    public int sign() {
        // Great use internal function for int field in this class.
        return Integer.signum(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (!(obj instanceof IntegerScalar))
            return false;

        return number == ((IntegerScalar) obj).number;
    }

    @Override
    public Scalar round(int precision) {
        return this;
    }

    @Override
    public Scalar reduce() {
        return this;
    }

    public String toString() {
        return Integer.toString(this.number);
    }
}
