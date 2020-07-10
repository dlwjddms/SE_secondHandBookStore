package jjeongDIN;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class HandleBookListTest {
			HandleBookList bList = new HandleBookList();
	@Test
	void testHandleBookList() {
		System.out.println("----------testHandleBookLis---------\n");
		assertNotNull(bList);
		System.out.println("-------------------\n");
	}


	@Test
	void testRegister_book() {
		System.out.println("----------testRegister_book---------\n");
			int i =BookList.BookList.size();
			bList.register_book("dlwjddms", "java", null, null,0,0,null);
			assertEquals(i+1,BookList.BookList.size());
			
			System.out.println("-------------------\n");
	}

	
	@Test
	void testFind_book_admin() {
		ArrayList<Book> bo = new ArrayList<Book> ();
		System.out.println("-----------testFind_book_admin--------\n");
		bo=bList.find_book_admin();
		assertNotNull(bo);
		System.out.println("-------------------\n");
	}

	@Test
	void testManage_book_admin() {
		System.out.println("-------testManage_book_admin------------\n");
			int i =BookList.BookList.size();
			bList.find_book_admin();
			bList.manage_book_admin(0); /* erase book with idx 0 */
			assertEquals(i-1,BookList.BookList.size());
			System.out.println("-------------------\n");
			
	}

	@Test
	void testDelete_book_for_deleted_user() {
		ArrayList<Book> bo = new ArrayList<Book> ();
		System.out.println("----------testDelete_book_for_deleted_user---------\n");
		int i =BookList.BookList.size();
		bo =bList.find_book_admin();
	
		bList.delete_book_for_deleted_user(6, "dlwjddms");
		if(i<BookList.BookList.size()) {
			assertNotNull(null);
		}
	
		System.out.println("-------------------\n");
	}

	@Test
	void testFind_book_for_customer() {
		ArrayList<Book> bo = new ArrayList<Book> ();
		System.out.println("-------testFind_book_for_customer------------\n");
		bo=bList.find_book_for_customer(6, "dlwjddms");
		assertNotNull(bo);
		System.out.println("-------------------\n");
	}

	@Test
	void testSelling_book_customer_delete() {
		ArrayList<Book> bo = new ArrayList<Book> ();
		System.out.println("-----------testSelling_book_customer_delete--------\n");
		
		bo=bList.find_book_admin();
		System.out.println(bo);
		bList.selling_book_customer_delete(0);
	
		System.out.println("-------------------\n");
	}

	@Test
	void testSelling_book_customer_modify() {
		ArrayList<Book> bo = new ArrayList<Book> ();
		System.out.println("----------testSelling_book_customer_modify---------\n");
	
		bo=bList.find_book_admin();
		bList.selling_book_customer_modify(0, 1, "wow");
		
		//bList.printArray(BookList.BookList);
		System.out.println("-------------------\n");

	}

	@Test
	void testBuying_book_customer() {
		ArrayList<Book> bo = new ArrayList<Book> ();
	
		System.out.println("---------testBuying_book_customer----------\n");
		int i =BookList.BookList.size();
		bo=bList.find_book_admin();
		
		bList.buying_book_customer(0);
		assertEquals(i-1,BookList.BookList.size());
		
		System.out.println("-------------------\n");
		
	}

}
