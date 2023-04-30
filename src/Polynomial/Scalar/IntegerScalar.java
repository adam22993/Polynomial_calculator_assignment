package Polynomial.Scalar;

public class IntegerScalar implements Scalar {

    // ----------------- fields -------------------
    private final int number;

    // --------------- constructors ---------------
    public IntegerScalar(int number) {
        this.number = number;
    }

    // ----------------- getters ------------------
    public int getNumber() {
        return number;
    }

    // ------------- addition methods -------------
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

    // ---------- multiplication methods ----------
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

    //-------------- Scalar methods ----------------
    @Override
    public IntegerScalar neg() {
        return new IntegerScalar(-number);
    }

    @Override
    public Scalar power(int exponent) {
        // Added exponent == 0 case.
        Scalar result = new IntegerScalar(this.number);
        Scalar og_number = new IntegerScalar(this.number);
        if (exponent == 0) {
            return new IntegerScalar(1);
        }
        // skip i = 1 because we already have the original number.
        for (int i = 2; i <= exponent; i++) {
            result = result.mul(og_number);
        }
        return result;
    }

    @Override
    public int sign() {
        // Great use internal function for int field in this class.
        return Integer.signum(number);
    }

    // ---------------- class methods --------------------
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (!(obj instanceof IntegerScalar))
            return false;

        return this.number == ((IntegerScalar) obj).number;
    }

    @Override
    public Scalar reduce() {
        return this;
    }

    public String toString() {
        return Integer.toString(this.number);
    }
}
