package midterm;

import java.util.Scanner;

public class Q2_NextTHSRDeparture {

    /**
     * Time Complexity: O(log n)
     * 說明：將時間轉換為分鐘數是 O(n)，使用二分搜尋找到下一班的時間是 O(log n)。總的時間複雜度為 O(n + log n)，由於時間轉換是線性的，我們可以將其簡化為 O(n)。
     */
    public static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 讀取班次數量
        int n = sc.nextInt();
        sc.nextLine();  // 清除換行符

        // 2. 儲存所有班次的時間（轉換為分鐘數）
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            String time = sc.nextLine();
            times[i] = timeToMinutes(time);
        }

        // 3. 讀取查詢時間並轉換為分鐘數
        String queryTime = sc.nextLine();
        int query = timeToMinutes(queryTime);

        // 4. 使用二分搜尋找出第一個大於查詢時間的班次
        int left = 0, right = n - 1;
        int idx = n;  // 預設為找不到

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (times[mid] > query) {
                idx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 5. 輸出結果
        if (idx == n) {
            System.out.println("No train");
        } else {
            // 將分鐘數轉換回時間字串格式
            int resultTime = times[idx];
            int hours = resultTime / 60;
            int minutes = resultTime % 60;
            System.out.printf("%02d:%02d\n", hours, minutes);
        }

        sc.close();
    }
}
