public class CarsMain {
    public static void main(String[] args){

        Volvo240 volvo = new Volvo240();
        System.out.println(volvo);
        volvo.setCurrentSpeed(90);
        System.out.println(volvo);
        volvo.incrementSpeed(0.2); // 100
        System.out.println(volvo);

        System.out.println();

        Saab95 saab = new Saab95();
        System.out.println(saab);
        saab.setCurrentSpeed(90);
        System.out.println(saab);
        saab.setTurboOn();
        saab.incrementSpeed(1);
        System.out.println(saab);

        /*
        saab.move();
        System.out.println(saab);
        saab.move();
        System.out.println(saab);
        saab.incrementSpeed(1);
        System.out.println(saab);
        saab.incrementSpeed(1);
        System.out.println(saab);
        saab.turnRight();
        System.out.println(saab);
        saab.move();
        System.out.println(saab);
        */
    }
}
