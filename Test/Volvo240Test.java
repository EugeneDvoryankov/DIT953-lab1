import org.junit.Test;

import static org.junit.Assert.*;

public class Volvo240Test {

    @Test
    public void speedFactor(){
        Volvo240 volvo240 = new Volvo240();
        assertEquals(1.25, volvo240.speedFactor(), 0.001);
    }

}