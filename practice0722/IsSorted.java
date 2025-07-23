package practice0722;

public class IsSorted {

    public static boolean isSorted(int[] arr, int index) {
        if (index >= arr.length - 1) {
            return true;
        }

        if (arr[index] > arr[index + 1]) {
            return false;
        }

        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {1, 3, 2, 4, 5};
        int[] a3 = {10};
        int[] a4 = {};

        System.out.println("a1 是否排序: " + isSorted(a1, 0)); 
        System.out.println("a2 是否排序: " + isSorted(a2, 0)); 
        System.out.println("a3 是否排序: " + isSorted(a3, 0)); 
        System.out.println("a4 是否排序: " + isSorted(a4, 0)); 
    }
}
