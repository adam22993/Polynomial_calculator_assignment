//package Final;
//
//
//public class FloatScalar implements Scalar {
//    private final float number;
//
//    public FloatScalar(float number) {
//        this.number = number;
//    }
//    public FloatScalar(float first, float second) {
//        this.number = first / second;
//    }
//
//    public float getNumber() {
//        return number;
//    }
//
//    @Override
//    public Scalar add(Scalar s) {
//        return s.add_float(this);
//    }
//
//    @Override
//    public Scalar add_int(IntegerScalar i) {
//        return new FloatScalar(this.number + i.getNumber());
//    }
//
//    @Override
//    public Scalar add_float(FloatScalar f) {
//        return new FloatScalar(this.number + f.getNumber());
//    }
//
//    @Override
//    public Scalar add_rati(RationalScalar r) {
//        float numerator = r.getNumerator();
//        float denominator = r.getDenominator();
//        return new FloatScalar(this.number + numerator / denominator);
//    }
//
//    @Override
//    public Scalar mul(Scalar s) {
//        return s.mul_float(this);
//    }
//
//    @Override
//    public Scalar mul_int(IntegerScalar i) {
//        return new FloatScalar(this.number * i.getNumber());
//    }
//
//    @Override
//    public Scalar mul_float(FloatScalar f) {
//        return new FloatScalar(this.number * f.getNumber());
//    }
//
//    @Override
//    public Scalar mul_rati(RationalScalar r) {
//        float numerator = r.getNumerator();
//        float denominator = r.getDenominator();
//        return new FloatScalar(this.number * numerator / denominator);
//    }
//
//    public FloatScalar neg() {
//        return new FloatScalar(-number);
//    }
//
//    @Override
//    public Scalar power(int exponent) {
//        float result = (float) Math.pow(this.number, exponent);
//        return new FloatScalar(result);
//    }
//
//    public int sign() {
//        return Float.compare(number, 0);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this)
//            return true;
//
//        if (!(obj instanceof FloatScalar))
//            return false;
//
//        return Float.compare(number, ((FloatScalar) obj).number) == 0;
//    }
//    public FloatScalar round(int precision) {
//        float scale = (float) Math.pow(10, precision);
//        return new FloatScalar(Math.round(this.number * scale) / scale);
//    }
//
//
//    public String toString() {
//        return Float.toString(this.number);
//    }
//}