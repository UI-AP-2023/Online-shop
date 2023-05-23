package model.invoice_comment_score;

import model.product.Product;

import java.util.ArrayList;

public class Invoice {

    private final ArrayList<Product> orders;

    private final String date;
    private final double paidAmount;

    private static int staticID = 400;
    private final StringBuilder invoiceID;

    //==================================================================================
    Invoice(String date, double paidAmount, ArrayList<Product> Orders) {

        this.date = date;
        this.paidAmount = paidAmount;
        this.orders = Orders;

        invoiceID = new StringBuilder(staticID + staticID / 2 + "." + paidAmount);
        staticID++;
    }

    //----------------------------------------------------------------------------------

    public String getDate() {
        return date;
    }

    //----------------------------------------------------------------------------------

    @Override
    public String toString() {

        StringBuilder temp = new StringBuilder();
        for (Product order : orders) {
            temp.append(order.toString()).append("\n");
        }

        return "INVOICE ID: " + invoiceID + "\n" + temp + "AMOUNT: " + paidAmount + "$"+"\n\n";
    }

    //------------------------------------------------------------------------

    public ArrayList<Product>getBoughtOrders() {

        return new ArrayList<>(orders);
    }
}
