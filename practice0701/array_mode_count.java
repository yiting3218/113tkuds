package practice0701;

import java.util.Scanner;

public class array_mode_count {
    public static void main(String[] args) {
        int[] arr = {3, 7, 3, 1, 1, 1};  
        int maxCount = 0;  
        int mode = arr[0];  
        int[] count = new int[arr.length];  

        for (int i = 0; i < arr.length; i++) {
            count[i] = 1;  
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count[i]++;  
                }
            }
            System.out.println("比對中：" + arr[i] + " 出現次數 = " + count[i]);
            if (count[i] > maxCount) {
                maxCount = count[i];
                mode = arr[i];  
            }
        }

        System.out.println("眾數為：" + mode + "，出現 " + maxCount + " 次");
    }
}