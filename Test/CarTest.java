import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {



    @Test
    void getNrDoors() {
        Volvo240 volvo240 = new Volvo240();
        assertEquals(4, volvo240.getNrDoors());
    }

    @Test
    void setNrDoors() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.setNrDoors(2);
        assertEquals(2, volvo240.getNrDoors());
    }

    @Test
    void getEnginePower() {
        Volvo240 volvo240 = new Volvo240();
        assertEquals(100, volvo240.getEnginePower());
    }

    @Test
    void setEnginePower() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.setEnginePower(200);
        assertEquals(200, volvo240.getEnginePower(), 0.001);
    }

    @Test
    void getCurrentSpeed() {
        Volvo240 volvo240 = new Volvo240();
        assertEquals(0, volvo240.getCurrentSpeed());
    }

    @Test
    void setCurrentSpeedCorrect() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.setCurrentSpeed(100);
        assertEquals(100, volvo240.getCurrentSpeed());
    }

    @Test
    void setCurrentSpeedWrong() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.setCurrentSpeed(150);
        assertEquals(100, volvo240.getCurrentSpeed());
    }

    @Test
    void getColor() {
        Volvo240 volvo240 = new Volvo240();
        assertEquals(Color.black, volvo240.getColor());
    }

    @Test
    void setColor() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.setColor(Color.blue);
        assertEquals(Color.blue, volvo240.getColor());
    }

    @Test
    void getModelName() {
        Volvo240 volvo240 = new Volvo240();
        assertEquals("Volvo240", volvo240.getModelName());
    }

    @Test
    void setModelName() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.setModelName("Volvo740");
        assertEquals("Volvo740", volvo240.getModelName());
    }

    @Test
    void startEngine() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        assertEquals(0.1, volvo240.getCurrentSpeed(), 0.001);
    }

    @Test
    void stopEngine() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.stopEngine();
        assertEquals(0,volvo240.getCurrentSpeed(), 0.001);
    }

    @Test
    void move() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.move();
        assertEquals(0.1, volvo240.getY(), 0.001);
    }

    @Test
    void turnLeft() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.turnLeft();
        assertEquals(-0.1, volvo240.getX(), 0.001);
    }

    @Test
    void turnRight() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.turnRight();
        assertEquals(0.1, volvo240.getX(), 0.001);
    }

    @Test
    void testToString() {
        Volvo240 volvo240 = new Volvo240();
        assertEquals("( x: " + volvo240.getX() + ", y: "  + volvo240.getY() + ", currentSpeed: " + volvo240.getCurrentSpeed() + ", " + ")", volvo240.toString());
    }

    @Test
    void incrementSpeed() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.setCurrentSpeed(90);
        volvo240.incrementSpeed(1);
        assertEquals(91.25, volvo240.getCurrentSpeed(), 0.001);
    }

    @Test
    void decrementSpeed() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.setCurrentSpeed(90);
        volvo240.decrementSpeed(1);
        assertEquals(88.75, volvo240.getCurrentSpeed(), 0.001);

    }

    @Test
    void gasCorrect() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.setCurrentSpeed(90);
        volvo240.gas(1);
        assertEquals(91.25, volvo240.getCurrentSpeed(), 0.001);
    }
    @Test
    void gasWrong() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.setCurrentSpeed(90);
        volvo240.gas(-1);
        assertEquals(90, volvo240.getCurrentSpeed(), 0.001);
    }

    @Test
    void brakeCorrect() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.setCurrentSpeed(90);
        volvo240.brake(1);
        assertEquals(88.75, volvo240.getCurrentSpeed(), 0.001);
    }

    @Test
    void brakeWrong(){
        Volvo240 volvo240 = new Volvo240();
        volvo240.setCurrentSpeed(90);
        volvo240.brake(-1);
        assertEquals(90, volvo240.getCurrentSpeed(), 0.001);
    }
}