package midterm;

import java.util.Scanner;

public class Q8_MergeTHSRPriceTable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); 

        String[] station = new String[n];
        int[][] price = new int[n][2];  

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] data = line.split(" "); 

            station[i] = data[0];  
            price[i][0] = Integer.parseInt(data[1]); 
            price[i][1] = Integer.parseInt(data[2]);  
        }

        System.out.println("Station|Standard|Business");

        for (int i = 0; i < n; i++) {
            System.out.printf("%s|%d|%d\n", station[i], price[i][0], price[i][1]);
        }

        sc.close();
    }
}
