package jjeongDIN;

import java.util.ArrayList;
import java.util.Scanner;

public class HandleBookList {
    BookList bookList;
    private ArrayList<Book>tmpBook;

    public HandleBookList(){
        bookList= new BookList();
        tmpBook=new ArrayList<Book>();
    }
   public void update() {
	   bookList.update();
   }
    public void register_book(String id,String title,
    		String author,String publisher, int published, int price, String
            status ){
        if(!title.isEmpty()) {
            Book book = new Book(id, title, author, publisher, published, price, status);
            bookList.register_book(book);
        }
    }   
    
   
    String get_userID_from_book(int idx) {
    	if(tmpBook.size()>idx)
    		return tmpBook.get(idx).get_id();
    	return null;
    }
     	
    public ArrayList<Book> find_book_admin(){
        tmpBook=BookList.get_bookList_all();
        //printArray(tmpBook);
        return tmpBook;

    }
    public void manage_book_admin(int idx){
    	if(tmpBook.size()>idx)
    		bookList.delete_book_from_list(tmpBook.get(idx));
    }
    
    
    public void delete_book_for_deleted_user(int idx,String findings) {
    	 ArrayList <Book> deleteBook= new ArrayList<Book>();
         deleteBook.addAll(bookList.search_book(idx,findings));
         int i=0;
         while(i<deleteBook.size()) {
        	
         bookList.delete_book_from_list(deleteBook.get(i));
         i++;
         }
         
    }

    public ArrayList<Book> find_book_for_customer(int idx,String findings){
        tmpBook= new ArrayList<Book>();
        tmpBook.addAll(bookList.search_book(idx,findings));
        return tmpBook;
       // printArray(tmpBook);
    }


    public void selling_book_customer_delete(int idx){
    	if(tmpBook.size()>idx)
    		bookList.delete_book_from_list(tmpBook.get(idx));
    }

    public void selling_book_customer_modify(int idx,int modify,String fixed){
    	if(tmpBook.size()>idx)
    		bookList.modify_book(tmpBook.get(idx),modify,fixed);
    }
    public void buying_book_customer(int idx){
    	if(tmpBook.size()>idx)
    		bookList.delete_book_from_list(tmpBook.get(idx));
    }
	
}
