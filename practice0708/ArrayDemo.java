package practice0708;

public class ArrayDemo {
    
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
            System.out.println("Index: "+ i);
            System.out.println("該單位元素佔"+ Integer.BYTES +"bytes");
        }
        
    }
}
