package com.example.fase2.model.product.digital_Product.storageDevice;


import com.example.fase2.model.ModelData;
import com.example.fase2.model.product.ProductCategory;

//=================================================================Creatable
public class FlashMemory extends StorageDevice {

    private int USB_Version; // must be between 1 and 4

    //0000000000000000000000000000000000000000000000000===constructor

    public FlashMemory(int USB_Version, int capacity, int size, int weight, String name, int numberOfAvailable, double price) {

        super(capacity, weight, size, name, numberOfAvailable, price);
        this.USB_Version = USB_Version;

        //set ID for every object with its properties
        this.ID = new StringBuilder(this.getClass().getName() + "-" + name + "-" + USB_Version);

        ModelData.getProducts().add(this);

        this.category = ProductCategory.FLASH;

    }


    public void setUSB_Version(int USB_Version) {
        this.USB_Version = USB_Version;
    }

    public int getUSB_Version() {
        return USB_Version;
    }
}