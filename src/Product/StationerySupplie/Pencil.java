package Product.StationerySupplie;

public class Pencil extends StationerySupplie{

    private PencilType type;

    //0000000000000000000000000000000000000000000000000===CONSTRUCTOR

    Pencil(String country, PencilType type) {
        super(country);
        this.type = type;
    }

    public PencilType getType() {
        return type;
    }

    public void setType(PencilType type) {
        this.type = type;
    }
}

