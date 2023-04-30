package Polynomial;

import java.util.TreeMap;
import Polynomial.Scalar.*;

public class Polynomial {
    // ----------------- fields --------------------
    public final TreeMap<String, Monomial> monomials;

    // -------------- constructors -----------------
    public Polynomial(TreeMap<String, Monomial> monomials) {
        TreeMap<String, Monomial> new_tree = new TreeMap<>();
        for (Monomial m : monomials.values()) {
            String temp = m.toString().split("x")[1]; // 5x^2[1] ["5", "^2"]
            new_tree.put(temp, m);
        }
        this.monomials = new_tree;
    }

    // ---------------- getters --------------------
    public Monomial getItem(String key) {
        return this.monomials.getOrDefault(key, new Monomial(new IntegerScalar(0), 0));
    }

    // ------------- class methods -----------------
    public Polynomial add(Polynomial p) {
        // todo removed unnecessary code (the loop at the end was not needed)
        TreeMap<String, Monomial> first_tree = new TreeMap<>();
        for (Monomial m : this.monomials.values()) {
            String temp = m.toString().split("x")[1];
            first_tree.put(temp, m);
        }
        TreeMap<String, Monomial> second_tree = new TreeMap<>();
        for (Monomial m : p.monomials.values()) {
            String temp = m.toString().split("x")[1];
            second_tree.put(temp, m);
        }

        StringBuilder toBuild = new StringBuilder();
        TreeMap<String, Monomial> smaller_tree, bigger_tree;
        String[] keySet1 = first_tree.keySet().toArray(new String[0]); //["^0", "^1", "^2"]
        String[] keySet2 = second_tree.keySet().toArray(new String[0]);
        String[] bigger_keySet;
        if (first_tree.size() < second_tree.size()) {
            smaller_tree = first_tree;
            bigger_tree = second_tree;
            bigger_keySet = bigger_tree.keySet().toArray(new String[0]);
        } else {
            smaller_tree = second_tree;
            bigger_tree = first_tree;
            bigger_keySet = bigger_tree.keySet().toArray(new String[0]);
        }


        for (int i = 0; i < smaller_tree.size(); i++) {
            Scalar m = first_tree.getOrDefault(keySet1[i], new Monomial(new IntegerScalar(0), 0)).getCoefficient();
            Scalar m2 = second_tree.getOrDefault(keySet2[i], new Monomial(new IntegerScalar(0), 0)).getCoefficient();
            Scalar res = m.add(m2);
            toBuild.append(" ").append(res);
        }

        for (int i = smaller_tree.size(); i < bigger_tree.size(); i++) {
            toBuild.append(" ").append(bigger_tree.get(bigger_keySet[i]).getCoefficient());
        }

        toBuild.deleteCharAt(0);
        return Polynomial.build(toBuild.toString());
    }


    public Polynomial mul(Polynomial p) {
        TreeMap<String, Monomial> first_tree = new TreeMap<>();
        for (Monomial m : this.monomials.values()) {
            String temp = m.toString().split("x")[1];
            first_tree.put(temp, m);
        }
        TreeMap<String, Monomial> second_tree = new TreeMap<>();
        for (Monomial m : p.monomials.values()) {
            String temp = m.toString().split("x")[1];
            second_tree.put(temp, m);
        }
        StringBuilder toBuild = new StringBuilder();
        TreeMap<String, Monomial> res_tree = new TreeMap<>();

        for (Monomial m1 : first_tree.values()) { // (2+3x+5x^2) * (3+4x+6x^3) = 6 + 8x + 12x^3 + 9x^2 + 12x^4 + 18x^5
            for (Monomial m2 : second_tree.values()) {
                Scalar res_co = m1.getCoefficient().mul(m2.getCoefficient());
                int res_ex = m1.getExponent() + m2.getExponent();
                Monomial current_mon = res_tree.getOrDefault("^" + res_ex, new Monomial(new IntegerScalar(0), 0));
                Monomial res_mon = new Monomial(res_co.add(current_mon.getCoefficient()), res_ex);
                res_tree.put("^" + res_ex, res_mon);
            }
        }
        for (Monomial m : res_tree.values()) {
            toBuild.append(" ").append(m);
        }
        toBuild.deleteCharAt(0);
        return Polynomial.build(toBuild.toString());
    }

