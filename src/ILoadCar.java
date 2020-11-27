import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.List;

/** Represents a Car Repair Shop.
 *
 * A Car Repair Shop loads a number of cars, up to a maximum number that can vary between different workshops.
 * Some workshops should only be able to accommodate a certain type of car;
 * others can receive any car.
 * Trying to receive the "wrong" sort of car in a workshop should give a static (compile time) error.
 * When retrieving a car from the workshop, we must be able to get as specific static type information as possible.
 * Example: A car retrieved from a branded workshop that only handles the Volvo 240 should have static type Volvo240.
 * @param <C> a class that extends the Car, either the Volvo240 or Saab95 class
 */
public interface ILoadCar<C extends Car> {

    /** Adds a car to the Car Repair Shop.
     * You can only add new cars to the repair shop if the maxSize isn't reached yet,
     * ie you can't add car if the shop is full.
     *
     * @param item a Car
     */
    public void loadCar(C item);

    /** Removes a car from the Car Repair Shop
     */
    public void unloadCar();

    /** Checks if car is close enough to CarTransporter for pickup.
     *
     * @param c the car that you want to load on to the CarTransporter.
     * @return boolean true if the car is close enough, otherwise false.
     */
    public boolean isCarCloseEnough(Car c);

    /** Determines whether a car is in motion;
     * @return true if getCurrentSpeed() is equal to 0,
     * otherwise returns false
     */
    public boolean isCarStationary(Car car);

    /**
     * Gets the list of cars currently in Car repair shop.
     * @return the list of cars currently in car repair shop.
     */
    public List<C> getCars();

    /** Returns the index of the last car added into the list cars.
     *
     * @return index of the car last loaded
     */
    public int lastLoadedIndex();

    /**
     * Checks if CarTransporter can load the car.
     *
     * @param car the car that wants to be loaded
     * @return a boolean that's true if car can be loaded, otherwise false
     */
    public boolean canLoadCar(Car car);

    //CarTransporter can't load itself since it doesn't extend car(it extends vehicle).
    /**
     * Checks if CarTransporter can unload a car.
     * CarTransporter has to contain at least one car, if a car is supposed to be unloaded
     * @return boolean that is true if cartransporter can unload car, otherwise false.
     */
    public boolean canUnloadCar();

    /**
     * Checks if a car can interact with CarTransporter, ie if CarTransporter is stationary, car is close enough and ramp is down
     *
     * @return boolean representing true if car can be loaded/removed, otherwise false
     */
    public boolean canLoadOrUnloadCar();

    /**
     * Helper method for testing.
     * Converts the list cars into a string which contains the names of the cars.
     * @return the names of the cars as a string.
     */
    public String carsToString();

}
