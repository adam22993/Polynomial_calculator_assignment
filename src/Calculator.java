import java.util.Scanner;
public class Calculator {
    private final Scanner s;

    public Calculator(){
        s = new Scanner(System.in);
    }


    public void start(){
        System.out.println("Welcome to the Polynomial Calculator!");
        int choice = 0;
        while (choice != 5){
            System.out.println("Please select an operation:");
            System.out.println("1. Add two polynomials");
            System.out.println("2. Multiply two polynomials");
            System.out.println("3. Evaluate a polynomial");
            System.out.println("4. Derive a polynomial");
            System.out.println("5. Exit");

            choice = readInt();
            Polynomial p1;
            Polynomial p2;
            switch (choice) {
                case 1 -> {
                    p1 = readPolynomial();
                    p2 = readPolynomial();
                    printResult(p1.add(p2));
                }
                case 2 -> {
                    p1 = readPolynomial();
                    p2 = readPolynomial();
                    printResult(p1.mul(p2));
                }
                case 3 -> {
                    p1 = readPolynomial();
                    Scalar val = new IntegerScalar(readInt("Please enter the value to evaluate at:"));
                    printResult(p1.evaluate(val));
                }
                case 4 -> {
                    p1 = readPolynomial();
                    printResult(p1.derivative());
                }
                case 5 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public Polynomial readPolynomial(){
        System.out.println("Please enter a polynomial:");
        return Polynomial.build(readLine());
    }

    public int readInt(){
        return Integer.parseInt(s.nextLine());
    }

    public int readInt(String prompt){
        System.out.println(prompt);
        return readInt();
    }

    public String readLine(){
        return s.nextLine();
    }

    public void printResult(Object o){
        System.out.println("The result is:");
        System.out.println(o);
    }
    public static void main(String[] args){
        Calculator c = new Calculator();
        c.start();
    }
}