    public static Polynomial build(String s) {
        String[] coefficients = s.split(" ");
        for (int i = 0; i < coefficients.length; i++) {
            coefficients[i] = coefficients[i] + "x^" + i;
        }
        TreeMap<String, Monomial> tree = new TreeMap<>();
        for (String coefficient : coefficients) {
            String[] split = coefficient.split("x\\^");
            String[] temp = split[0].split("/");
            if (split[0].equals("0")) {
                tree.put("^" + split[1], new Monomial(new IntegerScalar(0), Integer.parseInt(split[1])));
                continue;
            }
            if (temp.length == 2) {
                tree.put("^" + split[1], new Monomial(new RationalScalar(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])), Integer.parseInt(split[1])));
            continue;
        }
            tree.put("^" + split[1], new Monomial(new IntegerScalar(Integer.parseInt(split[0])), Integer.parseInt(split[1])));
        }
        return new Polynomial(tree);
    }

    public Polynomial derivative() {
        TreeMap<String, Monomial> new_tree = new TreeMap<>();
        for (String key : monomials.keySet()) {
            new_tree.put(getItem(key).derivative().toString(), getItem(key).derivative());
        }
        return new Polynomial(new_tree);
    }
    public Scalar evaluate(Scalar s) {
        Scalar res = new IntegerScalar(0);
        for (String key : monomials.keySet()) {
            res = res.add(getItem(key).evaluate(s));
        }
        return res;
    }

    // ------------- object methods -----------------
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (String key : monomials.keySet()) {
            if (key.equals("^0") && getItem(key).getCoefficient().toString().equals("0")) {
                continue;
            }
            if (getItem(key).getExponent() == 0) {
                s.append(getItem(key).getCoefficient().toString()).append(" + ");
                continue;
            }
            if (getItem(key).getExponent() == 1) {
                s.append(getItem(key).getCoefficient().toString()).append("x + ");
                continue;
            }
            s.append(getItem(key).toString()).append(" + ");
        }
        s = new StringBuilder(s.toString().replace(" + -", " - "));
        if (s.substring(0, 4).equals("0 + ")) {
            return s.substring(0, s.length() - 3);
        } else if (s.substring(0, 4).equals("0 - ")) {
            return "-" + s.substring(4, s.length() - 3);
        } else if (s.toString().equals("") || s.toString().equals(" ")) {
            return "0";
        }
        return s.substring(0, s.length() - 3);
    }

}











//    public Polynomial.Polynomial mul(Polynomial.Polynomial p) {
//        /*
//         * docstring: multiply two polynomials together and return the result as a new polynomial
//         * it is done by multiplying the monomials with the same exponent together and put them into a new polynomial
//         * after the multiplication, the new polynomial will have all the monomials from both polynomials
//         *
//         */
//        TreeMap<String, Polynomial.Polynomial.Monomial> this_p = new TreeMap<>();
//        for (String key : monomials.keySet()) {
//            for (String key2 : p.monomials.keySet()) {
//                Polynomial.Polynomial.Monomial m = getItem(key).mul(p.getItem(key2));
//                String new_key = m.getCoefficient().toString() + "x^" + m.getExponent();
//                this_p.put(new_key, m.add(this_p.getOrDefault(new_key, new Polynomial.Polynomial.Monomial(new Polynomial.Polynomial.Scalar.IntegerScalar(0), 0))));
//            }
//        }
//        return new Polynomial.Polynomial(this_p);
//    }
//    public Polynomial.Polynomial.Scalar.Scalar evaluate(Polynomial.Polynomial.Scalar.Scalar s) {
//        /*
//         * docstring: evaluate the polynomial at a given value
//         * it is done by evaluating each monomial and add them together
//         *
//         */
//        Polynomial.Polynomial.Scalar.Scalar result = new Polynomial.Polynomial.Scalar.IntegerScalar(0);
//        for (String key : monomials.keySet()) {
//            result = result.add(getItem(key).evaluate(s));
//        }
//        return result;
//    }
//    public String toString() {
//        StringBuilder s = new StringBuilder();
//        for (String key : monomials.keySet()) {
//            s.append(getItem(key).toString()).append(" + ");
//        }
//        s = new StringBuilder(s.toString().replace(" + -", " - "));
//        return s.substring(0, s.length() - 3);
//    }
//    public Polynomial.Polynomial derivative() {
//        TreeMap<String, Polynomial.Polynomial.Monomial> this_p = new TreeMap<>();
//        for (String key : monomials.keySet()) {
//            Polynomial.Polynomial.Monomial m = getItem(key).derivative();
//            String new_key = m.getCoefficient().toString() + "x^" + m.getExponent();
//            this_p.put(new_key, m.add(this_p.getOrDefault(new_key, new Polynomial.Polynomial.Monomial(new Polynomial.Polynomial.Scalar.IntegerScalar(0), 0))));
//        }
//        return new Polynomial.Polynomial(this_p);
//    }
//}
//        TreeMap<String, Polynomial.Polynomial.Monomial> this_p = new TreeMap<>();
//        for (String key : monomials.keySet()) {
//            this_p.put(key, getItem(key).add(p.getItem(key)));
//        }
//        for (String key : p.monomials.keySet()) {
//            if (!monomials.containsKey(key)) {
//                this_p.put(key, p.getItem(key));
//            }
//        }
//        return new Polynomial.Polynomial(this_p);

//  String[] buildingBlock = s.split(" ");
//        Polynomial.Polynomial.Monomial[] valuesToCalc = new Polynomial.Polynomial.Monomial[buildingBlock.length];
//        for (int i = 0; i < buildingBlock.length; i++) {
//            // i need to create an array of monomials with the coefficients from the string given, and the exponents from 0 to n-1. it could be rationalscalar as well as integerscalar.
//        }
//        TreeMap<String, Polynomial.Polynomial.Monomial> this_p = new TreeMap<>();
//        int exponent = 0;
//        for (String curr : buildingBlock) {
//            Polynomial.Polynomial.Monomial m = new Polynomial.Polynomial.Monomial(new Polynomial.Polynomial.Scalar.IntegerScalar(Integer.parseInt(curr)), exponent);
//            String new_key = m.getCoefficient().toString() + "x^" + m.getExponent();
//            this_p.put(new_key, m);
//            exponent += 1;
//        }
//        return new Polynomial.Polynomial(this_p);
//    }
//      return monomials.values().stream().map(monomial -> monomial.evaluate(s)).reduce(new Polynomial.Polynomial.Scalar.IntegerScalar(0), Polynomial.Polynomial.Scalar.Scalar::add);