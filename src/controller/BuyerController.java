package controller;

import model.ModelData;
import model.userAccount.Buyer;

import java.util.Objects;

public interface BuyerController {

    //---------------------------------------------------------------------
    static String getMyProfile() {
        return "User name: " + ModelData.getYou().getUserName() + "\nPassword: " + ModelData.getYou().getPassword()
                + "\nEmail: " + ModelData.getYou().getEmail() + "\nPhone number: " + ModelData.getYou().getPhoneNumber();
    }
    //---------------------------------------------------------------------

    static boolean checkUserName(String userName) {

        for (Buyer customer : ModelData.getCustomers()) {

            if (Objects.equals(customer.getUserName(), userName)) {
            return false;
            }
        }

        return true;

    }

    //------------------------------------------------------------------------

    static void setUserName(String userName){

        ModelData.getYou().setUserName(userName);
    }

    static void setPassword(String password) {

        ModelData.getYou().setPassword(password);
    }

    //---------------------------------------------------------------------------

}
