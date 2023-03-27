package Product.StationerySupplie;

public class Office extends StationerySupplie{

    private int numberOfSheets;
    private String paperType;

    //0000000000000000000000000000000000000000000000000===CONSTRUCTOR

    Office(String country, int numberOfSheets, String paperType) {
        super(country);
        this.numberOfSheets = numberOfSheets;
        this.paperType = paperType;
    }

    public int getNumberOfSheets() {
        return numberOfSheets;
    }

    public void setNumberOfSheets(int numberOfSheets) {
        this.numberOfSheets = numberOfSheets;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }
}
