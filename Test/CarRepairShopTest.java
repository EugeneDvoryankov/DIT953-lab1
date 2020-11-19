import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarRepairShopTest {

    @Test
    void loadCarSaab() {
        Saab95 saab95 = new Saab95(4,125,0, Color.black, "Saab95");
        CarRepairShop<Saab95> saab95RepairShop = new CarRepairShop<>();
        saab95RepairShop.loadCar(saab95);
        //assertEquals(saab95, saab95RepairShop.loadCar(saab95));
    }

    @Test
    void removeCar() {
        Saab95 saab95 = new Saab95(4,125,0, Color.black, "Saab95");
        CarRepairShop<Saab95> saab95RepairShop = new CarRepairShop<>();
        saab95RepairShop.loadCar(saab95);

    }


}