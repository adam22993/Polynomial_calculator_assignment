//
//public class IntegerScalar {
//    private final int number;
//
//    public IntegerScalar(int number) {
//        this.number = number;
//    }
//
//    public int getNumber() {
//        return number;
//    }
//
//    public IntegerScalar add(IntegerScalar other) {
//        return new IntegerScalar(number + other.number);
//    }
//
//    public IntegerScalar mul(IntegerScalar other) {
//        return new IntegerScalar(number * other.number);
//    }
//
//    public IntegerScalar neg() {
//        return new IntegerScalar(-number);
//    }
//
//    public int sign() {
//        // Great use internal function for int field in this class.
//        return Integer.signum(number);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this)
//            return true;
//
//        if (!(obj instanceof IntegerScalar))
//            return false;
//
//        return number == ((IntegerScalar) obj).number;
//    }
//
//    public String toString() {
//        return Integer.toString(this.number);
//    }
//}
