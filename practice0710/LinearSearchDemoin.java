package practice0710;

import java.util.Scanner;

public class LinearSearchDemoin {

    public static int linearSearch(int[] array, int target) {
        int comparisons = 0;

        for (int i = 0; i < array.length; i++) {
            comparisons++;
            System.out.printf("第 %d 次比較：array[%d] = %d，目標值 = %d\n",
                    comparisons, i, array[i], target);

            if (array[i] == target) {
                System.out.printf("找到目標值！總共比較了 %d 次\n", comparisons);
                return i;
            }
        }

        System.out.printf("找不到目標值，總共比較了 %d 次\n", comparisons);
        return -1;
    }

    static int[] linearSearchAll(int[] array, int target) {
        int count = 0;
        for (int value : array) {
            if (value == target) {
                count++;
            }
        }

        if (count == 0) {
            return new int[0];
        }

        int[] result = new int[count];
        int resultIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                result[resultIndex++] = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[6];

        System.out.println("請輸入 6 個整數：");
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("第 %d 個數字：", i + 1);
            numbers[i] = scanner.nextInt();
        }

        System.out.print("請輸入要搜尋的目標值：");
        int target = scanner.nextInt();
        scanner.close();

        System.out.println("陣列內容：" + java.util.Arrays.toString(numbers));
        System.out.println("搜尋目標：" + target);
        System.out.println();

        System.out.println("=== 基本線性搜尋 ===");
        int result = linearSearch(numbers, target);

        if (result != -1) {
            System.out.printf("在索引位置 %d 找到目標值 %d\n", result, target);
        } else {
            System.out.printf("找不到目標值 %d\n", target);
        }

        System.out.println("\n=== 搜尋所有符合位置 ===");
        int[] allPositions = linearSearchAll(numbers, target);

        if (allPositions.length > 0) {
            System.out.printf("目標值 %d 出現在以下位置：", target);
            for (int i = 0; i < allPositions.length; i++) {
                System.out.print(allPositions[i]);
                if (i < allPositions.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.printf("\n總共出現 %d 次\n", allPositions.length);
        } else {
            System.out.printf("找不到目標值 %d\n", target);
        }
    }
}