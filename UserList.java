package jjeongDIN;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class UserList {
	static ArrayList<Customer> UserList ;
    public UserList(){
        UserList = new ArrayList<Customer>();
        this.getInfo();
    }
    public void getInfo() {
    	
    	 String path = UserList.class.getResource("").getPath(); // 현재 클래스의 절대 경로를 가져온다.
         System.out.println(path); //--> 절대 경로가 출력됨
         File f = new File(path + "User.txt"); // path 폴더 내의 test.txt 를 가리킨다.
         try {
             BufferedReader reader = new BufferedReader(new FileReader(f));
          
             String line = "";
            
             while ((line = reader.readLine()) != null) { 

                 String[] temp = line.split(","); // , : 구분자
                 Customer customer =new Customer(temp[0],temp[1],temp[2],temp[3],Integer.parseInt(temp[4]));
                 if(temp[5].equals("true"))
                	 customer.setActivate(true);
                 else
                	 customer.setActivate(false);
                 register_(customer);
                 
             }
             reader.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
         //file 열어서 있는거 저장
    }
    
    public void update() {
    	String path = UserList.class.getResource("").getPath(); // 현재 클래스의 절대 경로를 가져온다.
        //--> 절대 경로가 출력됨
        File f = new File(path + "//User.txt"); // path 폴더 내의 test.txt 를 가리킨다.
        try {
        	 BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        	 int i=0;
        	 while(i<UserList.size()) {
        		
        		 //String userID, String userPW, String userEmail, String name, int phoneNum
        	 writer.write(String.format("%s,%s,%s,%s,%s,%s\n",UserList.get(i).getUserID(),
        			 UserList.get(i).getUserPW(),UserList.get(i).getUserEmail(),UserList.get(i).getName(),
        			 UserList.get(i).getPhoneNum(),UserList.get(i).isActivate()));
        	 writer.flush();
        	 i++;
        	 }
             writer.close();
        } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
    public Customer find_user_by_ID(String ID) {
    	 for(int i=0;i<UserList.size();i++)
             if(UserList.get(i).getUserID().contentEquals(ID)) 
            	 return UserList.get(i);
    	 return null;
    }
    public User login_user(String ID,String Pw) {
    	
    	 boolean found =false;
         int i=0;
         for(;i<UserList.size();i++)
             if(UserList.get(i).getUserID().contentEquals(ID)
            		 && UserList.get(i).getUserPW().equals(Pw)) {
                 found= true ;
                 break;
             }
         if(found) {
        	 	if(UserList.get(i).isActivate())
        	 		return UserList.get(i);
        	 	else
        	 		System.out.println("your accont is deactivated");
        	
         }
    
        	 return null;
         
    }
    void register_(Customer customer){
       UserList.add(customer);
    }
    public static ArrayList<Customer> get_userList_all() {
        return UserList;
    }
    void delete_user_from_list(Customer customer){
    	for(int i=0;i<UserList.size();i++)
    		if(UserList.get(i).getUserID().equals(customer.getUserID()))
    			UserList.remove(i);
    }
    void modify_status_user(Customer customer){
        boolean found =false;
        int i=0;
        for(;i<UserList.size();i++)
            if(UserList.get(i)==customer) {
                found =true;
                break;
            }

        if(found) {
            UserList.get(i).setActivate(!UserList.get(i).isActivate());
        }
    }
    int get_userList_size(){
        return UserList.size();
    }


}
