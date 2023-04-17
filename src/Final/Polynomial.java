package Final;

import java.util.TreeMap;

public class Polynomial {
    private final TreeMap<String, Monomial> monomials;

    public Polynomial(TreeMap<String, Monomial> monomials) {
        this.monomials = monomials;
    }

    public Monomial getItem(String key) {
        return monomials.getOrDefault(key, new Monomial(new IntegerScalar(0), 0));
    }

    public Polynomial add(Polynomial p) {
        /*
         * docstring: add two polynomials together and return the result as a new polynomial
         * it is done by adding the monomials with the same exponent together and put them into a new polynomial
         * after the addition, the new polynomial will have all the monomials from both polynomials
         *
         */
        TreeMap<String, Monomial> this_p = new TreeMap<>();
        for (String key : monomials.keySet()) {
            this_p.put(key, getItem(key).add(p.getItem(key)));
        }
        for (String key : p.monomials.keySet()) {
            if (!monomials.containsKey(key)) {
                this_p.put(key, p.getItem(key));
            }
        }
        return new Polynomial(this_p);
    }
    public Polynomial mul(Polynomial p) {
        /*
         * docstring: multiply two polynomials together and return the result as a new polynomial
         * it is done by multiplying the monomials with the same exponent together and put them into a new polynomial
         * after the multiplication, the new polynomial will have all the monomials from both polynomials
         *
         */
        TreeMap<String, Monomial> this_p = new TreeMap<>();
        for (String key : monomials.keySet()) {
            for (String key2 : p.monomials.keySet()) {
                Monomial m = getItem(key).mul(p.getItem(key2));
                String new_key = m.getCoefficient().toString() + "x^" + m.getExponent();
                this_p.put(new_key, m.add(this_p.getOrDefault(new_key, new Monomial(new IntegerScalar(0), 0))));
            }
        }
        return new Polynomial(this_p);
    }
    public String toString() {
        String s = "";
        for (String key : monomials.keySet()) {
            s += getItem(key).toString() + " + ";
        }
        s = s.replace(" + -", " - ");
        return s.substring(0, s.length() - 3);
    }
    public Polynomial derivative() {
        TreeMap<String, Monomial> this_p = new TreeMap<>();
        for (String key : monomials.keySet()) {
            Monomial m = getItem(key).derivative();
            String new_key = m.getCoefficient().toString() + "x^" + m.getExponent();
            this_p.put(new_key, m.add(this_p.getOrDefault(new_key, new Monomial(new IntegerScalar(0), 0))));
        }
        return new Polynomial(this_p);
    }
}
// thus