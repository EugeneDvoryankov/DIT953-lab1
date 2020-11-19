import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    @Test
    void getPlatformAngle() {
        Scania scania = new Scania();
        assertEquals(0, scania.getPlatformAngle());
    }

    @Test
    void setPlatformAngle() {
        Scania scania = new Scania();
        scania.setPlatformAngle(20);
        assertEquals(20, scania.getPlatformAngle());
    }

    @Test
    void raisePlatformAngle() {
        Scania scania = new Scania();
        scania.raisePlatformAngle(80);
        assertEquals(70, scania.getPlatformAngle());
    }

    @Test
    void lowerPlatformAngle() {
        Scania scania = new Scania();
        scania.raisePlatformAngle(45);
        scania.lowerPlatformAngle(50);
        assertEquals(0, scania.getPlatformAngle());
    }

    @Test
    void canRaisePlatformAngle() {
        Scania scania = new Scania();
        assertTrue(scania.canRaisePlatformAngle());
    }

    @Test
    void canNotRaisePlatformAngle() {
        Scania scania = new Scania();
        scania.gas(1);
        assertFalse(scania.canRaisePlatformAngle());
    }

    @Test
    void isPlatformRaisedFalse() {
        Scania scania = new Scania();
        assertFalse(scania.isPlatformRaised());
    }

    @Test
    void isPlatformRaisedTrue() {
        Scania scania = new Scania();
        scania.raisePlatformAngle(45);
        assertTrue(scania.isPlatformRaised());
    }

    @Test
    void speedFactor() {
        Scania scania = new Scania();
        assertEquals(3.5, scania.speedFactor(), 0.001);
    }

    @Test
    void shouldGas() {
        Scania scania = new Scania();
        scania.gas(1);
        assertEquals(3.5, scania.getCurrentSpeed());
    }

    @Test
    void shouldNotGas() {
        Scania scania = new Scania();
        scania.raisePlatformAngle(45);
        scania.gas(1);
        assertEquals(0, scania.getCurrentSpeed());
    }


}