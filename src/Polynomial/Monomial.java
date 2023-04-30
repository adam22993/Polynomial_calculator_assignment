package Polynomial;

import Polynomial.Scalar.IntegerScalar;
import Polynomial.Scalar.Scalar;

public class Monomial {
    // ----------------- fields --------------------
    private final Scalar coefficient;
    private final int exponent;
    // -------------- constructors -----------------
    public Monomial(Scalar coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    // ---------------- getters --------------------
    public Scalar getCoefficient() {
        return coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    // ---- addition and multiplication methods ----

    /**
     * While creating Polynomial, we found no need to use these methods because of polymorphism from scalar.
     *
     *    public Monomial add(Monomial m) {
     *       if (this.exponent == m.exponent) {
     *           return new Monomial(this.coefficient.add(m.coefficient), this.exponent);
     *        } else {
     *           return null;
     *       }
     *   }
     *
     *public Monomial mul(Monomial m) {
     *    return new Monomial(this.coefficient.mul(m.coefficient), this.exponent + m.exponent);
     *}
     */

    // ------------- class methods -----------------
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Monomial m))
            return false;
        return this.coefficient.equals(m.coefficient) && this.exponent == m.exponent;
    }


    public String toString() {
            return this.coefficient.toString() + "x^" + this.exponent;
    }
    public Monomial derivative(){
        Scalar new_co = this.coefficient.mul(new IntegerScalar(this.exponent));
        int new_ex = this.exponent - 1;
        if (new_ex < 0) {
            new_ex = 0;
        }
        return new Monomial(new_co, new_ex);
    }

    public Scalar evaluate(Scalar s) {
        return this.coefficient.mul(s.power(this.exponent));

    }
}
