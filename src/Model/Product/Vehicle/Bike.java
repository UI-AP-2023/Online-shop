package Model.Product.Vehicle;

public class Bike extends Vehicle{

    private BikeType type;

    Bike(String companyName,String name, int nmbrAvailable, BikeType type,double price) {

        super(companyName,name,nmbrAvailable,price);
        this.type = type;

        //set id
        this.ID= new StringBuilder(companyName+"-"+name+"-"+type.toString());
    }

    public BikeType getType() {
        return type;
    }

    public void setType(BikeType type) {
        this.type = type;
    }
}
