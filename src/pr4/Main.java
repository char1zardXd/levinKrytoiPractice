package pr4;

import java.util.Arrays;

public class Main {
    public static long factorial (int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static long fib (int n) {
        if (n <= 1) {
            return 1;
        }
        return fib(n - 1) * fib(n - 2);
    }

    public static long fib_iter (int n) {
        if (n <= 1) {
            return 1;
        }

        long prev = 0;
        long curr = 1;

        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static void generatePermutations(char[] elements, int currentIndex) {
        if (currentIndex == elements.length - 1) {
            System.out.println(Arrays.toString(elements));
            return;
        }

        for (int i = currentIndex; i < elements.length; i++) {
            swap(elements, currentIndex, i);
            generatePermutations(elements, currentIndex + 1);
            swap(elements, currentIndex, i);
        }
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static long combinations(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    static void main(String[] args) {
        int n = 5;
        char[] set = {'A', 'B', 'C'};

        System.out.println("factorial " + n + "!: " + factorial(n));

        long recFib = fib(n);
        long iterFib = fib_iter(n);
        System.out.println("\nfib(" + n + "): " + recFib);
        System.out.println("fib_iter(" + n + "): " + iterFib);
        System.out.println((recFib == iterFib));

        System.out.println("\nперестановки " + Arrays.toString(set) + ":");
        generatePermutations(set, 0);

        int setSize = set.length;
        int k = 2;
        System.out.println("\nкол-во комбинаций C(" + setSize + ", " + k + "): " + combinations(setSize, k));
    }
}
