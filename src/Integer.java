public class Integer {
    private final int number;
    public Integer(int num){
        this.number = num;
    }
    public String toString(){
        /*
         * Using the valueOf method in String to convert @this.number [int] to a string.
         */
        return String.valueOf(this.number);
    }
}
