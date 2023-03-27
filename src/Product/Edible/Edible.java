package Product.Edible;

public class Edible {

    private String productDate, ExpirationDate;

    //0000000000000000000000000000000000000000000000000===constructor

    Edible(String productDate, String ExpirationDate){
        this.productDate = productDate;
        this.ExpirationDate = ExpirationDate;
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
