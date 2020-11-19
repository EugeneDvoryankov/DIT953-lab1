import java.util.ArrayList;

public interface ILoadCar<C extends Car> {

    /** Adds a car to the Car Repair Shop
     *
     * @param car a Car
     */
    public void loadCar(C car);

    /** Removes a car from the Car Repair Shop
     *
     * @param car a car
     */
    public void removeCar(C car);

    /** Checks whether car's x and y coordinates are within 5 units from CarTransporter's
     *
     * @param item a Car
     * @return true if car's x and y coordinates are within 5 units from CarTransporter's,
     * otherwise false
     */
    public boolean isCarCloseEnough(C item);
}
