package Calculator;

public interface ScalarVisitor<T> {
    /*
     * Exploring the Visitor design pattern. Could possibly be the best way to implement the Calculator.Scalar interface.
     */
    T visit(IntegerScalar i);
    T visit(RationalScalar r);
    T visit(Monomial m);
}
