package midterm;

import java.util.Scanner;

public class Q3_NightMarketRanking {

    /**
     * Time Complexity: O(n²)
     * 說明：選擇排序的時間複雜度是 O(n²)，因為外層迴圈會執行 n 次，而每次都需要執行 n-1 次比較。
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 讀取攤位數量
        int n = sc.nextInt();
        sc.nextLine();  // 清除換行符

        // 2. 讀取評分並儲存在陣列中
        double[] scores = new double[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
        }

        // 3. 使用選擇排序排序評分（由高到低）
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIdx]) {
                    maxIdx = j;
                }
            }
            // 交換位置
            double temp = scores[i];
            scores[i] = scores[maxIdx];
            scores[maxIdx] = temp;
        }

        // 4. 輸出前 5 名分數（若不足 5 名則全列）
        int count = Math.min(5, n);
        for (int i = 0; i < count; i++) {
            System.out.printf("%.1f\n", scores[i]);
        }

        sc.close();
    }
}
