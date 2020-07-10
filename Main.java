package jjeongDIN;

import java.util.Scanner;

public class Main {

    /**
     * @param args
     */

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc;
        int opt;
        boolean BREAK;
        HandleUserList CList= new HandleUserList();
        HandleBookList BList = new HandleBookList();
        View view =new View();
        boolean Run=true;
        User user;
       
        while(Run){
        	 
        	 user =view.login_process(CList);
        	 //    boolean USER = login();
        	 
        	if(user!=null){
        		if( user.getUserID().equals("admin")) { //admin
            		view.Admin_action(BList, CList);
                
            }
            else{ //customer

            	view.Customer_action(BList, CList,user);
            }
            
            Run =view.running_continue();
            if(Run==false) {
            	 view.update(BList, CList); 	
            	 break;
            }
            

        }
        	
        	
       }
       
       
    }

}
