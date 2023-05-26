package com.example.fase2.model.product.digital_Product;


import com.example.fase2.model.ModelData;
import com.example.fase2.model.product.ProductCategory;

public class PC extends DigitalProduct {

    private String CPU_Model;
    private int ramMemoryCapacity;

    //0000000000000000000000000000000000000000000000000===constructor

    public PC(int weight, int size, String name, int numberOfAvailable, String CPU_Model, int ramMemoryCapacity, double price) {

        super(weight, size, name, numberOfAvailable, price);
        this.CPU_Model = CPU_Model;
        this.ramMemoryCapacity = ramMemoryCapacity;

        //set ID for every object with its properties
        this.ID = new StringBuilder(this.getClass().getName() + name + "-" + CPU_Model + "-" + ramMemoryCapacity);

        ModelData.getProducts().add(this);

        this.category = ProductCategory.PC;
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
