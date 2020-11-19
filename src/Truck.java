import java.awt.*;

/** Represents a base model of a truck that the Scania truck is based on.
 */
public abstract class Truck extends Vehicle {
    public Truck(double x, double y, int nrDoors, double enginePower, double currentSpeed,
                 Color color, String modelName, int directionAngle) {
        super(x, y, nrDoors, enginePower, currentSpeed, color, modelName, directionAngle);
    }
    
    **
     * Gas the truck.
     *
     * If the platform is raised then the truck will not gas.
     * Takes a number between 1 and 0.
     * @param amount how hard you press the gas
     */
    @Override
    public void gas(double amount) {
        if(!isPlatformRaised()) {
            super.gas(amount);
        }
    }
}
