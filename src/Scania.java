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
public class Scania extends Truck implements IRamp{

    private int platformAngle; // the angle the platform is at

    public Scania(){
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(350); // 350 horse power
        platformAngle = 0; // set platformAngle to 0 ????
        setModelName("Scania");
        stopEngine();
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

    /** Determines whether the truck is in motion;
     * @return true if getCurrentSpeed() is equal to 0,
     * otherwise returns false
     */
    public boolean isStationary() {
        if(getCurrentSpeed() == 0){
            return true;
        }
        return false;
    }

    /** Returns a speedFactor based on Scania's enginePower.
     * @return the speedFactor
     * */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Gas the Scania truck.
     *
     * If the platform is raised then the truck will not gas.
     * Takes a number between 1 and 0.
     * @param amount how hard you press the gas
     */
    @Override
    public void gas(double amount) {
        if(!isRampRaised()) {
            if (amount >= 0 & amount <= 1) {
                incrementSpeed(amount);
            }
        }
    }

    /** Increases the angle of the platform with 10°
     *
     *  The angle of the platform can not be lower than 0° or higher than 70°
     */
    public void raiseRamp() {
        int newAngle = Math.min(getPlatformAngle() + 10, 70);
        if(isStationary()) {
            setPlatformAngle(newAngle);
        }
    }

    /** Decreases the angle of the platform with 10°
     *
     *  The angle of the platform can not be lower than 0° or higher than 70°
     */
    public void lowerRamp() {
        int newAngle = Math.max(getPlatformAngle() - 10, 0);
        if( isStationary()) {
            setPlatformAngle(newAngle);
        }

    }

    /** Checks if the platform is raised.
     *
     * The angle of the platform can not be lower than 0° or higher than 70°
     * @return true if platformAngle is greater than zero,
     * otherwise returns false
     */
    public boolean isRampRaised() {
        if (getPlatformAngle() > 0) {
            return true;
        }
        return false;
    }

}
