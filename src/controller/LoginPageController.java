package controller;

import model.ModelData;
import model.userAccount.Buyer;
import view.AdminView.AdminView;
import view.BuyerView.BuyerView;

import java.util.Objects;

public interface LoginPageController {




    //-------------------------------------------------------------------------------------------------------------

    /**
     * check username and password for customers  if the user is a customer it calls buyers view else if its admin , calls admin view
     */
    static void LoginCheck(String username, String password){

        for (Buyer buyer : ModelData.getCustomers()){
            if(Objects.equals(buyer.getUserName(), username) && Objects.equals(buyer.getPassword(), password))
                BuyerView.ShowBuyerOptions();
        }

         if(Objects.equals(ModelData.getAdmin().getUserName(), username) && Objects.equals(ModelData.getAdmin().getPassword(), password)){

             AdminView.AdminShowOptions();
         }
    }

}
