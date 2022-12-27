import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().startApplication();
    }

    double calculateComplexPercentFunction(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return calculatePercent(pay, 2);
    }

    double calculateSimplePercentFunction(double amount, double yearRate, int depositPeriod) {
        return calculatePercent(amount
                        + amount
                        * yearRate
                        * depositPeriod,
                2);
    }

    double calculatePercent(double value, int numbersAfterDecimalPoint) {
        double scale = Math.pow(10, numbersAfterDecimalPoint);
        return Math.round(value * scale) / scale;
    }

    void startApplication() {
        int period;
        int action;
        double out = 0;
        Scanner localScanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = localScanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = localScanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = localScanner.nextInt();
        if (action == 1) {
            out = calculateSimplePercentFunction(amount, 0.06, period);

        } else if (action == 2) {
            out = calculateComplexPercentFunction(amount, 0.06, period);
        }
        System.out.println("Результат вклада: "
                + amount
                + " за "
                + period
                + " лет превратятся в "
                + out);
    }
}
