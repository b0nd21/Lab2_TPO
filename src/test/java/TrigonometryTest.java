import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TrigonometryTest {
    @Test
    public void testСos() {
        Trigonometry trigonometry = new Trigonometry();
        Assertions.assertEquals(trigonometry.calculateCos(Double.POSITIVE_INFINITY, 0.0000000001), Double.NaN);
        Assertions.assertEquals(trigonometry.calculateCos(Double.NaN, 0.0000000001), Double.NaN);

        Assertions.assertEquals( 1d, trigonometry.calculateCos(0d, 0.0000000001), 0.000001);
        Assertions.assertEquals(0d, trigonometry.calculateCos(270d, 0.0000000001), 0.000001);
        Assertions.assertEquals(0.8910065242, trigonometry.calculateCos(27d, 0.0000000001), 0.000001);
        Assertions.assertEquals(0.8660254038, trigonometry.calculateCos(-30d, 0.0000000001), 0.000001);
        Assertions.assertEquals(0.1736481777,trigonometry.calculateCos(100000d, 0.0000000001), 0.000001);
    }

    @Test
    public void testSin() {
        Trigonometry trigonometry =  Mockito.spy(Trigonometry.class);

        Mockito.when(trigonometry.calculateCos(Mockito.eq(0d), Mockito.eq(0.0000000001))).thenReturn(1d);
        Assertions.assertEquals(0d, trigonometry.calculateSin(0d, 0.0000000001), 0.000001);

        Mockito.when(trigonometry.calculateCos(Mockito.eq(270d), Mockito.eq(0.0000000001))).thenReturn(0d);
        Assertions.assertEquals(-1d, trigonometry.calculateSin(270d, 0.0000000001), 0.000001);

        Mockito.when(trigonometry.calculateCos(Mockito.eq(27d), Mockito.eq(0.0000000001))).thenReturn(0.8910065242);
        Assertions.assertEquals(0.45399049974, trigonometry.calculateSin(27d, 0.0000000001), 0.000001);

        Mockito.when(trigonometry.calculateCos(Mockito.eq(-30d), Mockito.eq(0.0000000001))).thenReturn(0.8660254038);
        Assertions.assertEquals(-0.5d, trigonometry.calculateSin(-30d, 0.0000000001), 0.000001);

        Mockito.when(trigonometry.calculateCos(Mockito.eq(100000d), Mockito.eq(0.0000000001))).thenReturn(0.1736481777);
        Assertions.assertEquals(-0.98480775301, trigonometry.calculateSin(100000d, 0.0000000001), 0.000001);
    }

    @Test
    public void testSinInt() {
        Trigonometry trigonometry = new Trigonometry();
        Assertions.assertEquals(trigonometry.calculateSin(Double.POSITIVE_INFINITY, 0.0000000001), Double.NaN);
        Assertions.assertEquals(trigonometry.calculateSin(Double.NaN, 0.0000000001), Double.NaN);

        Assertions.assertEquals(0d, trigonometry.calculateSin(0d, 0.0000000001), 0.000001);
        Assertions.assertEquals(-1d, trigonometry.calculateSin(270d, 0.0000000001), 0.000001);
        Assertions.assertEquals(0.45399049974, trigonometry.calculateSin(27d, 0.0000000001), 0.000001);
        Assertions.assertEquals(-0.5d, trigonometry.calculateSin(-30d, 0.0000000001), 0.000001);
        Assertions.assertEquals(-0.98480775301, trigonometry.calculateSin(100000d, 0.0000000001), 0.000001);
    }

    @Test
    public void testSec() {
        Trigonometry trigonometry =  Mockito.spy(Trigonometry.class);

        Mockito.when(trigonometry.calculateCos(Mockito.eq(0d), Mockito.eq(0.0000000001))).thenReturn(1d);
        Assertions.assertEquals(1d, trigonometry.calculateSec(0d, 0.0000000001), 0.000001);

        Mockito.when(trigonometry.calculateCos(Mockito.eq(270d), Mockito.eq(0.0000000001))).thenReturn(0d);
        Assertions.assertEquals(Double.NaN, trigonometry.calculateSec(270d, 0.0000000001), 0.000001);

        Mockito.when(trigonometry.calculateCos(Mockito.eq(27d), Mockito.eq(0.0000000001))).thenReturn(0.8910065242);
        Assertions.assertEquals(1.12232623763, trigonometry.calculateSec(27d, 0.0000000001), 0.000001);

        Mockito.when(trigonometry.calculateCos(Mockito.eq(89.999999), Mockito.eq(0.0000000001))).thenReturn(0.0000000175);
        Assertions.assertEquals(1.15470053837, trigonometry.calculateSec(-30d, 0.0000000001), 0.000001);

        Mockito.when(trigonometry.calculateCos(Mockito.eq(100000d), Mockito.eq(0.0000000001))).thenReturn(0.1736481777);
        Assertions.assertEquals(5.75877048315, trigonometry.calculateSec(100000d, 0.0000000001), 0.000001);
    }

    @Test
    public void testSecInt() {
        Trigonometry trigonometry = new Trigonometry();
        Assertions.assertEquals(trigonometry.calculateSec(Double.POSITIVE_INFINITY, 0.0000000001), Double.NaN);
        Assertions.assertEquals(trigonometry.calculateSec(Double.NaN, 0.0000000001), Double.NaN);

        Assertions.assertEquals(1d, trigonometry.calculateSec(0d, 0.0000000001), 0.000001);
        Assertions.assertEquals(Double.NaN, trigonometry.calculateSec(270d, 0.0000000001), 0.000001);
        Assertions.assertEquals(1.12232623763, trigonometry.calculateSec(27d, 0.0000000001), 0.000001);
        Assertions.assertEquals(1.15470053837, trigonometry.calculateSec(-30d, 0.0000000001), 0.000001);
        Assertions.assertEquals(5.75877048315, trigonometry.calculateSec(100000d, 0.0000000001), 0.000001);
    }

    @Test
    public void testTan() {
        Trigonometry trigonometry =  Mockito.spy(Trigonometry.class);

        Mockito.when(trigonometry.calculateSin(Mockito.eq(0d), Mockito.eq(0.0000000001))).thenReturn(0d);
        Mockito.when(trigonometry.calculateCos(Mockito.eq(0d), Mockito.eq(0.0000000001))).thenReturn(1d);
        Assertions.assertEquals(0d, trigonometry.calculateTg(0d, 0.0000000001), 0.000001);

        Mockito.when(trigonometry.calculateSin(Mockito.eq(90d), Mockito.eq(0.0000000001))).thenReturn(1d);
        Mockito.when(trigonometry.calculateCos(Mockito.eq(90d), Mockito.eq(0.0000000001))).thenReturn(0d);
        Assertions.assertEquals(Double.NaN, trigonometry.calculateTg(90d, 0.0000000001), 0.000001);

        Mockito.when(trigonometry.calculateSin(Mockito.eq(60d), Mockito.eq(0.0000000001))).thenReturn(0.8660254037);
        Mockito.when(trigonometry.calculateCos(Mockito.eq(60d), Mockito.eq(0.0000000001))).thenReturn(0.5d);
        Assertions.assertEquals(1.732050807, trigonometry.calculateTg(60d, 0.0000000001), 0.000001);
    }

    @Test
    public void testTanInt() {
        Trigonometry trigonometry = new Trigonometry();
        Assertions.assertEquals(trigonometry.calculateSec(Double.POSITIVE_INFINITY, 0.0000000001), Double.NaN);
        Assertions.assertEquals(trigonometry.calculateSec(Double.NaN, 0.0000000001), Double.NaN);

        Assertions.assertEquals(0d, trigonometry.calculateTg(0d, 0.0000000001), 0.000001);
        Assertions.assertEquals(Double.NaN, trigonometry.calculateTg(90d, 0.0000000001), 0.000001);
        Assertions.assertEquals(1.732050807, trigonometry.calculateTg(60d, 0.0000000001), 0.000001);
    }

    @Test
    public void testCot() {
        Trigonometry trigonometry =  Mockito.spy(Trigonometry.class);

        Mockito.when(trigonometry.calculateSin(Mockito.eq(0d), Mockito.eq(0.0000000001))).thenReturn(0d);
        Mockito.when(trigonometry.calculateCos(Mockito.eq(0d), Mockito.eq(0.0000000001))).thenReturn(1d);
        Assertions.assertEquals(Double.NaN, trigonometry.calculateCot(0d, 0.0000000001), 0.000001);

        Mockito.when(trigonometry.calculateSin(Mockito.eq(90d), Mockito.eq(0.0000000001))).thenReturn(1d);
        Mockito.when(trigonometry.calculateCos(Mockito.eq(90d), Mockito.eq(0.0000000001))).thenReturn(0d);
        Assertions.assertEquals(0d, trigonometry.calculateCot(90d, 0.0000000001), 0.000001);

        Mockito.when(trigonometry.calculateSin(Mockito.eq(60d), Mockito.eq(0.0000000001))).thenReturn(0.8660254037);
        Mockito.when(trigonometry.calculateCos(Mockito.eq(60d), Mockito.eq(0.0000000001))).thenReturn(0.5d);
        Assertions.assertEquals(0.577350269, trigonometry.calculateCot(60d, 0.0000000001), 0.000001);
    }

    @Test
    public void testCotInt() {
        Trigonometry trigonometry = new Trigonometry();
        Assertions.assertEquals(trigonometry.calculateSec(Double.POSITIVE_INFINITY, 0.0000000001), Double.NaN);
        Assertions.assertEquals(trigonometry.calculateSec(Double.NaN, 0.0000000001), Double.NaN);

        Assertions.assertEquals(Double.NaN, trigonometry.calculateCot(0d, 0.0000000001), 0.000001);
        Assertions.assertEquals(0d, trigonometry.calculateCot(90d, 0.0000000001), 0.000001);
        Assertions.assertEquals(0.577350269, trigonometry.calculateCot(60d, 0.0000000001), 0.000001);
    }
}
