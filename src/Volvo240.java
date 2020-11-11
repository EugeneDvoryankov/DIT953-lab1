import java.awt.*;

/** Represents a Volvo240 car.
 * It has the following attributes:
 * a final static double representing the trimFactor
 * The class also have following methods:
 * speedFactor()
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

    /** Returns a speedFactor based on Volvo's enginePower and trimFactor.
     * @return a speedFactor
     * */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
