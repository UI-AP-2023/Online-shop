package com.example.fase2.model.product.digital_Product.storageDevice;


import com.example.fase2.model.ModelData;
import com.example.fase2.model.product.ProductCategory;

public class SSD extends StorageDevice {

    private double readingSpeed, writingSpeed;

    //0000000000000000000000000000000000000000000000000===constructor

    public SSD(int capacity, double readingSpeed, double writingSpeed, int weight, int size, String name, int numberOfAvailable, double price) {

        super(capacity, weight, size, name, numberOfAvailable, price);
        this.readingSpeed = readingSpeed;
        this.writingSpeed = writingSpeed;

        //set ID for every object with its properties
        this.ID = new StringBuilder(this.getClass().getName() + "-" + name + "-" + capacity + "GB-" + readingSpeed + "RS-" + writingSpeed + "WS");

        ModelData.getProducts().add(this);

        this.category = ProductCategory.SSD;

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
