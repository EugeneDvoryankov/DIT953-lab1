import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarTransporter<C extends Car> extends Vehicle implements IRamp{
    private boolean rampUp;
    private int maxSize; // the max number of cars that the CarTransporter can hold.
    private final ArrayList<C> cars = new ArrayList<C>(getMaxSize());



    public CarTransporter(int nrDoors, double enginePower, double currentSpeed,
                          Color color, String modelName, int maxSize) {

        super(0,0, nrDoors, enginePower, currentSpeed, color, modelName,0);
        rampUp = true;
        this.maxSize = maxSize;
        stopEngine();
    }

    /** Gets the max number of cars that the CarTransporter can hold
     *
     * @return the max number of cars that the CarTransporter can hold
     */
    public int getMaxSize(){
        return maxSize;
    }

    /**Sets the max number of cars that the CarTransporter can hold
     *
     * @param maxSize the number of cars wanted
     */
    public void setMaxSize(int maxSize){
        this.maxSize = maxSize;
    }

    /** Sets the carTransporter's ramp up
     */
    public void raiseRamp(){
        rampUp = true;
    }

    /** Sets the carTransporter's ramp down
     */
    public void lowerRamp(){
        rampUp = false;
    }

    /** Checks if the carTransporter's ramp is up
     *
     * @return a boolean representing if ramp is up or down
     */
    public boolean isRampRaised(){
        return rampUp;
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

    /** Checks whether car's x and y coordinates are within 5 units from CarTransporter's
     *
     * @param c a Car
     * @return true if car's x and y coordinates are within 5 units from CarTransporter's,
     * otherwise false
     */
    public boolean isCarCloseEnough(Car c) {
        return  (getX()-5 < c.getX() & c.getX()<getX() + 5) & (getY()-5 < c.getY() & c.getY() <getY());
    }

    /** Adds a car to the carTransporter's ramp
     *
     * Cars can only be loaded if: the carTransporter is stationary
     * ramp is down, and the cars are reasonably close to car
     * @param item a Car
     */
    public void loadCar(C item){
        if(canLoadOrRemoveCar(item)) {
            cars.add(item);
        }
    }

    /** Removes a car from the carTransporter's ramp
     *
     * Cars can only be removed if: the carTransporter is stationary
     * ramp is down, and the cars are reasonably close to car
     */
    public void removeCar(C item){
        if(canLoadOrRemoveCar(item)) {
            cars.remove(item);
        }
    }

    /** Checks if a car can be loaded or removed from carTransporter
     *
     * Cars can only be loaded or re,oved if: the carTransporter is stationary
     * ramp is down, and the cars are reasonably close to car
     * @param item a Car
     * @return boolean representing true if car can be loaded, otherwise false
     */
    public boolean canLoadOrRemoveCar(C item){
        if(isStationary()) {
            if (!rampUp) {
                if (isCarCloseEnough(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    /** Returns a speedFactor based on carTranpsporter's enginePower.
     * @return the speedFactor
     * */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }

    /**
     * Gas the carTransporter.
     *
     * If the ramp is down then the carTransporter will not gas.
     * Takes a number between 1 and 0.
     * @param amount how hard you press the gas
     */
    @Override
    public void gas(double amount) {
        if(isRampRaised()) {
            if (amount >= 0 & amount <= 1) {
                incrementSpeed(amount);
            }
        }
    }

}
