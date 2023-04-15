public class Monomial {
    private int exponent;
    private Scalar coefficient;
    public Monomial(Scalar coefficient){
        this.exponent = 1;
        this.coefficient = coefficient;
    }
    public Monomial(Scalar coefficient, int exponent){
        this.exponent = exponent;
        this.coefficient = coefficient;
    }
    public Monomial add(Monomial m){
        return null;
    }
    public Monomial mul(Monomial m){
        return null;
    }
    public Scalar evaluate(Scalar s){
        return null;
    }
    public Monomial derivative(){
//      todo: fix this - issue that exponent and coefficient different classes.
//        this.coefficient *= this.exponent;
//        this.exponent -= 1;
        return null;
    }
}
