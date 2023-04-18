package Final;

public class Monomial implements Scalar {
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
//########################################fuckbois###########################################################
    @Override
    public Scalar add(Scalar s) {
        return null;
    }
    @Override
    public Scalar add_int(IntegerScalar i) {
        return null;
    }

    @Override
    public Scalar add_rati(RationalScalar r) {
        return null;
    }

//###################################endoffuckbois###########################################################


    public Monomial mul(Monomial m) {
        return new Monomial(this.coefficient.mul(m.coefficient), this.exponent + m.exponent);
    }

//########################################fuckbois##########################################################
    @Override
    public Scalar mul(Scalar s) {
         return null;
    }
    @Override
    public Scalar mul_int(IntegerScalar i) {
        return null;
    }

    @Override
    public Scalar mul_rati(RationalScalar r) {
        return null;
    }


    //###################################endoffuckbois###########################################################
    @Override
    public Scalar neg() {
        return new Monomial(this.coefficient.neg(), this.exponent);
    }

    @Override
    public Scalar power(int exponent) {
        return new Monomial(this.coefficient.power(exponent), this.exponent * exponent);
    }


    @Override
    public int sign() {
        return this.coefficient.sign();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Monomial))
            return false;
        Monomial m = (Monomial) obj;
        return this.coefficient.equals(m.coefficient) && this.exponent == m.exponent;
    }

    @Override
    public Scalar round(int precision) {
        return this;
    }

    @Override
    public Monomial reduce() {
        return new Monomial(this.coefficient.reduce(), this.exponent);
    }

    @Override
    public String toString() {
        return this.coefficient.toString() + "x^" + this.exponent;
    }
    public Monomial derivative(){
        Scalar new_co = this.coefficient.mul(new IntegerScalar(this.exponent));
        int new_ex = this.exponent - 1;
        return new Monomial(new_co, new_ex);
    }

}
