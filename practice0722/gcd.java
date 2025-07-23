package practice0722;

public class gcd {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println("gcd of 48 and 18: " + gcd(48, 18)); // 6
        System.out.println("gcd of 30 and 45: " + gcd(30, 45)); // 15
        System.out.println("gcd of 20 and 8: " + gcd(20, 8));   // 4
    }
}