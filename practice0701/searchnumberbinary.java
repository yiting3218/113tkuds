package practice0701;

import java.util.Scanner;

public class searchnumberbinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 這裡準備一個已排序好的資料（1~100）
        int[] s = new int[100];
        for (int i = 0; i < s.length; i++) {
            s[i] = i + 1;   // s = {1, 2, 3, ..., 100}
        }

        System.out.print("請輸入要搜尋的數字 (1~100)：");
        int x = scanner.nextInt();   // 目標值
        boolean found = false;       // 是否找到

        int left = 0;                // 左邊界
        int right = s.length - 1;    // 右邊界

        // 二分搜尋核心迴圈
        while (left <= right) {
            int mid = (left + right) / 2;   // 取中間索引
            System.out.println("比較中：left=" + left +
                               ", right=" + right +
                               ", mid=" + mid +
                               "，中間元素 = " + s[mid]);

            if (s[mid] == x) {       // 找到了
                found = true;
                break;
            } else if (s[mid] < x) { // 目標在右半邊
                left = mid + 1;
            } else {                 // 目標在左半邊
                right = mid - 1;
            }
        }

        // 結果輸出
        if (found) {
            System.out.println("Yes，找到目標 " + x + "！");
        } else {
            System.out.println("No，沒有找到目標 " + x + "。");
        }
    }
}
