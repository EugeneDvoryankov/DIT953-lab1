public class CarsMain {
    public static void main(String[] args){
        Car volvo = new Volvo240(0,0);
        System.out.println(volvo);
        volvo.startEngine();
        System.out.println(volvo);
        volvo.setCurrentSpeed(120); // 100
        System.out.println(volvo);
        volvo.brake(1);
        System.out.println(volvo);
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
