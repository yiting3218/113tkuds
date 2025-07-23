package practice0722;

import java.util.Scanner;

public class FactorialExampleinput {

    public static int factorialAndPrint(int n) {
        if (n <= 1) {
            System.out.print("1");
            return 1;
        }
        System.out.print(n + "*");
        return n * factorialAndPrint(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入一個整數來計算階乘(不可為負數及非整數): ");

        if (!scanner.hasNextInt()) {
            System.out.println("輸入錯誤：請輸入一個整數！");
            return;
        }

        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("輸入錯誤：不能輸入負數！");
            return;
        }

        System.out.print(n + "! = ");
        int result = factorialAndPrint(n);
        System.out.println(" = " + result);

        scanner.close();
    }
}
