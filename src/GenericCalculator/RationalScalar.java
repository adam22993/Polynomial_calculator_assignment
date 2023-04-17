
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

    public RationalScalar add(RationalScalar other) {
        int newNumerator = this.numerator * other.denominator + this.denominator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new RationalScalar(newNumerator, newDenominator);
    }

    public RationalScalar mul(RationalScalar other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new RationalScalar(newNumerator, newDenominator);
    }

    public RationalScalar neg() {
        return new RationalScalar(-this.numerator, this.denominator);
    }

    public int sign() {
        return Integer.signum(this.numerator);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (!(obj instanceof RationalScalar))
            return false;

        return this.numerator == ((RationalScalar) obj).numerator && this.denominator == ((RationalScalar) obj).denominator;
    }

    public String toString() {
        return Integer.toString(this.numerator) + "/" + Integer.toString(this.denominator);
    }
}
