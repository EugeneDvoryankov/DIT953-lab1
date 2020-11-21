import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarRepairShop<C extends Car> {
    private LoadCar carLoader; // A reference to the LoadCar class
    private double x; // The CarRepairShop's x direction
    private double y; // The CarRepairShop's y direction
    private final List<C> cars;
    private int maxSize;

    public CarRepairShop(double x, double y, int maxSize){
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
     * You can only add new cars to the repair shop if the maxSize isn't reached yet,
     * ie you can't add car if the shop is full.
     *
     * @param item a Car
     */
    public void loadCar(C item){
        carLoader.loadCar(item);
    }

    /** Removes a car from the Car Repair Shop
     *
     * @param item a car
     */
    public void unloadCar(C item){
        carLoader.loadCar(item);
    }

    /** Checks if car is close enough to CarTransporter for pickup.
     *
     * @param c the car that you want to load on to the CarTransporter.
     * @return boolean true if the car is close enough, otherwise false.
     */
    public boolean isCarCloseEnough(Car c) {
        return carLoader.isCarCloseEnough(c);
    }

    /** Determines whether a car is in motion;
     * @return true if getCurrentSpeed() is equal to 0,
     * otherwise returns false
     */
    public boolean isCarStationary(Car car) {
        return carLoader.isCarStationary(car);
    }

    /**
     * Gets the list of cars currently in Car repair shop.
     * @return the list of cars currently in car repair shop.
     */
    public List<Car> getCars() {
        return carLoader.getCars();
    }

    /** Returns the index of the last car added into the list cars.
     *
     * @return index of the car last loaded
     */
    public int lastLoadedIndex() {
        return carLoader.lastLoadedIndex();
    }

    /**
     * Checks if CarTransporter can load the car.
     *
     * @param car the car that wants to be loaded
     * @return a boolean that's true if car can be loaded, otherwise false
     */
    public boolean canLoadCar(Car car) {
        return carLoader.canLoadCar(car);
    }

    //CarTransporter can't load itself since it doesn't extend car(it extends vehicle).
    /**
     * Checks if CarTransporter can unload a car.
     * CarTransporter has to contain at least one car, if a car is supposed to be unloaded
     * @return boolean that is true if cartransporter can unload car, otherwise false.
     */
    public boolean canUnloadCar() {
        return carLoader.canUnloadCar();
    }

    /**
     * Helper method for testing.
     * Converts the list cars into a string which contains the names of the cars.
     * @return the names of the cars as a string.
     */
    public String carsToString() {
        return carLoader.carsToString();
    }

    public static void main(String[] args) {
        Saab95 saab95 = new Saab95(4, 100,0, Color.black, "Saab95");
        Volvo240 volvo240 = new Volvo240(4, 100,0, Color.black, "Volvo240");
        CarRepairShop<Saab95> saab95RepairShop = new CarRepairShop<>(0,0,2);

        saab95RepairShop.loadCar(saab95);
        //saab95RepairShop.loadCar(volvo240);

        CarRepairShop<Car> anyCarRepairShop = new CarRepairShop<>(0,0,2);
        anyCarRepairShop.loadCar(saab95);
        anyCarRepairShop.loadCar(volvo240);
    }
}
