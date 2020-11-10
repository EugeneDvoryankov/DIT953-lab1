import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Saab95Test {

    @Test
    void setTurboOn() {
        Saab95 saab95 = new Saab95();
        saab95.setTurboOn();
        assertTrue(saab95.isTurboOn());
    }

    @Test
    void setTurboOff() {
        Saab95 saab95 = new Saab95();
        saab95.setTurboOff();
        assertFalse(saab95.isTurboOn());
    }

    @Test
    void speedFactorTurboOff() {
        Saab95 saab95 = new Saab95();
        saab95.setTurboOff();
        assertEquals(1.25, saab95.speedFactor(), 0.001);
    }

    @Test
    void speedFactorTurboOn() {
        Saab95 saab95 = new Saab95();
        saab95.setTurboOn();
        assertEquals(1.625, saab95.speedFactor(), 0.001);
    }

}