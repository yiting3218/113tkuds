package practice0701;

public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][] a = { {1, 2}, {3, 4} };
        int[][] b = { {5, 6}, {7, 8} };
        int[][] c = new int[2][2]; 

        for (int i = 0; i < 2; i++) {        
            for (int j = 0; j < 2; j++) {     
                c[i][j] = 0;                  
                System.out.print("計算位置 c[" + i + "][" + j + "] = ");
                for (int k = 0; k < 2; k++) {  
                    int product = a[i][k] * b[k][j];
                    c[i][j] += product;
                    System.out.print(a[i][k] + "*" + b[k][j]);
                    if (k == 0) System.out.print(" = " + product + " + ");
                    else System.out.print(" = " + product);
                }
                System.out.println(" = " + c[i][j]);
            }
        }

        System.out.println("結果矩陣：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(c[i][j] + "\t");
            }
            System.out.println();
        }
    }
}