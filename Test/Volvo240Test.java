import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Volvo240Test {

    @Test
    void speedFactor(){
        Volvo240 volvo240 = new Volvo240();
        assertEquals(1.25, volvo240.speedFactor(), 0.001);
    }

}