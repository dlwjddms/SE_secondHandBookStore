package jjeongDIN;
public class Customer extends User{

    protected String userEmail;
    protected String name;
    protected int phoneNum;
    protected boolean activate; // true - activate

    public Customer(String userID, String userPW, String userEmail, String name, int phoneNum){
        super();
        this.userID = userID;
        this.userPW = userPW;
        this.userEmail = userEmail;
        this.name= name;
        this.phoneNum= phoneNum;
        this.activate = true;
    }
    public String getUserEmail() {
        return userEmail;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNum() {
        return phoneNum;
    }
    public boolean isActivate() {
        return activate;
    }
    public void setActivate(boolean activate) {
        this.activate = activate;
    }
}


