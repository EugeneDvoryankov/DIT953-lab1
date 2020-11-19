public class Scania extends Car{
    private int platformHeight=0;
    public boolean raisePlatform(int degrees){
        int newHeight=platformHeight+degrees;
        if(newHeight>70||newHeight<0||getCurrentSpeed()!=0) return false;
        platformHeight=newHeight;
        return true;
    }

    @Override
    public void incrementSpeed(double amount) {
        if (platformHeight==0) super.incrementSpeed(amount);
    }

    @Override
    public void startEngine() {
        if (platformHeight==0) super.startEngine();
    }

    @Override
    public double speedFactor() {
        return 0;
    }
}
