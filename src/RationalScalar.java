public class RationalScalar implements Scalar {
    private final int numerator;
    private final int denominator;

    public RationalScalar(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }
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
        return new RationalScalar(this.denominator * i.getNumber() + this.numerator, this.denominator).reduce();
    }

    public Scalar add_rati(RationalScalar r) {
        return new RationalScalar(this.numerator * r.denominator + this.denominator * r.numerator, this.denominator * r.denominator);
    }

    public RationalScalar reduce() {
        int gdc = GDC(this.numerator, this.denominator);
        int new_num = this.numerator/gdc;
        int new_denum = this.denominator/gdc;
        return new RationalScalar(new_num, new_denum);
    }
    public RationalScalar reduce(int a, int b) {
        int gdc = GDC(a, b);
        int new_num = a/gdc;
        int new_denum = b/gdc;
        return new RationalScalar(new_num, new_denum);
    }
    public static int GDC(int a,int b){
        if(a % b == 0){
            return b;
        }
        return GDC(b, a % b);
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

    @Override
    public Scalar round(int precision) {
        return this;
    }

    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}
