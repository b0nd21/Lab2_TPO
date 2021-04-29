public class Main {
    public static void main(String[] args) {
        SystemCalculator systemCalculator = new SystemCalculator();
        for(double i = -50d; i <= 50d; i += 10d)
        {
            System.out.println(systemCalculator.calculate(i, 0.00000001));

        }

    }
}