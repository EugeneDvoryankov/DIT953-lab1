import java.awt.*;

/** Represents a base model of a car that all other car's are based on.
 * It has the following attributes:
 * The car's current x coordinate,
 * The car's current y coordinate,
 * The number of doors on the car,
 * The engine power of the car,
 * The current speed of the car,
 * The car's color,
 * The car's modelName.
 * Has getters and setters for all attributes except setters for x and y coordinate.
 * Also contains gas and brake methods which in turn contain incrementSpeed and decrementSpeed methods,
 * for the purpose of increasing or decreasing the car's speed.
 */
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

    /**
     * Get the number of doors
     * @return the number of doors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Set the number of doors (For testing purposes?)
     * @param nrDoors The number of doors wanted
     */
    public void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }

    /**
     * Get the engine power
     * @return the engine power
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Set the engine power (For testing purposes?)
     * @param enginePower the engine power wanted
     */
    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    /**
     * Get the current speed
     * @return current speed
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Set the current speed (For testing purposes?)
     * @param currentSpeed the current speed wanted
     */
    private void setCurrentSpeed(double currentSpeed) {
        //currentSpeed always lies in the interval [0,enginePower]
        if(currentSpeed >= 0) {
            this.currentSpeed = Math.min(currentSpeed, getEnginePower());
        }
    }

    /**
     * Get the color of the car
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Set the color (For testing purposes)
     * @param color The color wanted
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Get the model name
     * @return model name
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Set the model name (For testing purposes?)
     * @param modelName The model name wanted
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }


    /**
     * Start the engine
     */
    public void startEngine(){
        setCurrentSpeed(0.1);
    }

    /**
     * Stop the engine
     */
    public void stopEngine(){
        setCurrentSpeed(0);
    }

    /**
     * Get the X coordinate (For testing purposes)
     * @return the X coordinate of the car
     */
    public double getX() {
        return x;
    }


    /**
     * Get the Y coordinate (For testing purposes)
     * @return the Y coordinate of the car
     */
    public double getY() {
        return y;
    }

    /**
     * Move the Car forwards.
     *
     */
    @Override
    public void move() {
        y = y + getCurrentSpeed();
    }

    /**
     * Turn the car to the left.
     */
    @Override
    public void turnLeft(){
        x = x - getCurrentSpeed();
    }

    /**
     * Turn the car to the right.
     */
    @Override
    public void turnRight(){
        x = x + getCurrentSpeed();
    }

    @Override
    public String toString(){
        return "( x: " + getX() + ", y: "  + getY() + ", currentSpeed: " + getCurrentSpeed() + ", " + ")";
    }

    /*The following method exist in both Saab95 and Volvo240
     * but the the method bodies are different for methods in Saab95 and Volvo
     * But because the method name is the same we create an abstract method
     * which then Saab95 and Volvo inherit and override
     */

    public abstract double speedFactor();

    /** Increases the car's currentSpeed.
     *
     * @param amount a multiplier for how much the speed should increase, taken from gas.
     */
    public void incrementSpeed(double amount){
            double newSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
            setCurrentSpeed(newSpeed);
    }

    /** Decreases the car's currentSpeed.
     *
     * @param amount a multiplier for how much the speed should decrease, taken from brake.
     */
    public void decrementSpeed(double amount){
            double newSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
            setCurrentSpeed(newSpeed);
    }

    /**
     * Gas the car.
     *
     * Takes a number between 1 and 0.
     * @param amount how hard you press the gas
     */
    public void gas(double amount){
        if (amount >= 0 & amount <= 1) {
           incrementSpeed(amount);
        }
    }

    /**
     * Brake the car.
     * Takes a number between 1 and 0.
     * @param amount how hard you press the brakes
     */
    public void brake(double amount){
        if (amount >= 0 & amount <= 1) {
            decrementSpeed(amount);
        }
    }

}
