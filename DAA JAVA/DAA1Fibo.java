public class DAA1Fibo {
    static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 30;

        long start1 = System.nanoTime();
        int rec = fibonacciRecursive(n);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        int iter = fibonacciIterative(n);
        long end2 = System.nanoTime();

        System.out.println("Recursive Fibonacci of " + n + " = " + rec);
        System.out.println("Execution Time (Recursive): " + (end1 - start1) + " ns");
        System.out.println("Iterative Fibonacci of " + n + " = " + iter);
        System.out.println("Execution Time (Iterative): " + (end2 - start2) + " ns");

        System.out.println("\n--- Complexity Analysis ---");
        System.out.println("Recursive: Time O(2^n), Space O(n)");
        System.out.println("Iterative: Time O(n), Space O(1)");
    }
}
