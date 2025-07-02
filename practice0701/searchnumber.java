package practice0701;

import java.util.Scanner;

public class searchnumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("請輸入要搜尋的數字：");
        int x = input.nextInt();

        boolean found = false;

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println("比較中：x = " + x + "，目前檢查 " + i + " * " + j);
                if (i * j == x) {
                    System.out.println(x + " = " + i + " * " + j);
                    found = true;
                }
            }
        }

        if (found) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
