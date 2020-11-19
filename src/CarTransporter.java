import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class CarTransporter extends Vehicle {
    private boolean rampUp;
    //private int maxSize; // the max number of cars that the CarTransporter can hold.
    private final List<Car> cars;

    public CarTransporter(int nrDoors, double enginePower, double currentSpeed,
                          Color color, String modelName, int maxSize) {
        super(0, 0, nrDoors, enginePower, currentSpeed, color, modelName, 0);
        rampUp = true;
        cars = new ArrayList<>(maxSize);
        stopEngine();
    }

 /*  /** Gets the max number of cars that the CarTransporter can hold
     *
     * @return the max number of cars that the CarTransporter can hold
     *
    public int getMaxSize(){
        return maxSize;
    }

    /**Sets the max number of cars that the CarTransporter can hold
     *
     * @param maxSize the number of cars wanted
     *
    public void setMaxSize(int maxSize){
        this.maxSize = maxSize;
    }
    */

    /**
     * Sets the carTransporter's ramp up
     */
    public void setRampUp() {
        rampUp = true;
    }

    /**
     * Sets the carTransporter's ramp down
     */
    public void setRampDown() {
        rampUp = false;
    }

    /**
     * Checks if the carTransporter's ramp is up
     *
     * @return a boolean representing if ramp is up or down
     */
    public boolean isRampUp() {
        return rampUp;
    }

    public boolean isCarCloseEnough(Car c) {
        return (getX() - 5 < c.getX() && c.getX() < getX() + 5) && (getY() - 5 < c.getY() && c.getY() < getY() + 5);
    }

    /**
     * Adds a car to the carTransporter's ramp
     * <p>
     * Cars can only be loaded if: the carTransporter is stationary
     * ramp is down, and the cars are reasonably close to car
     *
     * @param car a Car
     */

    public void loadCar(Car car) {
        if (canLoadCar(car)) {
            cars.add(car);
        }
    }

    /**
     * Removes a car from the carTransporter's ramp
     * <p>
     * Cars can only be removed if: the carTransporter is stationary
     * ramp is down, and the cars are reasonably close to car
     *
     * @param car a car
     */
    public void removeCar(Car car) {
        if (canRemoveCar(car)) {
            cars.get(lastLoadedIndex()).setX(getX() + 5);
            cars.get(lastLoadedIndex()).setX(getY());
            cars.remove(lastLoadedIndex());
        }
    }

    int lastLoadedIndex() {
        return cars.size() - 1;
    }


    public boolean canLoadCar(Car car) {
        return canInteractWithCar(car);

    }

    public boolean canRemoveCar(Car car) {
        return canInteractWithCar(car) && !cars.isEmpty();

    }

    /**
     * Checks if a car can be loaded to/removed from carTransporter
     * Cars can only be loaded/removed if: the carTransporter is stationary
     * ramp is down, and the cars are reasonably close to car
     *
     * @param car a Car
     * @return boolean representing true if car can be loaded/removed, otherwise false
     */
    public boolean canInteractWithCar(Car car) {
        if (getCurrentSpeed() == 0) {
            if (!rampUp) {
                return isCarCloseEnough(car);
            }
        }
        return false;
    }

    /**
     * Returns a speedFactor based on carTranpsporter's enginePower.
     *
     * @return the speedFactor
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }


    /**
     * Gas the carTransporter.
     * <p>
     * If the ramp is down then the carTransporter will not gas.
     * Takes a number between 1 and 0.
     *
     * @param amount how hard you press the gas
     */
    @Override
    public void gas(double amount) {
        if (isRampUp()) {
            if (amount >= 0 & amount <= 1) {
                incrementSpeed(amount);
            }
        }
    }

    @Override
    public void move() {
        super.move();
        for(Car car: cars) {
            car.setX(getX());
            car.setY(getY());
        }
    }
}
