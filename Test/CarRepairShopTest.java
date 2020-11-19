import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarRepairShopTest {

    @Test
    void loadCarSaab() {
        Saab95 saab95 = new Saab95();
        CarRepairShop<Saab95> saab95RepairShop = new CarRepairShop<>();
        saab95RepairShop.loadCar(saab95);
        //assertEquals(saab95, saab95RepairShop.loadCar(saab95));
    }

    @Test
    void removeCar() {
        Saab95 saab95 = new Saab95();
        CarRepairShop<Saab95> saab95RepairShop = new CarRepairShop<>();
        saab95RepairShop.loadCar(saab95);

    }


    @Test
    void arrayListTest(){
        Saab95 saab95 = new Saab95();
        Volvo240 volvo240 = new Volvo240();
        CarTransporter<Car> carCarTransporter = new CarTransporter<>(1);

    }

}