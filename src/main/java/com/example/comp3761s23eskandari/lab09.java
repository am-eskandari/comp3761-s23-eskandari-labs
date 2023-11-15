package com.example.comp3761s23eskandari;

public class lab09 {
    public static void main(String[] args) {
        System.out.println("Fibonacci of 3: " + fibo(3));
        System.out.println("Fibonacci of 7: " + fibo(7));
        System.out.println("Fibonacci of 5: " + fibo(5));
    }

    public static int fibo(int n) {
        if(n <= 1) {
            return n;
        }
        
        int[] fib = new int[n + 1];

        // base cases
        fib[0] = 0;
        fib[1] = 1;

        // fill the fib array
        for(int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib[n];
    }
}
