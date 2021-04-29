import java.math.BigDecimal;

public class Trigonometry {
    public double calculateCos(Double x, double accuracy) {
        if (x.isNaN() || x.isInfinite())
            return Double.NaN;
        double x_initial = x;
        x = x * Math.PI / 180;

        double n, m, sign, result;
        result = 1;

        if (x > 0)
            while (x > 2 * Math.PI) {
                x = x - 2 * Math.PI;
            }
        else
            while (x < 2 * Math.PI) {
                x = x + 2 * Math.PI;
            }

        n = 2;
        m = 1;
        sign = -1;
        while (m > accuracy) {
            m = m * x * x / ((n - 1) * n);
            result = result + sign * m;
            sign = - sign;
            n = n + 2;
        }
        LogWriter.write("cos", x_initial, result);
        return result;

    }

    public double calculateSin(Double x, double accuracy) {
        Double result = Math.sqrt(1 - Math.pow(calculateCos(x, accuracy), 2));
        double x_initial = x;
        if(!result.isNaN()) {
            x = x * Math.PI / 180;

            if (x > 0)
                while (x > 2 * Math.PI) {
                    x = x - 2 * Math.PI;
                }
            else
                while (x < 2 * Math.PI) {
                    x = x + 2 * Math.PI;
                }
                if(x >  Math.PI || x < - Math.PI)
                    result = -result;
        }

//        if ((Math.round(x / ( Math.PI)) % 2 != 0))
//            result = (result == 0 ? 0 : -1 * result);
        LogWriter.write("sin", x_initial, result);
        return result;
    }

    public double calculateSec(double x, double accuracy) {
        double result;
        Double cos = calculateCos(x, accuracy);

        if(cos.isNaN() || BigDecimal.valueOf(cos).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue() == 0) {
            result = Double.NaN;
        } else {
            result = 1 / cos;
        }
        LogWriter.write("sec", x, result);
        return result;
    }

    public double calculateTg(double x, double accuracy) {
        double result;
        double sin = calculateSin(x, accuracy);
        Double cos = calculateCos(x, accuracy);

        if(cos.isNaN() || BigDecimal.valueOf(cos).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue() == 0) {
            result = Double.NaN;
        } else {
            result = sin / cos;
        }
        LogWriter.write("tg", x, result);
        return result;
    }

    public double calculateCot(double x, double accuracy) {
        double result;
        Double sin = calculateSin(x, accuracy);
        double cos = calculateCos(x, accuracy);

        if(sin.isNaN() || BigDecimal.valueOf(sin).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue() == 0) {
            result = Double.NaN;
        } else {
            result = cos / sin;
        }
        LogWriter.write("cot", x, result);
        return result;
    }
}
