package practice0722;

public class digitSum {

        public static int digitSum(int n) {
        if (n < 10) {
            return n; 
        }
        return (n % 10) + digitSum(n / 10); 
    }

    public static void main(String[] args) {
        System.out.println("digitSum(1234) = " + digitSum(1234)); // 10
        System.out.println("digitSum(9) = " + digitSum(9));       // 9
        System.out.println("digitSum(1001) = " + digitSum(1001)); // 2
    }
}