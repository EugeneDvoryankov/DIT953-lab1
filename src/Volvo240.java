import java.awt.*;

/** Represents a Volvo car.
 *
 * @author Daniel Ericsson
 * @author Eugene Dvoryankokv
 * @author Victor Hui
 */
public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    /** Class constructor for Volvo240 specifying nrDoors, color, enginePower, modelName as well as turning engine off.
     */
    public Volvo240(){
        setNrDoors(4);
        setColor(Color.black);
        setEnginePower(100);
        setModelName("Volvo240");
        stopEngine();
    }

    /** Returns a speedFactor based on Volvo's enginePower and trimFactor.
     * @return a speedFactor
     * */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
