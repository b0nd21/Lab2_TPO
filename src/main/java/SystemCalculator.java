public class SystemCalculator {
    private  Trigonometry trigonometry;
    private  CalcLog calcLog;

    public SystemCalculator() {
        trigonometry = new Trigonometry();
        calcLog = new CalcLog();
    }

    public double calculate(double x, double acc) {
        double result;
        if(x > 0)
        {
            double ln = calcLog.ln(x, acc);
            double log_2 = calcLog.log(x, 2d, acc);
            double log_3 = calcLog.log(x, 3d, acc);
            double log_5 = calcLog.log(x, 5d, acc);
            double log_10 = calcLog.log(x, 10d, acc);
            result = (Math.pow((((log_2 + log_3) - ln) / log_3), 3) + ((log_5 + Math.pow(Math.pow(log_10, 3), 3)) * (log_2 * log_5)));
        } else
        {
            double sin = trigonometry.calculateSin(x, acc);
            double cos = trigonometry.calculateCos(x, acc);
            double tan = trigonometry.calculateTg(x, acc);
            double cot = trigonometry.calculateCot(x, acc);
            double sec = trigonometry.calculateSec(x, acc);
            result = ((Math.pow(((tan- sin) + (sec * cos)), 2) / (cos / cot)) * tan);
        }
        LogWriter.write("system", x, result);
        return result;
    }
}
