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

// ------------- Scalar methods --------------
    @Override
    public IntegerScalar neg() {
        return new IntegerScalar(-number);
    }

    @Override
    public Scalar power(int exponent) {
        return new IntegerScalar((int) Math.pow(this.number, exponent));
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

    public String toString() {
        return Integer.toString(this.number);
    }
}
