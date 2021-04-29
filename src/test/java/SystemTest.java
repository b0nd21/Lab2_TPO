import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SystemTest {
    @Test
    public void testSystem() {
        SystemCalculator systemCalculator = new SystemCalculator();
        Assertions.assertEquals(-22.07999479957, systemCalculator.calculate(-122.234, 0.0000000001), 0.0000000001);
        Assertions.assertEquals(24.5486, systemCalculator.calculate(12.34, 0.0000000001), 0.0001);
    }
}
