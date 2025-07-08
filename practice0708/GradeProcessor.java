package practice0708;

public class GradeProcessor {
    public static void main(String[] args) {
        int[] grades = {78, 85, 92, 67, 88, 95, 73, 90};

        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        double average = total / (double) grades.length;
        System.out.printf("總分: %d, 平均分數: %.2f%n", total, average);

        int maxGrade = grades[0];
        int minGrade = grades[0];
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > maxGrade) {
                maxGrade = grades[i];
                maxIndex = i;
            }
            if (grades[i] < minGrade) {
                minGrade = grades[i];
                minIndex = i;
            }
        }
        System.out.printf("最高分: %d, 索引位置: %d%n", maxGrade, maxIndex);
        System.out.printf("最低分: %d, 索引位置: %d%n", minGrade, minIndex);

        int countAboveAverage = 0;
        for (int grade : grades) {
            if (grade > average) {
                countAboveAverage++;
            }
        }
        System.out.printf("有 %d 位學生的成績超過平均分數%n", countAboveAverage);

        System.out.println("學生編號與成績:");
        for (int i = 0; i < grades.length; i++) {
            System.out.printf("學生編號: %d, 成績: %d%n", i + 1, grades[i]);
        }
    }
}
