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
        scania.raisePlatformAngle(80);
        assertEquals(70, scania.getPlatformAngle());
    }

    @Test
    void lowerPlatformAngle() {
        scania.setPlatformAngle(45);
        scania.lowerPlatformAngle(50);
        assertEquals(0, scania.getPlatformAngle());
    }

    @Test
    void canRaisePlatformAngle() {
        assertTrue(scania.canRaisePlatformAngle());
    }

    @Test
    void canNotRaisePlatformAngle() {
        scania.gas(1);
        assertFalse(scania.canRaisePlatformAngle());
    }

    @Test
    void isPlatformRaisedFalse() {
        scania.setPlatformAngle(0);
        assertFalse(scania.isPlatformRaised());
    }

    @Test
    void isPlatformRaisedTrue() {
        scania.setPlatformAngle(45);
        assertTrue(scania.isPlatformRaised());
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
        scania.raisePlatformAngle(45);
        scania.gas(1);
        assertEquals(0, scania.getCurrentSpeed());
    }


}