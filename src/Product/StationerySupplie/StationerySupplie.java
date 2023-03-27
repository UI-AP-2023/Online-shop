package Product.StationerySupplie;

public abstract class StationerySupplie {

    private String country;

    //0000000000000000000000000000000000000000000000000===CONSTRUCTOR

    StationerySupplie(String country){
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

