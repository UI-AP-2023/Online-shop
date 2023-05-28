package com.example.phase2.model.userAccount;

public class Admin extends Account{
    private static Admin admin;


    private Admin(String userName, String email, String phoneNumber, String password) {
        super(userName, email, phoneNumber, password);
    }

    //(((((((((((((((((((((((((((((((((...SINGLETON...))))))))))))))))))))))))))))))))))

    public static Admin getAdmin(String userName, String email, String phoneNumber, String password){
        if(admin == null){
            admin = new Admin(userName, email, phoneNumber, password);
        }
        return admin;
    }

    //-------------------------------------------------

}
