import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LogTest {
    @Test
    public void testLn() {
        CalcLog calcLog = new CalcLog();

        Assertions.assertEquals(Double.NaN, calcLog.ln(Double.NaN, 0.0000000001));
        Assertions.assertEquals(Double.NaN, calcLog.ln(Double.POSITIVE_INFINITY,0.0000000001));

        Assertions.assertEquals(Double.NaN, calcLog.ln(0d, 0.0000000001));

        Assertions.assertEquals(0d, calcLog.ln(1d,0.0000000001), 0.00001);
        Assertions.assertEquals(1.6094379, calcLog.ln(5d,0.0000000001), 0.00001);
        Assertions.assertEquals(0.850151, calcLog.ln(2.34,0.0000000001), 0.00001);
        Assertions.assertEquals(1d, calcLog.ln(2.71828182846,0.0000000001), 0.00001);
    }

    @Test
    public void testLog() {
        CalcLog calcLog =  Mockito.spy(CalcLog.class);

        Assertions.assertEquals(Double.NaN, calcLog.log(5d, Double.NaN, 0.0000000001));
        Assertions.assertEquals(Double.NaN, calcLog.log(5d, Double.POSITIVE_INFINITY,0.0000000001));
        Assertions.assertEquals(Double.NaN, calcLog.log(5d, 0d, 0.0000000001));

        Mockito.when(calcLog.ln(Mockito.eq(1d), Mockito.eq(0.0000000001))).thenReturn(0d);
        Assertions.assertEquals(0d, calcLog.log(1d,2d, 0.0000000001), 0.00001);
        Assertions.assertEquals(0d, calcLog.log(1d,3d, 0.0000000001), 0.00001);

        Mockito.when(calcLog.ln(Mockito.eq(5d), Mockito.eq(0.0000000001))).thenReturn(1.6094379);
        Assertions.assertEquals(2.32192809, calcLog.log(5d,2d, 0.0000000001), 0.00001);
        Assertions.assertEquals(1.46497352, calcLog.log(5d,3d, 0.0000000001), 0.00001);
        Assertions.assertEquals(1d, calcLog.log(5d,5d, 0.0000000001), 0.00001);
        Assertions.assertEquals(0.69897, calcLog.log(5d,10d, 0.0000000001), 0.00001);

        Mockito.when(calcLog.ln(Mockito.eq(2.34), Mockito.eq(0.0000000001))).thenReturn(0.850151);
        Assertions.assertEquals(1.22651, calcLog.log(2.34,2d, 0.0000000001), 0.00001);
        Assertions.assertEquals(0.773841, calcLog.log(2.34,3d, 0.0000000001), 0.00001);
        Assertions.assertEquals(0.528228, calcLog.log(2.34,5d, 0.0000000001), 0.00001);
        Assertions.assertEquals(0.369216, calcLog.log(2.34,10d, 0.0000000001), 0.00001);

        Mockito.when(calcLog.ln(Mockito.eq(2.71828182846), Mockito.eq(0.0000000001))).thenReturn(1d);
        Assertions.assertEquals(1.442695, calcLog.log(2.71828182846,2d, 0.0000000001), 0.00001);
        Assertions.assertEquals(0.910239, calcLog.log(2.71828182846,3d, 0.0000000001), 0.00001);
        Assertions.assertEquals(0.621334, calcLog.log(2.71828182846,5d, 0.0000000001), 0.00001);
        Assertions.assertEquals(0.434294, calcLog.log(2.71828182846,10d, 0.0000000001), 0.00001);
    }

    @Test
    public void testLogInt() {
        CalcLog calcLog = new CalcLog();

        Assertions.assertEquals(0d, calcLog.log(1d,2d, 0.0000000001), 0.00001);
        Assertions.assertEquals(0d, calcLog.log(1d,3d, 0.0000000001), 0.00001);

        Assertions.assertEquals(2.32192809, calcLog.log(5d,2d, 0.0000000001), 0.00001);
        Assertions.assertEquals(1.46497352, calcLog.log(5d,3d, 0.0000000001), 0.00001);
        Assertions.assertEquals(1d, calcLog.log(5d,5d, 0.0000000001), 0.00001);
        Assertions.assertEquals(0.69897, calcLog.log(5d,10d, 0.0000000001), 0.00001);

        Assertions.assertEquals(1.22651, calcLog.log(2.34,2d, 0.0000000001), 0.00001);
        Assertions.assertEquals(0.773841, calcLog.log(2.34,3d, 0.0000000001), 0.00001);
        Assertions.assertEquals(0.528228, calcLog.log(2.34,5d, 0.0000000001), 0.00001);
        Assertions.assertEquals(0.369216, calcLog.log(2.34,10d, 0.0000000001), 0.00001);

        Assertions.assertEquals(1.442695, calcLog.log(2.71828182846,2d, 0.0000000001), 0.00001);
        Assertions.assertEquals(0.910239, calcLog.log(2.71828182846,3d, 0.0000000001), 0.00001);
        Assertions.assertEquals(0.621334, calcLog.log(2.71828182846,5d, 0.0000000001), 0.00001);
        Assertions.assertEquals(0.434294, calcLog.log(2.71828182846,10d, 0.0000000001), 0.00001);
    }
}
