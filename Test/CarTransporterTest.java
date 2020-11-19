import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CarTransporterTest {
    CarTransporter cartransporter = new CarTransporter(2, 350, 0, Color.red, "Cartransporter",
            3);
    Volvo240 volvo240 = new Volvo240(4, 100, 0, Color.black, "Volvo240");

    @Test
    public void isCarCloseEnoughCorrect() {
        assertTrue(cartransporter.isCarCloseEnough(volvo240));
    }

    @Test
    public void isCarCloseEnoughWrong() {
        volvo240.setX(6);
        volvo240.setY(0);
        cartransporter.setX(0);
        cartransporter.setY(0);
        assertFalse(cartransporter.isCarCloseEnough(volvo240));
    }

  /*  @Test
    public void getMaxSizeCorrect() {
        assertEquals(3, cartransporter.getMaxSize());
    }

    @Test
    public void setMaxSizeCorrect() {
        cartransporter.setMaxSize(5);
        assertEquals(5, cartransporter.getMaxSize());
    }

    @Test
    public void setRampUp() {
        cartransporter.setRampUp();
        assertTrue(cartransporter.isRampUp());
    }
*/
    @Test
    public void setRampDown() {
        cartransporter.setRampDown();
        assertFalse(cartransporter.isRampUp());
    }

    @Test
    public void canInteractWithCarIfSpeedNotZero() {
        CarTransporter cartransporter = new CarTransporter(3, 350, 2, Color.red, "Cartransporter",
                3);
        assertFalse(cartransporter.canInteractWithCar(volvo240));

    }

    @Test
    public void canInteractWithCarIfCarNotCloseEnough() {
        volvo240.setX(6);
        volvo240.setY(0);
        cartransporter.setX(0);
        cartransporter.setY(0);
        assertFalse(cartransporter.canInteractWithCar(volvo240));
    }


    @Test
    public void loadCarIfStackFull() {
        CarTransporter cartransporter = new CarTransporter(3, 350, 0, Color.red, "Cartransporter",
                2);
        Volvo240 volvo1 = new Volvo240(4, 100, 0, Color.black, "Volvo240");
        Volvo240 volvo2 = new Volvo240(4, 100, 0, Color.black, "Volvo240");
        Volvo240 volvo3 = new Volvo240(4, 100, 0, Color.black, "Volvo240");

    }
}

