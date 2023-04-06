package controller;

import model.ModelData;
import model.requests.IncrementBalanceRequest;
import model.userAccount.Buyer;

import java.util.Objects;

public interface BuyerController {

    //---------------------------------------------------------------------
    static String getMyProfile() {
        return "User name: " + ModelData.getYou().getUserName() + "\nPassword: " + ModelData.getYou().getPassword()
                + "\nEmail: " + ModelData.getYou().getEmail() + "\nPhone number: " + ModelData.getYou().getPhoneNumber()
                + "\nBalance: "+ ModelData.getYou().getBalance();
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

    static void setEmail(String email) {

        ModelData.getYou().setEmail(email);
    }

    static void setPhoneNumber(String phoneNumber) {

        ModelData.getYou().setPhoneNumber(phoneNumber);
    }

    //------------------------------------------------------------------------------

    static void setIncrementBalanceRequest(double amount) {

        IncrementBalanceRequest balanceRequest = new IncrementBalanceRequest(ModelData.getYou(), amount);
    }

    //---------------------------------------------------------------------------

}
