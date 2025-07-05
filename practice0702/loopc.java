package practice0702;

public class loopc {
    public static void main(String[] args) {
        int x = 0;
        int count = 0;

        do {
            x = x + 1;
            count++;
        } while (x <= 100);  

        System.out.println("count = " + count); 
    }
}