import java.awt.*;

/**
 * Represents a Saab95 car
 */
public class Saab95 extends Car {

    private boolean turboOn;

    /**
     * Creates a Saab.
     * with specified nrDoors, color, enginePower, set turboOn to false
     * specifies modelName and makes a call to stopEngine method.
     */
    public Saab95(){
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(125);
        turboOn = false;
        setModelName("Saab95");
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
