
public class CalcLog {
    public double ln(Double x, double acc){
        if (x.isNaN() || x.isInfinite() || x <= 0 )
            return Double.NaN;
        double prev = 10;
        double current = 0;
        int n = 1;
        while(Math.abs(prev - current) >= acc){
            prev = current;
            current += Math.pow((x - 1) / (x + 1), n) / n;
            n += 2;
        }
        double value = 2 * current;
        LogWriter.write("ln", x, value);
        return value;
    }

    public double log(double x, Double base, double acc) {
        if (base.isNaN() || base.isInfinite() || base <= 0 )
            return Double.NaN;
        double value = ln(x,acc) / ln(base,acc);
        LogWriter.write("log" + base, x, value);
        return value;
    }
}
