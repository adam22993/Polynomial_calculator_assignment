public class Rational {
    private int numerator;
    private int denumerator;

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
        }

    public String toString () {
        if
    }


    }
