package Model.User_account;

public abstract class Account {

    protected String userName; // ----Must be UUID
    protected String email; // -------should use Regex for validating
    protected String phoneNumber; //-------should use Regex for validating
    protected String password; //-------should use Regex for validating
    protected Role role;


    //======================={The constructor...====================================
    Account(String userName, String email, String phoneNumber, String password){

        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }


//############################################################################################3
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}

enum Role{ BUYER, ADMIN}
