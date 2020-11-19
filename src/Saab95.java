import java.awt.*;

/**
 * Represents a Saab95 car.
 * It has the following attributes:
 * A boolean representing that Saab95's turbo is On or Off.
 * The class also have following methods:
 * setTurboOn(), setTurboOff(), isTurboOn() and speedFactor()
 */
public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(int nrDoors, double enginePower, double currentSpeed,
                  Color color, String modelName){
        super(0,0, nrDoors, enginePower, currentSpeed, color, modelName,0);
        turboOn = false;
        stopEngine();
    }

    /**
     * Sets turboOn true.
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     *  Sets turboOn false.
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * @return a boolean representing turboOn is true or false.
     */
    public boolean isTurboOn() {
        return turboOn;
    }

    /**
     * @return a double representing speedFactor
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
