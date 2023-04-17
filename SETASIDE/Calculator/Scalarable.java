package Calculator;

public interface Scalarable<T> extends Scalar {

    //Addition##########################################
    public T add(T other);

    //Multiplication###################################
    public T multiply(T other);

    //Division##########################################
    public T divide(T other);

    //Derivative#######################################
    public T derivative();

    //Evaluation#######################################
    public T evaluate();

    //Sign#############################################
    public T neg();
    public T sign();

    //Power############################################
    public T pow(T other);

    //Comparison#######################################
    boolean equals(Object t);
    boolean notEquals(T t);
    boolean greaterThan(T t);
    boolean lessThan(T t);
    boolean greaterThanOrEquals(T t);
    boolean lessThanOrEquals(T t);

    //Visitor creation#################################
    T visit(IntegerScalar i);
    T visit(RationalScalar r);
    //T visit(Monomial m);
}
