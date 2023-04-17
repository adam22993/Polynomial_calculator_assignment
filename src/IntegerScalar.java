public class IntegerScalar implements Scalar {
    private final int number;
    public IntegerScalar(int num){
        this.number = num;
    }
    public String toString(){
        /*
         * Using the valueOf method in String to convert @this.number [int] to a string.
         */
        return String.valueOf(this.number);
    }

    @Override
    public Scalar add(Scalar s) {
        return this.number + s;
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
    public boolean equals(Object o) {
        return false;
    }
}
