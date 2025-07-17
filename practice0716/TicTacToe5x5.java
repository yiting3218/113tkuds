package practice0716;

import java.util.Scanner;

public class TicTacToe5x5 {
    static final int SIZE = 5;
    static char[][] board = new char[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initBoard();

        System.out.println("=== 5x5 井字遊戲 ===\n");
        printBoard();

        char currentPlayer = 'X';
        while (true) {
            int row = -1, col = -1;

            while (true) {
                System.out.printf("請玩家 %c 輸入 row col：", currentPlayer);
                if (!sc.hasNextInt()) {
                    System.out.println("請輸入整數！");
                    sc.nextLine(); 
                    continue;
                }
                row = sc.nextInt();
                if (!sc.hasNextInt()) {
                    System.out.println("請輸入整數！");
                    sc.nextLine();
                    continue;
                }
                col = sc.nextInt();

                if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                    System.out.println("座標超出範圍，請重新輸入！");
                } else if (board[row][col] != '.') {
                    System.out.println("該位置已被佔用，請重新輸入！");
                } else {
                    break;
                }
            }

            board[row][col] = currentPlayer;
            System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子\n", currentPlayer, row, col);
            printBoard();

            if (checkWin(currentPlayer)) {
                System.out.printf("玩家 %c 獲勝！\n", currentPlayer);
                break;
            } else if (isBoardFull()) {
                System.out.println("平手！");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        sc.close();
    }

    static void initBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = '.';
    }

    static void printBoard() {
        System.out.print("  ");
        for (int j = 0; j < SIZE; j++)
            System.out.print(j + " ");
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == '.')
                    return false;
        return true;
    }

    static boolean checkWin(char player) {
        for (int i = 0; i < SIZE; i++) {
            boolean rowWin = true;
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != player) {
                    rowWin = false;
                    break;
                }
            }
            if (rowWin) return true;
        }

        for (int j = 0; j < SIZE; j++) {
            boolean colWin = true;
            for (int i = 0; i < SIZE; i++) {
                if (board[i][j] != player) {
                    colWin = false;
                    break;
                }
            }
            if (colWin) return true;
        }

        boolean diag1 = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][i] != player) {
                diag1 = false;
                break;
            }
        }
        if (diag1) return true;

        boolean diag2 = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][SIZE - 1 - i] != player) {
                diag2 = false;
                break;
            }
        }
        return diag2;
    }
}
