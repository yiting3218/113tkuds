package practice0708;

public class ArrayStatistics {
    public static void main(String[] args) {
        int[] array = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        double average = (double) sum / array.length;

        int max = array[0];
        int min = array[0];
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }

        int countAboveAverage = 0;
        for (int num : array) {
            if (num > average) {
                countAboveAverage++;
            }
        }

        int evenCount = 0;
        int oddCount = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("總和: " + sum);
        System.out.printf("平均值: %.2f%n", average);
        System.out.println("最大值: " + max + "，索引位置: " + maxIndex);
        System.out.println("最小值: " + min + "，索引位置: " + minIndex);
        System.out.println("有 " + countAboveAverage + " 位學生的成績超過平均分數");
        System.out.println("偶數個數: " + evenCount);
        System.out.println("奇數個數: " + oddCount);
    }
}
