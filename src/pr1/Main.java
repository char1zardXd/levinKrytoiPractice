package pr1;

import java.util.Scanner;

public class Main {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введiть n: ");
        int n = scanner.nextInt();

        System.out.println("A. O(1): " + o1(n));
        System.out.println("L. O(log n): " + ologn(n));
        System.out.println("B. O(n): " + on(n));
        System.out.println("D. O(n log n): " + onlogn(n));
        System.out.println("C. O(n2): " + on2(n));
        System.out.println("E. O(2n): " + o2n(n));
        System.out.println("F. O(n!): " + onfac(n));
    }

    static int o1 (int n) {
        int steps = 1;
        int sum = n * (n + 1) / 2;
        return steps;
    }

    static int ologn (int n) {
        int steps = 0;
        int j = n;

        while(j > 1) {
            steps++;
            j /= 2;
        }

        return steps;
    }

    static int on (int n) {
        int steps = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            steps++;
            sum++;
        }

        return steps;
    }

    static int onlogn (int n) {
        int steps = 0;

        for (int i = 1; i < n; i++) {
            int j = n;
            while (j > 1) {
                steps++;
                j /= 2;
            }
        }

        return steps;
    }

    static int on2 (int n) {
        int steps = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                steps++;
            }
        }

        return steps;
    }

    static long o2n (int n) {
        long steps = 0;
        int limit = 1;

        for (int i = 0; i < n; i++) {
            limit *= 2;
        }
        for (int k = 0; k < limit; k++) {
            steps++;
        }

        return steps;
    }

    static long onfac (int n) {
        long steps = 0;
        int limit = 1;

        for (int i = 1; i < n; i++) {
            limit *= i;
        }
        for (int k = 1; k < limit; k++) {
            steps++;
        }

        return steps;
    }
}