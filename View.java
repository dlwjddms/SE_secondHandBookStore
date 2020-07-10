package jjeongDIN;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
	
	 private ArrayList<Book>tmpBook;
	private ArrayList<Customer>customers;
   
    public View(){
    	tmpBook=new ArrayList<Book>();
        customers=new ArrayList<Customer>();
     
    }
   
	 public void printCusArray(ArrayList<Customer> customers){
	        int len =customers.size();
	        for(int i=0; i<len ;i++) {
	            System.out.println(i + ") ");
	            print_customer_element(i);
	        }
	    }
	    public void print_customer_element(int idx){
	    	if(customers.size()>idx) {
	        Customer cus = customers.get(idx);
	        System.out.println("1. ID:"+cus.getUserID()+"\n"+"2. Email:"+cus.getUserEmail()
	        +"\n"+"3. Name:"+cus.getName()+"\n"+"4. phone Num:"+cus.getPhoneNum()+"\n"+"5. activate:"+
	                cus.isActivate()+"\n");
	    	}
	    }
	
	    boolean printBoArray(ArrayList<Book> book){

	    	if(book.isEmpty()) {
	    		System.out.println("THERE IS NO BOOKS");
	    		return false;
	    	}
	    	else {
	        int len =book.size();
	        for(int i=0; i<len ;i++) {
	          
	            print_book_element(i);
	        }
	        return true;
	    	}
	    }
	    void print_book_element(int idx){
	        //1. Book title
	        // 2. ISBN
	        // 3. Author
	        // 4. publisher
	        //5. publishing house
	    	if(tmpBook.size()>idx) {
	        Book book = tmpBook.get(idx);
	        	System.out.println(idx+")\n"+"Book title : "+book.get_title()+"\n"+"ISBN :"
	        			+ " "+book.get_ISBN()+"\n"+"Author : "+book.get_author()+"\n"+"Publisher :"
	        					+ " "+book.get_publisher()+"\n"+"Published Year : "
	        			+book.get_published()+"\n"+"Price : "+book.get_price()+"\n"
	        					+"Status : "+book.get_status()+"\n"+"Owner ID : "+ book.get_id()+"\n");
	    	}
	         	
	    }
	
	 Scanner sc;
     int opt;
     
     boolean BREAK;
     public int scanner_for_integer() {
    	
    	 int intValue;
    	 
    	 while(true){
    		 sc = new Scanner(System.in);
        	 String input =sc.nextLine();
    	 try {
    		     intValue = Integer.parseInt(input);
    		     break;
    		}catch(NumberFormatException e) {
    		    System.out.println("Input is not a integer \n");
    		}
    	 }
		return intValue;
		
     }
     public String scanner_for_string() {
    	 sc = new Scanner(System.in);
         String input = sc.nextLine();
         return input;
     }

     public void update(HandleBookList BList,HandleUserList CList) {
    	 System.out.println("Updating ...:D!\n");
    	 	BList.update();
    	 System.out.println("Book update Done...:D!\n");
    	 	CList.update();
    	 System.out.println("User update Done.:D!\n");
    	  System.out.println("BYE BYE :D!");
     }
     
     public boolean running_continue() {
    	 
    	 System.out.println("Do you want to \n Quit the programm? \n y/n  (no for just logout)?");
         String input = scanner_for_string();
         if (input.equals("y") || input.equals("Y")) 
    		 return false;
    	 else
    		 return true;
     }
     
     public User login_process(HandleUserList CList){
    	 String ID=new String();
    	 String PW=new String();
    	
    	 System.out.println("Select and insert the number \n 1. Register  \n 2. Log in\n ");
    	 opt=scanner_for_integer();
    	 switch(opt) {
    	 case 1:
    		 String id,pw,email,name;
    		 int phoneNum;
    		 System.out.println("Register Process\n");
    		 System.out.println("Insert your information\n");
    		 //id pw 이름 번호 이메  String userID, String userPW, String userEmail, String name, int phoneNum
    		 boolean sameID =true;
    		 id=null;
    		 while(sameID) {
    			
    		 System.out.println("insert ID");
    		 id=scanner_for_string();
    		 sameID=CList.check_id_before_register(id);
    		 if(sameID)
    			 System.out.println("This ID already exists. Try again\n");
    		 }
   
    		 System.out.println("insert PW");
    		 pw=scanner_for_string();
    
    		 System.out.println("insert EMAIL");
    		 email=scanner_for_string();
    	
    		 System.out.println("insert NAME");
    		 name=scanner_for_string();
    		
    		 System.out.println("insert Phone NUM");
    		 phoneNum=scanner_for_integer();
    		 CList.register_user(id, pw, email, name, phoneNum);
    		 
    	 case 2:
    		 User user;
    		 do {
    		 System.out.println("Login Process\n");
    		
        	 System.out.println("Insert ID :\n");
        	 ID=scanner_for_string();
        	
        	 System.out.println("Insert PW :\n");
        	 PW=scanner_for_string();
    
        	 user=CList.login_user(ID, PW);
        	 
        	 }while(user==null);
    		 return user;
    	 default: break;
    	 }
    	 System.out.println("you insert bad number bye bye \n");
		return null;
     }
     
     
	public void Admin_action(HandleBookList BList,HandleUserList CList) {
		
		while (true) {
            BREAK= false;
            
             System.out.println("Select and insert the number \n 1. Manage user \n 2. Manage book \n 3. Logout \n--> ");
             opt = scanner_for_integer();
             switch (opt){
                 case 1:
                     System.out.println("Section for managing User\n Every user list\n ");
                     customers=CList.find_userList_all();
                     printCusArray(customers);
                     
                     System.out.println(" insert number of user you want to change \n");
                     
                     opt =  scanner_for_integer();
                    
                     System.out.println(" Do you want to change its status? y/n \n");
                     String input =  scanner_for_string();
                     if (input.equals("y") || input.equals("Y")) {
                         CList.change_user_status(opt);
                     }
                    
                     System.out.println(" Do you want to delete this? y/n \n");
                     input =  scanner_for_string();
                      if (input.equals("y") || input.equals("Y")) {
                    	  
                    	 BList.delete_book_for_deleted_user(6,CList.delete_user_from_list(opt));
                         
                     }


                     break;
                 case 2:
                     System.out.println("Section for managing Book \n");
                     tmpBook=BList.find_book_admin();
                     printBoArray(tmpBook);
                     System.out.println(" insert number book for delete  \n");
                     
                     opt =  scanner_for_integer();
                   
                     System.out.println("Do you want to delete this book? y/n \n");
                     String  Y =  scanner_for_string();
                     if(Y.equals("y")||Y.equals("Y"))
                         BList.manage_book_admin(opt);
                     break;


                 case 3:
                     BREAK =true;
                     break;
                 default: break;
             }
             if(BREAK)
                 break; // break from admin

         }
		
	}
	public void Customer_action(HandleBookList BList,HandleUserList CList,User user) {
		 while (true) {
             BREAK= false;
            
             System.out.println("Select and insert the number \n 1. For Buying Books \n 2. For Selling Books \n 3. Logout \n-->  ");
             opt =  scanner_for_integer();
             switch (opt){
                 case 1:
                     System.out.println("Section for Buying Books \n");
                     //book_buying();
                     
                     System.out.println("For Searching \n1. Book title\n2. ISBN \n3. Author \n4. publisher\n5. published year \n6. seller id \n");
                     int idx = scanner_for_integer();
                     
                     System.out.println("Please enter a search term. \n");
                     String  input =  scanner_for_string();
                     tmpBook=BList.find_book_for_customer(idx,input); //contoroller for search
                     printBoArray(tmpBook);
                    
                     System.out.println(" insert number book you want to buy  \n");
                     opt= scanner_for_integer();

                    
                     System.out.println("Do you want to buy this book? y/n \n");
                     input = scanner_for_string();

                     if(input.equals("y")|| input.equals("Y")) {
                    	 String user_email = CList.find_user_by_id(BList.get_userID_from_book(opt)).getUserEmail();
                    	 String user_id = CList.find_user_by_id(BList.get_userID_from_book(opt)).getUserID();
                    	 System.out.println("---------------------------\n");
                    	 System.out.println("|Sending email to :"+user_id+"|\n ");
                    	 System.out.println("|seller email :"+user_email+"|\n ");
                    	 input = scanner_for_string();
                    	 System.out.println("---------------------------\n ");
                    	 System.out.println("Sending .... \n Complete thanks! \n\n");
                         BList.buying_book_customer(opt);  //controller for delete
                     }
                     break;
                 case 2:
                    
                     System.out.println("Section for Selling Books \n1. For register \n2. For Modify and delete ");
                     opt= scanner_for_integer();
                     switch (opt){
                         case 1: //register
                             System.out.println("Isert information for register in correct order\n ");
                        
                             String title ,author,publisher,status;
                             int published,price;
                             System.out.println("1. Book title");
                             title = scanner_for_string();
                      
                             System.out.println("2. Author ");
                             author=scanner_for_string();
                          
                             System.out.println("3. publisher");
                             publisher=scanner_for_string();
                            
                             System.out.println("4. published year");
                             String tmp= scanner_for_string();
                             if(tmp.equals(""))
                            	 published =0;
                             else
                            	 published=Integer.parseInt(tmp);
                             
                             System.out.println("5. price");
                             tmp= scanner_for_string();
                             if(tmp.equals(""))
                            	 price =0;
                             else
                            	 price=Integer.parseInt(tmp);
                            
                             System.out.println("6. status");
                             status=scanner_for_string();
                             BList.register_book(user.getUserID(),title,author,publisher,published,price,status);
                             break;
                         case 2: //modify delete
                             System.out.println("This is book that you registered \n");
                             tmpBook=BList.find_book_for_customer(6,user.getUserID()); //contoroller for search
                             printBoArray(tmpBook);
                             
                             System.out.println(" insert number book for modify and delete  \n");
                             opt= scanner_for_integer();
                             //1. Book title
                             // 2. ISBN
                             // 3. Author
                             // 4. publisher
                             //5. publishing house
                            // BList.selling_book_customer(opt);
                             
                             print_book_element(opt);
                            
                             System.out.println(" Do you want to delete this? y/n \n");
                             input = scanner_for_string();
                             if(input.equals("y")|| input.equals("Y"))
                            	  BList.selling_book_customer_delete(opt);
                             else{
                                 System.out.println(" Do you want to modify this? y/n \n");
                                 input = scanner_for_string();
                                 if (input.equals("y") || input.equals("Y")) {
                                     System.out.println("For Modifying \n1. Book title\n2. ISBN \n3. Author \n4. "
                                     		+ "publisher\n5. published year\n6. price\n7. status\n ");
                                     int modify=scanner_for_integer();
                                     System.out.println("insert value you want\n");
                                     input = scanner_for_string();
                                     BList.selling_book_customer_modify(opt,modify,input);
                                 }
                             }
                             break;

                         default: break;

                     }
                     //book selling()

                     break;
                 case 3:
                     BREAK =true;
                     break;
                 default: break;
             }
             if(BREAK)
                 break; // break from customer

         }

	}
}
