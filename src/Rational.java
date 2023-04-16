public class Rational {
    /*
     * TODO: CHECK IF FINALS ARE NECESSARY.
     */
    private final int numerator;
    private final int denominator;

    public Rational(int numer) {
        this.numerator = numer;
        this.denominator = 1;
    }

    public Rational(int numer, int denumer) {
        this.numerator = numer;
        this.denominator = denumer;
    }

    public Rational reduce() {
        int gdc = GDC(this.numerator, this.denominator);
        int new_num = this.numerator/gdc;
        int new_denum = this.denominator/gdc;
        return new Rational(new_num, new_denum);
        }
    public Rational reduce(int a, int b) {
        int gdc = GDC(a, b);
        int new_num = a/gdc;
        int new_denum = b/gdc;
        return new Rational(new_num, new_denum);
    }
    public static int GDC(int a,int b){
        if(a % b == 0){
            return b;
        }
        return GDC(b, a % b);
    }

    @Override
    public Scalar add(Scalar s) {
        // Rational res = new Rational(this.numerator + (s * this.denominator), this.denominator);
        //return res;
        return null;
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
        if (this == o){
            return true;
        }
        if (!(o instanceof Rational other)) {
            return false;
        }
        return this.numerator == other.numerator && this.denominator == other.denominator;
    }

    public String toString () {
        Rational red_val = reduce(this.numerator, this.denominator);
        if(red_val.numerator % red_val.denominator == 0){
            int res = red_val.numerator / red_val.denominator;
            return String.valueOf(res);
        } else {
            return String.format("%d/%d", red_val.numerator, red_val.denominator);
        }
    }


    }
