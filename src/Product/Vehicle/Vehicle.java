package Product.Vehicle;

public abstract class Vehicle {

    private String companyName;

    //0000000000000000000000000000000000000000000000000===CONSTRUCTOR

    Vehicle(String companyName){
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
