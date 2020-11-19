import java.awt.*;

public class CarTransporter<T extends Car> extends Vehicle{
    private boolean rampUp;
    private int maxSize; // the max number of cars that the CarTransporter can hold.
    private final FixedSizeStack<T> cars = new FixedSizeStack<>(getMaxSize()); // a stack with the cars that are loaded on the carTransport

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
    public void setRampUp(){
        rampUp = true;
    }

    /** Sets the carTransporter's ramp down
     */
    public void setRampDown(){
        rampUp = false;
    }

    /** Checks if the carTransporter's ramp is up
     *
     * @return a boolean representing if ramp is up or down
     */
    public boolean isRampUp() {
        return rampUp;
    }

    public boolean isCarCloseEnough(Car c) {
        return  (getX()-5 < c.getX() & c.getX()<getX() + 5) & (getY()-5 < c.getY() & c.getY() <getY());
    }

    /** Adds a car to the carTransporter's ramp
     *
     * Cars can only be loaded if: the carTransporter is stationary
     * ramp is down, and the cars are reasonably close to car
     * @param item a Car
     */

    public void loadCar(T item){
        if(canLoadCar(item)) {
            cars.push(item);
        }
    }

    /** Removes a car from the carTransporter's ramp
     *
     * Cars can only be removed if: the carTransporter is stationary
     * ramp is down, and the cars are reasonably close to car
     * @param item a car
     */
    public void removeCar(T item){
        if(canRemoveCar(item)) {
            cars.pop(item);
        }
    }

    /** Checks if a car can be loaded to carTransporter
     *
     * Cars can only be loaded if: the carTransporter is stationary
     * ramp is down, and the cars are reasonably close to car
     * @param item a Car
     * @return boolean representing true if car can be loaded, otherwise false
     */
    public boolean canLoadCar(T item){
        if(getCurrentSpeed() == 0) {
            if (!rampUp) {
                return isCarCloseEnough(item);
            }
        }
        return false;
    }

    /** Checks if a car can be removed to carTransporter
     * Cars can only be removed if: the carTransporter is stationary
     * ramp is down, and the cars are reasonably close to car
     * @param item a Car
     * @return boolean representing true if car can be removed, otherwise false
     */
    public boolean canRemoveCar(T item){
        if(getCurrentSpeed() == 0) {
            if (!rampUp) {
                return isCarCloseEnough(item);
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
        if(isRampUp()) {
            if (amount >= 0 & amount <= 1) {
                incrementSpeed(amount);
            }
        }
    }

}
