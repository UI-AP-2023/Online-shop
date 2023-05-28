package com.example.phase2.model.invoice_comment_score;

import com.example.phase2.model.product.Product;
import com.example.phase2.model.userAccount.Buyer;

public class Comment {

    private final Buyer commenter;
    private final String comment;
    private final boolean boughtByCommenter;
    private final Product product;

    //====================================================================

    public Comment(Buyer commenter, String comment, Product product, boolean boughtByCommenter){

        this.commenter = commenter;
        this.comment = comment;
        this.boughtByCommenter = boughtByCommenter;
        this.product = product;
        product.getComments().add(this);
    }

    //---------------------------------------------------------------

    @Override
    public String toString() {
        if(boughtByCommenter) {

            return commenter.getUserName() + ":\n" + comment + "\n\n...THIS USER BOUGHT THE PRODUCT... ";
        } // else
        return commenter.getUserName() + ":\n" + comment + "\n\n...THIS USER DID NOT BUY THE PRODUCT...";
    }

    //----------------------------------------------------------------

    public Product getProduct() {
        return product;
    }

    //--------------------------------------------------------------

}

