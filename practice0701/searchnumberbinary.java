package practice0701;

import java.util.Scanner;

public class searchnumberbinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] s = new int[100];
        for (int i = 0; i < s.length; i++) {
            s[i] = i + 1;   
        }

        System.out.print("請輸入要搜尋的數字 (1~100)：");
        int x = scanner.nextInt();   
        boolean found = false;       

        int left = 0;                
        int right = s.length - 1;    

        while (left <= right) {
            int mid = (left + right) / 2;   
            System.out.println("比較中：left=" + left +
                               ", right=" + right +
                               ", mid=" + mid +
                               "，中間元素 = " + s[mid]);

            if (s[mid] == x) {      
                found = true;
                break;
            } else if (s[mid] < x) { 
                left = mid + 1;
            } else {                
                right = mid - 1;
            }
        }

        if (found) {
            System.out.println("Yes，找到目標 " + x + "！");
        } else {
            System.out.println("No，沒有找到目標 " + x + "。");
        }
    }
}
