package jjeongDIN;



public class Book{

    private String title;
    private String author;
    private String publisher;
    private int published;
    private int price;
    private String status;
    private String ISBN;
    private String owner_id;
    public Book(String id,String title, String author,String publisher, 
    		int published, int price, String status){
        this.title=title;
        this.author=author;
        this.publisher=publisher;
        this.published=published;
        this.price=price;
        this.status=status;
        this.owner_id=id;
        set_ISBN(title+owner_id);
    }

    String get_title(){
        return this.title;
    }
    String get_author(){
        return this.author;
    }
    String get_publisher(){
        return this.publisher;
    }
    int get_published(){
        return this.published;
    }
    int get_price(){
        return this.price;
    }
    String get_status(){
        return this.status;
    }
    String get_ISBN(){
        return this.ISBN;
    }
    String get_id(){
        return this.owner_id;
    }

    void  set_title(String title){
        this.title=title;
    }
    void set_author(String author){
        this.author=author;
    }
    void set_publisher(String publisher){
        this.publisher=publisher;
    }
    void set_published(int published){
        this.published=published;
    }
    void  set_price(int price){
        this.price=price;
    }
    void set_status(String status){
        this.status=status; }

        void  set_ISBN(String ISBN){
        this.ISBN=ISBN;
    }

}
