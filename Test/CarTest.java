import org.junit.Test;
import org.junit.Before;
import java.awt.*;

import static org.junit.Assert.*;

public class CarTest {

    /** Volvo240 should have 4 doors */
    @Test
    public void getNrDoors() {
        Volvo240 volvo240 = new Volvo240();
        assertEquals(4, volvo240.getNrDoors());
    }

    @Test
    public void setNrDoors() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.setNrDoors(2);
        assertEquals(2, volvo240.getNrDoors());
    }

    @Test
    public void getEnginePower() {
        Volvo240 volvo240 = new Volvo240();
        assertEquals(100, volvo240.getEnginePower(), 0.001);
    }

    @Test
    public void setEnginePower() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.setEnginePower(200);
        assertEquals(200, volvo240.getEnginePower(), 0.001);
    }

    @Test
    public void getCurrentSpeed() {
        Volvo240 volvo240 = new Volvo240();
        assertEquals(0, volvo240.getCurrentSpeed(), 0.001);
    }


    @Test
    public void getColor() {
        Volvo240 volvo240 = new Volvo240();
        assertEquals(Color.black, volvo240.getColor());
    }

    @Test
    public void setColor() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.setColor(Color.blue);
        assertEquals(Color.blue, volvo240.getColor());
    }

    @Test
    public void getModelName() {
        Volvo240 volvo240 = new Volvo240();
        assertEquals("Volvo240", volvo240.getModelName());
    }

    @Test
    public void setModelName() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.setModelName("Volvo740");
        assertEquals("Volvo740", volvo240.getModelName());
    }

    @Test
    public void startEngine() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        assertEquals(0.1, volvo240.getCurrentSpeed(), 0.001);
    }

    @Test
    public void stopEngine() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.stopEngine();
        assertEquals(0,volvo240.getCurrentSpeed(), 0.001);
    }

    @Test
    public void move() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.move();
        assertEquals(0.1, volvo240.getY(), 0.001);
    }

    @Test
    public void turnLeft() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.turnLeft();
        assertEquals(-0.1, volvo240.getX(), 0.001);
    }

    @Test
    public void turnRight() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.turnRight();
        assertEquals(0.1, volvo240.getX(), 0.001);
    }

    @Test
    public void testToString() {
        Volvo240 volvo240 = new Volvo240();
        assertEquals("( x: " + volvo240.getX() + ", y: "  + volvo240.getY() + ", currentSpeed: " + volvo240.getCurrentSpeed() + ", " + ")", volvo240.toString());
    }


    @Test
    public void gasCorrect() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.gas(1);
        assertEquals(1.25, volvo240.getCurrentSpeed(), 0.001);
    }
    @Test
    public void gasWrong() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.gas(-1);
        assertEquals(0, volvo240.getCurrentSpeed(), 0.001);
    }

    @Test
    public void brakeCorrect() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.gas(1);
        volvo240.brake(1);
        assertEquals(0, volvo240.getCurrentSpeed(), 0.001);
    }

    @Test
    public void brakeWrong(){
        Volvo240 volvo240 = new Volvo240();
        volvo240.gas(1);
        volvo240.brake(-1);
        assertEquals(1.25, volvo240.getCurrentSpeed(), 0.001);
    }
}