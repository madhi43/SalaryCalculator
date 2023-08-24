import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] hoursWorked = new int[7];

        for (int i = 0; i < 7; i++) {
            hoursWorked[i] = scanner.nextInt();
        }

        int weeklySalary = calculateSalary(hoursWorked);
        System.out.println(weeklySalary);
    }

    public static int calculateSalary(int[] hoursWorked) {
        int baseRate = 100;
        int extraHourlyRate = 15;
        int weeklyBonusRate = 25;
        double saturdayBonus = 0.25;
        double sundayBonus = 0.5;

        int weeklySalary = 0;
        int totalHours = 0;

        for (int day = 0; day < 7; day++) {
            int hours = hoursWorked[day];
            double dailySalary;

            if (day == 5) {
                dailySalary = (baseRate + extraHourlyRate * Math.max(hours - 8, 0)) * (1 + saturdayBonus);
            } else if (day == 6) {
                dailySalary = (baseRate + extraHourlyRate * Math.max(hours - 8, 0)) * (1 + sundayBonus);
            } else {
                dailySalary = baseRate + extraHourlyRate * Math.max(hours - 8, 0);
            }

            weeklySalary += dailySalary;
            totalHours += hours;
        }

        if (totalHours > 40) {
            weeklySalary += (totalHours - 40) * weeklyBonusRate;
        }

        return (int) weeklySalary;
    }
}