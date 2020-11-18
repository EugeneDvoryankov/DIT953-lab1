import java.util.LinkedList;

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
public class CarRepairShop<C extends Car> {
    private LinkedList<C> cars;

    /** Adds a car to the Car Repair Shop
     *
     * @param item a Car
     */
    public void loadCar(C item){
        cars.push(item);
    }

    /** Removes a car from the Car Repair Shop
     *
     * @param item a car
     */
    public void removeCar(C item){
        cars.pop();
    }

    /** Sees the next car in the Car Repair Shop
     *
     * @param item a car
     */
    public void peekCar(C item){
        cars.peek();
    }

    public static void main(String[] args) {
        Saab95 saab95 = new Saab95();
        Volvo240 volvo240 = new Volvo240();
        CarRepairShop<Saab95> saab95RepairShop = new CarRepairShop<>();

        saab95RepairShop.loadCar(saab95);
        //saab95RepairShop.loadCar(volvo240);

        CarRepairShop<Car> anyCarRepairShop = new CarRepairShop<>();
        anyCarRepairShop.loadCar(saab95);
        anyCarRepairShop.loadCar(volvo240);
    }
}
