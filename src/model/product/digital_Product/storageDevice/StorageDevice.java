package model.product.digital_Product.storageDevice;

import model.ModelData;
import model.product.ProductCategory;
import model.product.digital_Product.DigitalProduct;

//================================================================

public abstract class StorageDevice extends DigitalProduct {
    private int capacity;

    //0000000000000000000000000000000000000000000000000===constructor
    StorageDevice(int capacity, int weight, int size, String name, int numberOfAvailable,double price){

        super(weight, size, name, numberOfAvailable,price);
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

    private int USB_Version; // must be between 1 and 4

    //0000000000000000000000000000000000000000000000000===constructor

    FlashMemory(int USB_Version, int capacity , int size , int weight,String name, int numberOfAvailable,double price){

        super(capacity, weight, size, name, numberOfAvailable,price);
        this.USB_Version = USB_Version;

        //set ID for every object with its properties
        this.ID = new StringBuilder(this.getClass().getName()+"-"+name+"-"+USB_Version);

        ModelData.getProducts().add(this);

        this.category=ProductCategory.FLASH;

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

    SSD(int capacity,double readingSpeed, double writingSpeed,int weight, int size, String name, int numberOfAvailable, double price){

        super(capacity,weight,size,name,numberOfAvailable,price);
        this.readingSpeed = readingSpeed;
        this.writingSpeed = writingSpeed;

        //set ID for every object with its properties
        this.ID = new StringBuilder(this.getClass().getName()+"-"+name+"-"+capacity+"GB-"+readingSpeed + "RS-" + writingSpeed + "WS");

        ModelData.getProducts().add(this);

        this.category=ProductCategory.SSD;

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