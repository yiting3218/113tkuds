package practice0708;

public class ArraySearcher {
    public static void main(String[] args) {
        int[] array = {12, 45, 23, 67, 34, 89, 56, 78, 91, 25};

        int index = findElement(array, 67);
        System.out.println("67 的索引位置: " + index);

        int indexNotFound = findElement(array, 100);
        System.out.println("100 的索引位置: " + indexNotFound);

        int count = countOccurrences(array, 67);
        System.out.println("67 出現的次數: " + count);
        
        int countNotFound = countOccurrences(array, 100);
        System.out.println("100 出現的次數: " + countNotFound);
    }

    public static int findElement(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1; 
    }

    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                count++; 
            }
        }
        return count;
    }
}
