package midterm;

import java.util.Scanner;

/*
 * Time Complexity: O(log n)
 * 說明：二分搜尋的時間複雜度為 O(log n)，將時間轉換為分鐘數的操作是 O(n)。總體時間複雜度是 O(n + log n)，可以簡化為 O(n)。
 */

public class Q4_TieredElectricBill {

    public static int calc(int kWh) {
        int bill = 0;

        if (kWh <= 120) {
            bill = (int) Math.round(kWh * 1.68);
        }

        else if (kWh <= 330) {
            bill = (int) Math.round(120 * 1.68 + (kWh - 120) * 2.45);
        }

        else if (kWh <= 500) {
            bill = (int) Math.round(120 * 1.68 + 210 * 2.45 + (kWh - 330) * 3.70);
        }

        else if (kWh <= 700) {
            bill = (int) Math.round(120 * 1.68 + 210 * 2.45 + 170 * 3.70 + (kWh - 500) * 5.04);
        }

        else if (kWh <= 1000) {
            bill = (int) Math.round(120 * 1.68 + 210 * 2.45 + 170 * 3.70 + 200 * 5.04 + (kWh - 700) * 6.24);
        }

        else {
            bill = (int) Math.round(120 * 1.68 + 210 * 2.45 + 170 * 3.70 + 200 * 5.04 + 300 * 6.24 + (kWh - 1000) * 8.46);
        }

        return bill;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); 

        int totalBill = 0;  
        int[] bills = new int[n];  

        for (int i = 0; i < n; i++) {
            int kWh = sc.nextInt();
            bills[i] = calc(kWh);
            totalBill += bills[i];
        }

        for (int bill : bills) {
            System.out.printf("Bill: $%d\n", bill);
        }

        int averageBill = (int) Math.round((double) totalBill / n);

        System.out.printf("Total: $%d\n", totalBill);
        System.out.printf("Average: $%d\n", averageBill);

        sc.close();
    }
}
