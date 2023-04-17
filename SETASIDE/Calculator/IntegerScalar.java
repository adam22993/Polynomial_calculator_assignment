package Calculator;

public class IntegerScalar implements Scalarable<T> {
    private final int number;
    public IntegerScalar(int num){
        this.number = num;
    }
    public int getNumber(){
        return this.number;
    }
    @Override
    public Scalar add(Scalar s) {
        int result = this.number + ((IntegerScalar) s).number;
        return new IntegerScalar(result);
    }

    @Override
    public Scalar mul(Scalar s) {
        int result = this.number * ((IntegerScalar) s).number;
        return new IntegerScalar(result);
    }

    @Override
    public Scalar neg() {
        return IntegerScalar.this.mul(new IntegerScalar(-1));
    }

    @Override
    public Scalar power(int exponent) {
        int result = this.number;
        for (int i = 1; i < exponent; i++) {
            result *= this.number;
        }
        return new IntegerScalar(result);
    }

    @Override
    public int sign() {
        if (this.number > 0) {
            return 1;
        } else if (this.number < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        // can be written as one-liners because of one line statements.
        if (this == o)
            return true;
        if (!(o instanceof IntegerScalar))
            return false;
        return this.number == ((IntegerScalar) o).number;
    }

    @Override
    public <T> T accept(Scalarable<T> visitor) {
        return visitor.visit(this);
    }

    public String toString(){
        /*
         * Using the valueOf method in String to convert @this.number [int] to a string is also possible,
         * but the compiler works a little faster with the Integer.toString method as it is a static method.
         * TODO: check if this is true and what is the difference between virtual method call and a static one.
         */
        return Integer.toString(this.number);
    }
}
