public class Monomial {
    private final Scalar coefficient;
    private final int exponent;

    public Monomial(Scalar coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    public Scalar getCoefficient() {
        return coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public Monomial add(Monomial m) {
        if (this.exponent == m.exponent) {
            return new Monomial(this.coefficient.add(m.coefficient), this.exponent);
        } else {
            return null;
        }
    }

    public Monomial mul(Monomial m) {
        return new Monomial(this.coefficient.mul(m.coefficient), this.exponent + m.exponent);
    }



    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Monomial))
            return false;
        Monomial m = (Monomial) obj;
        return this.coefficient.equals(m.coefficient) && this.exponent == m.exponent;
    }


    public String toString() {

            return this.coefficient.toString() + "x^" + this.exponent;

    }
    public Monomial derivative(){
        Scalar new_co = this.coefficient.mul(new IntegerScalar(this.exponent).reduce());
        int new_ex = this.exponent - 1;
        return new Monomial(new_co, new_ex);
    }

    public Scalar evaluate(Scalar s) {
        return this.coefficient.mul(s.power(this.exponent));
    }
}
