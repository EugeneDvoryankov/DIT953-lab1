public interface IRamp {
    /** Increases the angle of the ramp with 10°
     *
     *  The angle of the platform can not be lower than 0° or higher than 70°
     *  The platform must not be raised if the truck is in motion
     */
    public void raiseRamp();

    /** Decreases the angle of the platform with 10°
     *  The angle of the platform can not be lower than 0° or higher than 70°
     */
    public void lowerRamp();

    /** Checks if the platform is raised.
     *
     * The angle of the platform can not be lower than 0° or higher than 70°
     * @return true if platformAngle is greater than zero,
     * otherwise returns false
     */
    public boolean isRampRaised();

    /** Determines whether the truck is in motion;
     * @return true if getCurrentSpeed() is equal to 0,
     * otherwise returns false
     */
    public boolean isStationary();

    /** Returns a speedFactor based on Scania's enginePower.
     * @return the speedFactor
     * */
    public double speedFactor();

    /**
     * Gas the truck.
     *
     * If the platform is raised then the truck will not gas.
     * Takes a number between 1 and 0.
     * @param amount how hard you press the gas
     */
    public void gas(double amount);

    /**
     * Starts the engine of the truck.
     * If the platform is raised, then the engine will not start.
     */
    public void startEngine();


}
