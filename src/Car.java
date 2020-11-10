import java.awt.*;


public abstract class Car implements Movable{
    /* In order to avoid duplication
    we created a Car class that will contain all the instance variables and methods
    that exist in both Saab95 and Volvo240 classes */

    private double x; // The cars's x direction
    private double y; // The car's y direction
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    public Car(){
        this.x = 0;
        this.y = 0;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        //currentSpeed always lies in the interval [0,enginePower]
        if(currentSpeed >= 0) {
            this.currentSpeed = Math.min(currentSpeed, getEnginePower());
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }



    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void move() {
        y = y + currentSpeed;
    }

    @Override
    public void turnLeft(){
        x = x - currentSpeed;
    }

    @Override
    public void turnRight(){
        x = x + currentSpeed;
    }

    @Override
    public String toString(){
        return "( x: " + x + ", y: "  + y + ", currentSpeed: " + currentSpeed + ", " + ")";
    }

    /*The following method exist in both Saab95 and Volvo240
     * but the the method bodies are different for methods in Saab95 and Volvo
     * But because the method name is the same we create an abstract method
     * which then Saab95 and Volvo inherit and override
     */
    public abstract double speedFactor();

    public void incrementSpeed(double amount){
        if (amount > 0) {
            double newSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
            setCurrentSpeed(newSpeed);
        }
    }

    public void decrementSpeed(double amount){
        if (amount > 0) {
            double newSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
            setCurrentSpeed(newSpeed);
        }
    }

    public void gas(double amount){
        if (amount >= 0 || amount <= 1) {
           incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if (amount >= 0 || amount <= 1) {
            decrementSpeed(amount);
        }
    }

}
