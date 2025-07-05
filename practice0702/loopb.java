package practice0702;

public class loopb {
    public static void main(String[] args) {
        int i = 1;
        int x = 0;
        int count = 0;

        while (++i <= 100) {
            x = x + 1;
            count++;
        }

        System.out.println("count = " + count); 
    }
}