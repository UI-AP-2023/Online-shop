package Product.Digital_Product;

public class PC extends DigitalProduct {

    private String CPU_Model;
    private int ramMemoryCapacity;

    //0000000000000000000000000000000000000000000000000===constructor

    PC(int weight, int size, String CPU_Model, int ramMemoryCapacity) {

        super(weight, size);
        this.CPU_Model = CPU_Model;
        this.ramMemoryCapacity = ramMemoryCapacity;
    }

    public int getRamMemoryCapacity() {
        return ramMemoryCapacity;
    }

    public void setRamMemoryCapacity(int ramMemoryCapacity) {
        this.ramMemoryCapacity = ramMemoryCapacity;
    }

    public String getCPU_Model() {
        return CPU_Model;
    }

    public void setCPU_Model(String CPU_Model) {
        this.CPU_Model = CPU_Model;
    }
}
