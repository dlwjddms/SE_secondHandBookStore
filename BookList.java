package jjeongDIN;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class BookList {
    static ArrayList<Book> BookList;
    public BookList(){
        BookList = new ArrayList<Book>();
        //file 열어서 있는거 저장
        this.getInfo();
    }

    void register_book(Book book){
        BookList.add(book);
    }
    public static ArrayList<Book> get_bookList_all() {
        return BookList;
    }

    void modify_book(Book book,int idx,String newValue){
        boolean found =false;
        int i=0;
        for(;i<BookList.size();i++)
        if(BookList.get(i)==book) {
            found =true;
            break;
        }
        if(found){
            //1. Book title
            // 2. ISBN
            // 3. Author
            // 4. publisher
            //5. publishing house
            //6. seller id
            switch (idx) {
                case 1:
                     BookList.get(i).set_title(newValue);
                     break;
                case 2:
                    BookList.get(i).set_ISBN(newValue);
                    break;
                case 3:
                    BookList.get(i).set_author(newValue);
                    break;
                case 4:
                    BookList.get(i).set_publisher(newValue);
                    break;
                case 5:
                    BookList.get(i).set_published(Integer.parseInt(newValue));
                    break;
                case 6:
                    BookList.get(i).set_price(Integer.parseInt(newValue));
                case 7:
                    BookList.get(i).set_status(newValue);
                    break;
                default: break;
            }
        }

    }
    
 public void getInfo() {
	 String path = UserList.class.getResource("").getPath(); // 현재 클래스의 절대 경로를 가져온다.
     System.out.println(path); //--> 절대 경로가 출력됨
     File f = new File(path + "Book.txt"); // path 폴더 내의 test.txt 를 가리킨다.
     try {
         BufferedReader reader = new BufferedReader(new FileReader(f));
      
         String line = "";
        
         while ((line = reader.readLine()) != null) { 

             String[] temp = line.split(","); // , : 구분자
             if(temp.length<8)
            	 break;
             Book book =new Book(temp[0],temp[1],temp[2],temp[3],
            		 Integer.parseInt(temp[4]),Integer.parseInt(temp[5]),temp[6]);
             book.set_ISBN(temp[7]);
             register_book(book);
             
         }
         reader.close();
     } catch (Exception e) {
         e.printStackTrace();
     }
     //file 열어서 있는거 저장
    	
    }
    
    public void update() {
    	String path = UserList.class.getResource("").getPath(); // 현재 클래스의 절대 경로를 가져온다.
        //System.out.println(path); //--> 절대 경로가 출력됨
        File f = new File(path + "Book.txt"); // path 폴더 내의 test.txt 를 가리킨다.
        try {
        	
        	 BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        	 int i=0;
        	 while(i<BookList.size()) {
        	//String id,String title, String author,String publisher, int published, int price, String
        
        		 writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n",BookList.get(i).get_id(),
        				 BookList.get(i).get_title(),BookList.get(i).get_author(),BookList.get(i).get_publisher()
        				 ,BookList.get(i).get_published(),BookList.get(i).get_price(),BookList.get(i).get_status(),
        				 BookList.get(i).get_ISBN()));
        		 i++;
        		 writer.flush();
        	 }
             writer.close();
        } catch (Exception e) {
        e.printStackTrace();
    }
 	   
    }

    void delete_book_from_list(Book book){
        BookList.remove(book);
    }

    int get_bookList_size(){
        return BookList.size();
    }

    public ArrayList<Book> search_book(int index,String findings){
        ArrayList<Book> book =new ArrayList<Book>();
        switch(index){
            case 1: //book name
                for(int i =0 ; i<BookList.size();i++){
                    if(BookList.get(i).get_title().equals(findings))
                        book.add(BookList.get(i));
                }
                break;
            case 2: //ISBN
                for(int i =0 ; i<BookList.size();i++){
                    if(BookList.get(i).get_ISBN().equals(findings))
                        book.add(BookList.get(i));
                }
                break ;
            case 3: // author
                for(int i =0 ; i<BookList.size();i++){
                    if(BookList.get(i).get_author().equals(findings))
                        book.add(BookList.get(i));
                }
                break ;
            case 4: // publisher
                for(int i =0 ; i<BookList.size();i++){
                    if(BookList.get(i).get_publisher().equals(findings))
                        book.add(BookList.get(i));
                }
                break ;
            case 5: //published
                int fid = Integer.parseInt(findings);
                for(int i =0 ; i<BookList.size();i++){
                    if(BookList.get(i).get_published() ==fid)
                        book.add(BookList.get(i));
                }
                break ;
            case 6: //seller
                for(int i =0 ; i<BookList.size();i++){
                    if(BookList.get(i).get_id().equals(findings))
                        book.add(BookList.get(i));
                }
                break ;
            default: break;
        }
        return book;
    }
}
