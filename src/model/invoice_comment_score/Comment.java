package model.invoice_comment_score;

import model.userAccount.Buyer;

public class Comment {

    private final Buyer commenter;
    private final String comment;
    private final String productID;
    private boolean Verified;
    private final boolean boughtByCommenter;

    //====================================================================

    public Comment(Buyer commenter, String comment, String productID, boolean boughtByCommenter){

        this.commenter = commenter;
        this.comment = comment;
        this.productID = productID;
        this.boughtByCommenter = boughtByCommenter;
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

    public void setStatus(Boolean status) {
        this.Verified = status;
    }

    //----------------------------------------------------------------

    public String getProductID() {
        return productID;
    }

    //--------------------------------------------------------------

    public boolean getStatus() {
        return Verified;
    }
}

