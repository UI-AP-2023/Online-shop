package Model.Requests;

import Model.Product.Product;
import Model.User_account.Buyer;

import java.util.ArrayList;


public class BuyingRequest {

    private ArrayList<Product> products = new ArrayList<>();

    private final Buyer requester;
    private final String address;

//=======================================================================================================

    BuyingRequest(Buyer requester, String address, ArrayList<Product> products) {

        this.requester = requester;
        this.address = address;
        this.products = products;
    }

    //---------------------------------------------------

    @Override
    public String toString() {

        StringBuilder temp =new StringBuilder();
        for (Product product: products) {
            temp.append(product.getID()).append("\n");
        }

        return "REQUESTER: "+ requester + " , ADDRESS: "+ address + ", ORDERS: "+ temp;
    }
}
