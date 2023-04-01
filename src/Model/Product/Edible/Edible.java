package Model.Product.Edible;

import Model.Product.Product;
import Model.Product.ProductCategory;

public class Edible extends Product {

    private String productDate, ExpirationDate;
    private static int staticID=1;

    //0000000000000000000000000000000000000000000000000===constructor

    Edible(String productDate, String ExpirationDate, String name, int numberOfAvailable,double price){

        super(name, numberOfAvailable,price);

        this.productDate = productDate;
        this.ExpirationDate = ExpirationDate;

        //set ID for every object with its properties
        this.ID = new StringBuilder(name+staticID);
        staticID++;

    }

    static void SetCategory(){
        category = ProductCategory.EDIBLE;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public String getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        ExpirationDate = expirationDate;
    }
}
