import java.util.ArrayList;

public class LoadCarClass<C extends Car> implements ILoadCar{
    private ArrayList<C> cars;

    /** Adds a car to the Car Repair Shop
     *
     * @param item a Car
     */
    public void loadCar(C item){
        cars.add(item);
    }

    /** Removes a car from the Car Repair Shop
     *
     * @param item a car
     */
    public void removeCar(C item){
        cars.remove(item);
    }

    @Override
    public void loadCar(Car car) {

    }

    @Override
    public void removeCar(Car car) {

    }

    @Override
    public boolean isCarCloseEnough(Car item) {
        return false;
    }
}
