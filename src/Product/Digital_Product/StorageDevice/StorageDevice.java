package Product.Digital_Product.StorageDevice;

import Product.Digital_Product.DigitalProduct;

//================================================================

public abstract class StorageDevice extends DigitalProduct {
    private int capacity;

    //0000000000000000000000000000000000000000000000000===constructor
    StorageDevice(int capacity, int weight, int size){
        super(weight, size);
        this.capacity = capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

//=================================================================Creatable
class FlashMemory extends StorageDevice{

    private int USB_Version;

    //0000000000000000000000000000000000000000000000000===constructor

    FlashMemory(int USB_Version, int capacity , int size , int weight){
        super(capacity,weight,size);
        this.USB_Version = USB_Version;
    }

    public void setUSB_Version(int USB_Version) {
        this.USB_Version = USB_Version;
    }

    public int getUSB_Version() {
        return USB_Version;
    }
}

//------------------------------------------------------------------

class SSD extends StorageDevice {

    private double readingSpeed, writingSpeed;

    //0000000000000000000000000000000000000000000000000===constructor

    SSD(int capacity,double readingSpeed, double writingSpeed,int weight, int size){
        super(capacity,weight,size);
        this.readingSpeed = readingSpeed;
        this.writingSpeed = writingSpeed;
    }

    public double getReadingSpeed() {
        return readingSpeed;
    }

    public void setReadingSpeed(double readingSpeed) {
        this.readingSpeed = readingSpeed;
    }

    public double getWritingSpeed() {
        return writingSpeed;
    }

    public void setWritingSpeed(double writingSpeed) {
        this.writingSpeed = writingSpeed;
    }
}