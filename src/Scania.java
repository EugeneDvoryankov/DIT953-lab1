
import java.awt.*;

/**
 * Represents a Scania truck
 *
 * The class has the following attributes:
 * The Scania's platformAngle
 * Has a getter and a setter for platformAngle
 * Also contains raisePlatform(), lowerPlatform() and isPlatformRaised,
 * for the purpose of increasing and decreasing platform angle
 * and to check if platform is raised (angle is greater than zero)
 */
public class Scania extends Truck implements IRamp {

    private int platformAngle; // the angle the platform is at, the platform is considered a ramp
    private final Ramp ramp = new Ramp();

    public Scania(int nrDoors, double enginePower, double currentSpeed,
                  Color color, String modelName){
        super(0,0, nrDoors, enginePower, currentSpeed, color, modelName,0);
        platformAngle = 0; // set platformAngle to 0 ????
        stopEngine();
    }

    /**
     * Changes the state of the ramp to raised.
     */
    private void raiseRamp() {
        ramp.raiseRamp();
    }

    /**
     * Changes the state of the ramp to lowered.
     */
    private void lowerRamp() {
        ramp.lowerRamp();
    }

    /**
     * Checks if ramp can be raised.
     * @return boolean true if ramp can be raised, otherwise boolean false.
     */
    public boolean isRampRaised() {
        return ramp.isRampRaised();
    }


    /** Gets platformAngle of the Scania
     *
     * @return the platformAngle of the Scania
     */
    public int getPlatformAngle() {
        return platformAngle;
    }

    /** Sets the platformAngle
     *
     * @param platformAngle the angle the platform is at
     */
    public void setPlatformAngle(int platformAngle) {
        this.platformAngle = platformAngle;
    }

    /** Increases the angle of the ramp with 10°
     *
     *  The angle of the platform can not be lower than 0° or higher than 70°
     *  The platform must not be raised if the truck is in motion
     */
    public void raiseRamp(){
        int amount = 10;
        int newAngle = Math.min(getPlatformAngle() + amount, 70);
        if(isStationary()) {
            setPlatformAngle(newAngle);
        }
        raiseOrLowerRamp();
    }

    /** Decreases the angle of the platform with 10°
     *  The angle of the platform can not be lower than 0° or higher than 70°
     */
    public void lowerRamp(){
        int amount = 10;
        int newAngle = Math.max(getPlatformAngle() - amount, 0);
        setPlatformAngle(newAngle);
        raiseOrLowerRamp();
    }

    /**
     * Either raises or lowers ramp, depending on the platform angle.
     * This mains that the ramp is considered raised if the angle is above 0, and lowered if it's currently 0.
     */
    public void raiseOrLowerRamp() {
        if(getPlatformAngle() > 0) {
            raiseRamp();
        } else {
            lowerRamp();
        }
    }

    /** Checks if the platform is raised.
     *
     * The angle of the platform can not be lower than 0° or higher than 70°
     * @return true if platformAngle is greater than zero,
     * otherwise returns false
     */
    public boolean isRampRaised(){
        return getPlatformAngle() > 0;
    }

    /** Determines whether the truck is in motion;
     * @return true if getCurrentSpeed() is equal to 0,
     * otherwise returns false
     */
    public boolean isStationary() {
        return getCurrentSpeed() == 0;
    }

    /** Returns a speedFactor based on Scania's enginePower.
     * @return the speedFactor
     * */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Gas the truck.
     *
     * If the platform is raised then the truck will not gas.
     * Takes a number between 1 and 0.
     * @param amount how hard you press the gas
     */
    @Override
    public void gas(double amount) {
        if(!isRampRaised()) {
            super.gas(amount);
        }
    }

    /**
     * Starts the engine of the truck.
     * If the platform is raised, then the engine will not start.
     */
    @Override
    public void startEngine() {
        if(!isRampRaised()) {
            super.startEngine();
        }
    }

}

