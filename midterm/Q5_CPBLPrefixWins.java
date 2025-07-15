package midterm;

import java.util.Scanner;

    /**
     * Time Complexity: O(n)
     * 說明：首先，我們遍歷一次陣列來計算前綴勝場數，這是 O(n) 的操作。
     * 然後，輸出前 k 場的結果，這是 O(k)，其中 k <= n，所以總體時間複雜度是 O(n)。
     */

public class Q5_CPBLPrefixWins {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] games = new int[n];

        for (int i = 0; i < n; i++) {
            games[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int[] prefixSum = new int[n + 1]; 
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + games[i - 1];
        }

        System.out.print("PrefixSum: ");
        for (int i = 1; i <= k; i++) {
            System.out.print(prefixSum[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}
