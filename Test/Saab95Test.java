import org.junit.Test;

import static org.junit.Assert.*;

public class Saab95Test {

    @Test
    public void setTurboOn() {
        Saab95 saab95 = new Saab95();
        saab95.setTurboOn();
        assertTrue(saab95.isTurboOn());
    }

    @Test
    public void setTurboOff() {
        Saab95 saab95 = new Saab95();
        saab95.setTurboOff();
        assertFalse(saab95.isTurboOn());
    }

    @Test
    public void speedFactorTurboOff() {
        Saab95 saab95 = new Saab95();
        saab95.setTurboOff();
        assertEquals(1.25, saab95.speedFactor(), 0.001);
    }

    @Test
    public void speedFactorTurboOn() {
        Saab95 saab95 = new Saab95();
        saab95.setTurboOn();
        assertEquals(1.625, saab95.speedFactor(), 0.001);
    }

}