package midterm;

import java.util.Scanner;

public class Q9_FindFiveStarStalls {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();  

        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        int count = 0;
        for (int score : scores) {
            if (score == 5) {
                count++;
            }
        }

        if (count > 0) {
            int[] indices = new int[count];
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (scores[i] == 5) {
                    indices[index++] = i;
                }
            }

            for (int i = 0; i < indices.length; i++) {
                System.out.print(indices[i]);
                if (i < indices.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        } else {

            System.out.println("None");
        }

        sc.close();
    }
}
