package practice0702;

import java.util.Scanner;

public class q7permutation {
    public static int ops = 0;  

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int[] perm = new int[n];
        generatePermutation(arr, used, perm, 0);
        System.out.println(ops);
    }

    public static void generatePermutation(int[] arr, boolean[] used, int[] perm, int depth) {
        if (depth == arr.length) {
            for (int i = 0; i < perm.length; i++) {
                System.out.print(perm[i] + " ");
            }
            System.out.println();
            ops++; 
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[depth] = arr[i];
                generatePermutation(arr, used, perm, depth + 1);
                used[i] = false; 
            }
        }
    }
}