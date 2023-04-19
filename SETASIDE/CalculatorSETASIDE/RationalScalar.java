package Calculator;

public class RationalScalar implements Scalar, String {
    /*
     * TODO: CHECK IF FINALS ARE NECESSARY.
     */
    private final int numerator;
    private final int denominator;

    public RationalScalar(int numer) {
        this.numerator = numer;
        this.denominator = 1;
    }

    public RationalScalar(int numer, int denumer) {
        if (denumer == 0) {
            throw new IllegalArgumentException("Denominator cannot be 0");
        }
        this.numerator = numer;
        this.denominator = denumer;
    }
    public int getNumerator(){
        return this.numerator;
    }
    public int getDenominator(){
        return this.denominator;
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
    public Scalar add(Scalar s) {
        int res = this.numerator * ((RationalScalar) s).denominator + ((RationalScalar) s).numerator * this.denominator;
        int res_denum = this.denominator * ((RationalScalar) s).denominator;
        return new RationalScalar(res, res_denum);
    }
    
    @Override
    public Scalar mul(Scalar s) {
        return null;
    }

    @Override
    public Scalar neg() {
        return null;
    }

    @Override
    public Scalar power(int exponent) {
        return null;
    }

    @Override
    public int sign() {
        return 0;
    }

    @Override
    public boolean equals(Object o){
        /*
         * # As assignment regulations, we are allowed to use @instanceof while overriding equals.
         * Overriding equals allows the "==" operator to be used correctly.
         */
        if (this == o)
            return true;
        if (!(o instanceof RationalScalar))
            return false;
        RationalScalar c = (RationalScalar) o;
        RationalScalar a = this.reduce();
        RationalScalar b = c.reduce();
        return a.numerator == b.numerator && a.denominator == b.denominator;
    }

    @Override
    public <T> T accept(ScalarVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String toString () {
        RationalScalar red_val = reduce(this.numerator, this.denominator);
        if(red_val.numerator % red_val.denominator == 0){
            int res = red_val.numerator / red_val.denominator;
            return String.valueOf(res);
        } else {
            return String.format("%d/%d", red_val.numerator, red_val.denominator);
        }
    }


    }
