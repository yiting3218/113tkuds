package midterm;

import java.util.Scanner;

public class Q1_THSRStopCounter {

    /**
     * Time Complexity: O(n)
     * 說明：我們只需要遍歷一次站點列表來查找起點和終點的索引，這是線性搜尋。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀取停靠站數量
        int n = sc.nextInt();
        sc.nextLine(); // 清除換行符

        // 讀取所有站點名稱
        String[] stations = sc.nextLine().split(" ");

        // 讀取起點和終點站代碼
        String start = sc.next();
        String end = sc.next();

        // 查找起點和終點的索引
        int startIdx = -1, endIdx = -1;

        for (int i = 0; i < n; i++) {
            if (stations[i].equals(start)) {
                startIdx = i;
            }
            if (stations[i].equals(end)) {
                endIdx = i;
            }
        }

        // 若任一站不存在，輸出 Invalid
        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            // 計算停靠站數
            int stops = Math.abs(startIdx - endIdx) + 1;
            System.out.println(stops);
        }

        sc.close();
    }
}
