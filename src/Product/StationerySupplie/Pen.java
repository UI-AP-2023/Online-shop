package Product.StationerySupplie;

public class Pen extends StationerySupplie{

    private String color;

    //0000000000000000000000000000000000000000000000000===CONSTRUCTOR

    Pen(String country,String color) {
        super(country);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
