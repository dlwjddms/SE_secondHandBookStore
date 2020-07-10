package jjeongDIN;

import java.util.ArrayList;

public class HandleUserList {

    UserList userList ;
    private ArrayList<Customer>customers;
    Admin admin;
    public HandleUserList(){
        userList =new UserList();
        customers=new ArrayList<Customer>();
        admin = new Admin();
    }
    
    public void update() {
 	   userList.update();
    }
 public Customer find_user_by_id(String ID) {
	 return userList.find_user_by_ID(ID);
 }
    
  public User login_user(String ID, String PW) {
    	if(admin.getUserID().contentEquals(ID))
    		return admin;
    	else {
    		User user = userList.login_user(ID, PW);
    		return user;
    	}
    }
    
  public boolean check_id_before_register(String ID) {
    	
    	if(userList.find_user_by_ID(ID)!=null)
    		return true;
    	return false;
    }
    
    public void register_user(String userID, String userPW, 
    		String userEmail, String name, int phoneNum){
    	Customer customer = new Customer(userID, userPW, userEmail, name, phoneNum);
    	
    	
    	
userList.register_(customer);
    }
 
    public  ArrayList<Customer> find_userList_all() {
        customers=UserList.get_userList_all();
       // printArray(customers);
        return  customers;
    }

   
    void change_user_status(int idx){
    	if(customers.size()>idx)
           userList.modify_status_user(customers.get(idx));
    }
    public String delete_user_from_list(int idx){
    	String ret =null;
        if(customers.size()>idx&&!customers.get(idx).isActivate()) {
        	ret=customers.get(idx).getUserID();
            userList.delete_user_from_list(customers.get(idx));           
        }
        return ret;
    }



}
