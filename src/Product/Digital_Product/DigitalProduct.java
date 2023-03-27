package Product.Digital_Product;

public abstract class DigitalProduct {

    private int weight;
    private int size;

    //0000000000000000000000000000000000000000000000000===constructor

    protected DigitalProduct(int weight, int size) {
        this.weight = weight;
        this.size = size;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}




