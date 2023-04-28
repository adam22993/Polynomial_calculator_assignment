import static java.lang.Math.abs;

public class RationalScalar implements Scalar {

// ----------------- fields --------------------
    private final int numerator;
    private final int denominator;

// -------------- constructors -----------------
    public RationalScalar(int numerator) {
        /*
         *  Mainly used to debug when the denominator is not important
         * @param numerator - the numerator of the rational scalar
         */
        this.numerator = numerator;
        this.denominator = 1;
    }
    public RationalScalar(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

// ---------------- getters --------------------
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

// ------------- addition methods --------------
    @Override
    public Scalar add(Scalar s) {
        return s.add_rati(this);
    }

    @Override
    public Scalar add_int(IntegerScalar i) {
        return new RationalScalar(this.denominator * i.getNumber() + this.numerator, this.denominator).reduce();
    }

    public Scalar add_rati(RationalScalar r) {
        return new RationalScalar(this.numerator * r.denominator + this.denominator * r.numerator, this.denominator * r.denominator);
    }

// ---------- multiplication methods -----------
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

// --------------- Scalar methods --------------
    public RationalScalar neg() {
        return new RationalScalar(-this.numerator, this.denominator);
    }

    public RationalScalar power(int exponent) {
        int result_num = 1;
        int result_denom = 1;
        for (int i = 0; i < exponent; i++) {
            result_num *= this.numerator;
            result_denom *= this.denominator;
        }
        return new RationalScalar(result_num, result_denom);
    }

    public int sign() {
        if (this.numerator == 0) {
            return 0;
        }
        if (this.numerator > 0 && this.denominator > 0 || this.numerator < 0 && this.denominator < 0) {
            return 1;
        }
        return -1;
    }

// -------------- class methods ----------------

    public RationalScalar reduce() {
        /*
         * A basic reduction method for rational numbers using the GDC recursive method.
         */
        int gdc = GDC(this.numerator, this.denominator);
        int new_num = this.numerator/gdc;
        int new_denum = this.denominator/gdc;
        return new RationalScalar(new_num, new_denum);
    }


    @Override
    public boolean equals(Object obj) {
        /*
         * todo: check object fields to test what happens to r_nom and r_denom. object can have a minus sign
         *       in the numerator or denominator.
         */
        if (obj == this)
            return true;
        if (!(obj instanceof RationalScalar))
            return false;
        /*
         * taking the signs of the numbers into account, turning them absolute and comparing them with the original signs after reduction.
         */
        int r_nom = ((RationalScalar) obj).sign();
        int r_denom = ((RationalScalar) obj).sign();
        int temp_nom = this.sign();
        int temp_denom = this.sign();
        RationalScalar r = ((RationalScalar) obj).reduce();
        RationalScalar temp = this.reduce();
        return abs(r.numerator) == abs(temp.numerator) && abs(r.denominator) == abs(temp.denominator) && (r_nom == temp_nom && r_denom == temp_denom || r_nom == -temp_nom && r_denom == -temp_denom);
    }

    public String toString() {
        // todo add abs function
        // todo return a rational number as a string and the sign infront of it
        if (this.numerator % this.denominator == 0) {
            int temp_int = this.numerator / this.denominator;
            return new IntegerScalar(temp_int).toString();
        }
        int temp_nom = new IntegerScalar(this.numerator).sign();
        int temp_denom = new IntegerScalar(this.denominator).sign();
        RationalScalar temp = this.reduce();
        return abs(temp.numerator) * temp_nom + "/" + abs(temp.denominator) * temp_denom;
    }

// ----------------- static methods ------------------
    public static RationalScalar reduce(int a, int b) {
        /*
         * A static variant of the reduce method, allowing easier debugging.
         * @param a - The numerator of the rational number
         * @param b - The denominator of the rational number
         */
        int gdc = GDC(a, b);
        int new_num = a/gdc;
        int new_denum = b/gdc;
        return new RationalScalar(new_num, new_denum);
    }
    public static int GDC(int a,int b){
        /*
         * A recursive method for finding the greatest common divisor of two numbers.
         * @param a - The first number.
         * @param b - The second number.
         */
        if(a % b == 0){
            return b;
        }
        return GDC(b, a % b);
    }
}
