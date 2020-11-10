import java.awt.*;

/** Represents a Volvo car.
 *
 * @author Daniel Ericsson
 * @author Eugene Dvoryankokv
 * @author Victor Hui
 */
public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;
    
    public Volvo240(){
        setNrDoors(4);
        setColor(Color.black);
        setEnginePower(100);
        setModelName("Volvo240");
        stopEngine();
    }

    /** Returns a speedFactor based on Volvo's enginePower and trimFactor. */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
