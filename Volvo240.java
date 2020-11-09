import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;
    
    public Volvo240(double x, double y){
        super(x,y); // Call to Car's constructorr
        setNrDoors(4);
        setColor(Color.black);
        setEnginePower(100);
        setModelName("Volvo240");
        stopEngine();
    }
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
