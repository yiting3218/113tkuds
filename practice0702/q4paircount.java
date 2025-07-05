package practice0702;

import java.util.Scanner;

public class q4paircount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();         
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int pairCount = 0;            
        int ops = 0;                  

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                ops++;                
                if (arr[i] != arr[j]) {
                    pairCount++;      
                }
            }
        }

        System.out.println(pairCount);  
        System.out.println(ops);      
    }
}
