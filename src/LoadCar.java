import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LoadCar implements ILoadCar {
    private Ramp ramp;
    private double x;
    private double y;
    private final List<Car> cars;
    private int maxSize;

    public LoadCar(double x, double y, int maxSize){
        this.x = x;
        this.y = y;
        this.maxSize = maxSize;
        this.cars = new ArrayList<>();
    }

    /**
     * Get the X coordinate (For testing purposes)
     * @return the X coordinate of the Car Repair Shop
     */
    public double getX() {
        return x;
    }

    /**
     * Get the Y coordinate (For testing purposes)
     * @return the Y coordinate of the Car Repair Shop
     */
    public double getY() {
        return y;
    }

    /** Adds a car to the Car Repair Shop.
     * You can only add new cars to the repair shop if:
     * the maxSize isn't reached yet (you can't add car if the shop is full.)
     * the car is stationary,
     * and the car is reasonably close to car
     * @param car a Car
     */
    public void loadCar(Car car){
        if(maxSize > cars.size()) {
            if (canLoadCar(car) && isCarStationary(car)) {
                cars.add(car);
            }
        }
    }

    /**
     * Unloads a car from the carTransporter's ramp
     * Cars can only be unloaded if: the carTransporter is stationary
     * ramp is down, and the cars are reasonably close to CarTransporter.
     *
     */
    public void unloadCar() {
        if (canUnloadCar()) {
            cars.get(lastLoadedIndex()).setX(getX() + 5);
            cars.remove(lastLoadedIndex());
        }
    }

    /** Checks if car is close enough to CarTransporter for pickup.
     *
     * @param c the car that you want to load on to the CarTransporter.
     * @return boolean true if the car is close enough, otherwise false.
     */
    public boolean isCarCloseEnough(Car c) {
        return (getX() - 5 < c.getX() && c.getX() < getX() + 5)
                && (getY() - 5 < c.getY() && c.getY() < getY() + 5);
    }

    /** Determines whether a car is in motion;
     * @return true if getCurrentSpeed() is equal to 0,
     * otherwise returns false
     */
    public boolean isCarStationary(Car car) {
        return car.getCurrentSpeed() == 0;
    }

    /**
     * Gets the list of cars currently in Car repair shop.
     * @return the list of cars currently in car repair shop.
     */
    public List<Car> getCars() {
        return cars;
    }

    /** Returns the index of the last car added into the list cars.
     *
     * @return index of the car last loaded
     */
    public int lastLoadedIndex() {
        return cars.size() - 1;
    }

    /**
     * Checks if CarTransporter can load the car.
     *
     * @param car the car that wants to be loaded
     * @return a boolean that's true if car can be loaded, otherwise false
     */
    public boolean canLoadCar(Car car) {
        if(maxSize > cars.size()) {
            return canLoadOrUnloadCar() && isCarCloseEnough(car);
        }
        return false;
    }

    //CarTransporter can't load itself since it doesn't extend car(it extends vehicle).
    /**
     * Checks if CarTransporter can unload a car.
     * CarTransporter has to contain at least one car, if a car is supposed to be unloaded
     * @return boolean that is true if cartransporter can unload car, otherwise false.
     */
    public boolean canUnloadCar() {
        return !cars.isEmpty() && canLoadOrUnloadCar();

    }

    /**
     * Checks if a car can interact with CarTransporter, ie if CarTransporter is stationary, car is close enough and ramp is down
     *
     * @return boolean representing true if car can be loaded/removed, otherwise false
     */
    public boolean canLoadOrUnloadCar() {
        if (ramp.isStationary()) {
            return !ramp.isRampRaised();
        }
        return false;
    }

    /**
     * Helper method for testing.
     * Converts the list cars into a string which contains the names of the cars.
     * @return the names of the cars as a string.
     */
    public String carsToString() {
        if(cars.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for(int i = 0; i<cars.size() -1; i++) {
            sb.append(cars.get(i).getModelName());
            sb.append(", ");
        }
        sb.append(cars.get(cars.size() -1).getModelName());
        sb.append("]");
        return sb.toString();
    }

}
