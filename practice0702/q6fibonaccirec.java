package practice0702;

import java.util.Scanner;

public class q6fibonaccirec {
    public static int ops = 0; 

    public static int fibonacci(int n) {
        ops++;  

        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入 n（小於或等於 40）：");
        int n = sc.nextInt();  

        int result = fibonacci(n);  

        System.out.println(result);  
        System.out.println(ops);     
    }
}