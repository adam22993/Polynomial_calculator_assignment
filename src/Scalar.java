public interface Scalar {
    /*
     * This interface represents the methods that should be implemented by a scalar.
     * The polymorphism of the scalar is achieved by the Scalar interface.
     * The Scalar interface is implemented by the IntegerScalar and RationalScalar classes.
     * Monomial and Polynomial classes use the Scalar interface to perform operations on the scalars.
     * To add more scalars, you need to add the appropriate methods to the Scalar interface, then
     * implement all the methods in the new scalar class.
     * If implemented incorrectly, the program will not work correctly if even at all.
     * Various design patterns were checked in the process of learning and creating this program.
     * The most suitable design patterns we have found to be applicable to this program are:
     * - Visitor design pattern
     * - Command design pattern
     * - Strategy design pattern
     * Really looking forward to seeing their implementation in the next assignments.
     */

// --------------- addition methods ----------------
    Scalar add(Scalar s);

    Scalar add_int(IntegerScalar i);

    Scalar add_rati(RationalScalar r);

// ----------- multiplication methods ---------------
    Scalar mul(Scalar s);

    Scalar mul_int(IntegerScalar i);

    Scalar mul_rati(RationalScalar r);

// --------------- Scalar methods -------------------
    Scalar neg();

    Scalar power(int exponent);

    int sign();

    @Override
    boolean equals(Object o);

// --------------- debug methods -------------------

    public Scalar getValue();
    public Scalar getValue(IntegerScalar i);
    public Scalar getValue(RationalScalar r);
}
