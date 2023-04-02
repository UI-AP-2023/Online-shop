package Model.Requests;

public class SignupRequest {

    private final String userName;
    private final String email;
    private final String phoneNumber;
    private final String password;
    private static int staticNumber=1;
    private final int number;

    //==================================================================================================================


    SignupRequest(String userName, String email, String phoneNumber,String password){

        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.number = staticNumber++;
    }

    //------------------------------------------------------
    @Override
    public String toString() {
        return number + " . USER NAME: (" + userName + ") , PASSWORD: (" + password + "), EMAIL: (" + email + ") , PHONE NUMBER: " + phoneNumber;
    }
}
