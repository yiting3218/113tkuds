package practice0708;

import java.util.Arrays;

public class ArrayUtility {
    
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static int[] copyArray(int[] array) {
        return Arrays.copyOf(array, array.length);
    }

    public static int findSecondLargest(int[] array) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num < first) {
                second = num;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] array = {3, 7, 1, 9, 4, 6, 8, 2, 5};

        System.out.print("原始陣列：");
        printArray(array);

        System.out.print("反轉陣列：");
        reverseArray(array);
        printArray(array);

        int[] copiedArray = copyArray(array);
        System.out.print("副本陣列：");
        printArray(copiedArray);

        int secondLargest = findSecondLargest(array);
        System.out.println("第二大的數字是：" + secondLargest);
    }
}
