import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {
    Scania scania = new Scania(2,350,0, Color.green,"Scania" );
    @Test
    void getPlatformAngle() {
        assertEquals(0, scania.getPlatformAngle());
    }

    @Test
    void setPlatformAngle() {
        scania.setPlatformAngle(20);
        assertEquals(20, scania.getPlatformAngle());
    }

    @Test
    void raisePlatformAngle() {
        scania.raiseRamp(80);
        assertEquals(70, scania.getPlatformAngle());
    }

    @Test
    void lowerPlatformAngle() {
        scania.setPlatformAngle(45);
        scania.lowerRamp(50);
        assertEquals(0, scania.getPlatformAngle());
    }

    @Test
    void canRaisePlatformAngle() {
        assertTrue(scania.isStationary());
    }

    @Test
    void canNotRaisePlatformAngle() {
        scania.gas(1);
        assertFalse(scania.isStationary());
    }

    @Test
    void isPlatformRaisedFalse() {
        scania.setPlatformAngle(0);
        assertFalse(scania.isRampRaised());
    }

    @Test
    void isPlatformRaisedTrue() {
        scania.setPlatformAngle(45);
        assertTrue(scania.isRampRaised());
    }

    @Test
    void speedFactor() {
        assertEquals(3.5, scania.speedFactor(), 0.001);
    }

    @Test
    void shouldGas() {
        Scania scania = new Scania(2,350,0, Color.green,"Scania" );
        scania.gas(1);
        assertEquals(3.5, scania.getCurrentSpeed());
    }

    @Test
    void shouldNotGas() {
        Scania scania = new Scania(2,350,0, Color.green,"Scania" );
        scania.raiseRamp(45);
        scania.gas(1);
        assertEquals(0, scania.getCurrentSpeed());
    }


}