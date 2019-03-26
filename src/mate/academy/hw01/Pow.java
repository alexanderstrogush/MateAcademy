package mate.academy.hw01;

import java.lang.Math;

public class Pow {
    public static void main(String[] args) {
        System.out.println("4^(-5) = " + pow(4, -5));
        System.out.println("3^10 = " + pow(3, 10));
        System.out.println("0.2^-3 = " + pow(0.2, -3));
    }
    
    private static double pow(double number, int degree) {
        double result = 1;
        for (int i = 0; i < Math.abs(degree); i++) {
            result *= number;
        }
        if (degree > 0) {
            return result;
        } else {
            return (1 / result);
        }
    }
}
