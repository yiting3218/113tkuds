package practice0722;

public class FibonacciCompare {

    // 標準遞迴（效率差）
    public static int fibonacciSlow(int n) {
        if (n <= 1) return n;
        return fibonacciSlow(n - 1) + fibonacciSlow(n - 2);
    }

    // 記憶化遞迴（效率好）
    public static int fibonacciFast(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 35; // 可改成你要比較的項數

        System.out.println("=== Fibonacci 效能比較（n = " + n + ") ===");

        // 測試慢版
        long start1 = System.currentTimeMillis();
        int result1 = fibonacciSlow(n);
        long end1 = System.currentTimeMillis();
        System.out.println("fibonacciSlow(" + n + ") = " + result1);
        System.out.println("耗時：" + (end1 - start1) + " 毫秒");

        // 測試快版
        int[] memo = new int[n + 1];
        long start2 = System.currentTimeMillis();
        int result2 = fibonacciFast(n, memo);
        long end2 = System.currentTimeMillis();
        System.out.println("fibonacciFast(" + n + ") = " + result2);
        System.out.println("耗時：" + (end2 - start2) + " 毫秒");
    }
}
