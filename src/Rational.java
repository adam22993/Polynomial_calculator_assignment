public class Rational {
    /*
     * TODO: CHECK IF FINALS ARE NECESSARY.
     */
    private final int numerator;
    private final int denumerator;

    public Rational(int numer) {
        this.numerator = numer;
        this.denumerator = 1;
    }

    public Rational(int numer, int denumer) {
        this.numerator = numer;
        this.denumerator = denumer;
    }

    public Rational reduce() {
        int gdc = GDC(this.numerator, this.denumerator);
        int new_num = this.numerator/gdc;
        int new_denum = this.denumerator/gdc;
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

    public String toString () {
        Rational red_val = reduce(this.numerator, this.denumerator);
        if(red_val.numerator % red_val.denumerator == 0){
            int res = red_val.numerator / red_val.denumerator;
            return String.valueOf(res);
        } else {
            return String.format("%d/%d", red_val.numerator, red_val.denumerator);
        }
    }


    }
