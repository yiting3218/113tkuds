package practice0722;

public class fibonacci {

    // 遞迴計算 Fibonacci 第 n 項
    public static int fibonacci(int n) {
        if (n == 0) return 0; // 第 0 項是 0
        if (n == 1) return 1; // 第 1 項是 1
        return fibonacci(n - 1) + fibonacci(n - 2); // 遞迴關係式
    }

    public static void main(String[] args) {
        System.out.println("fibonacci(0) = " + fibonacci(0)); // 0
        System.out.println("fibonacci(1) = " + fibonacci(1)); // 1
        System.out.println("fibonacci(5) = " + fibonacci(5)); // 5
        System.out.println("fibonacci(10) = " + fibonacci(10)); // 55
    }
}
