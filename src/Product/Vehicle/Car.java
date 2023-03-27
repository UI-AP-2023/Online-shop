package Product.Vehicle;

public class Car extends Vehicle {

    private int EngineVolume;
    private boolean automaticGearbox;

    //0000000000000000000000000000000000000000000000000===CONSTRUCTOR

    Car(String companyName,int EngineVolume, boolean automaticGearbox){

        super(companyName);

        this.EngineVolume = EngineVolume;
        this.automaticGearbox = automaticGearbox;
    }

    public int getEngineVolume() {
        return EngineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        EngineVolume = engineVolume;
    }

    public boolean isAutomaticGearbox() {
        return automaticGearbox;
    }

    public void setAutomaticGearbox(boolean automaticGearbox) {
        this.automaticGearbox = automaticGearbox;
    }
}
