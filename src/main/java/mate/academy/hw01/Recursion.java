package mate.academy.hw01;

public class Recursion {
    public static void main(String[] args) {
        System.out.println("Factorial(5) = " + factorial(5));
        System.out.println("Fibonacci(6) = " + fibonacci(6));
        System.out.println("Exponenta(5, 10) = " + exponent(5, 10));
    }

    private static int factorial(int number) {
        if (number == 0) {
            return 1;
        }
        return factorial(number - 1) * number;
    }

    private static int fibonacci(int number) {
        if (number == 1 || number == 2) {
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    private static double exponent(int degree, int times) {
        if (times == 0) {
            return 1;
        }
        return Math.pow(degree, times) / factorial(times) + exponent(degree, times - 1);
    }
}
