package jjeongDIN;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class HandleUserListTest {
	HandleUserList UList = new HandleUserList();

	@Test
	void testHandleUserList() {
		System.out.println("---------testHandleUserList----------\n");
		assertNotNull(UList);
		System.out.println("-------------------\n");
	}


	@Test
	void testLogin_user() {
		System.out.println("---------testLogin_user----------\n");
		User user = new User();
		user=UList.login_user("dlwjddms", "1234");
		assertNotNull(user);
		System.out.println(user+"\n");
		user=UList.login_user("admin", "nayana");
		assertNotNull(user);
		System.out.println(user+"\n");
		System.out.println("-------------------\n");
	}

	@Test
	void testCheck_id_before_register() {
		System.out.println("---------testCheck_id_before_register()----------\n");
		assertTrue(UList.check_id_before_register("dlwjddms"));
		assertFalse(UList.check_id_before_register("dlwjdgk"));
		System.out.println("-------------------\n");
	}

	@Test
	void testRegister_user() {
		ArrayList<Customer> cus = new ArrayList<Customer>();
		System.out.println("--------- testRegister_user() ----------\n");
		
		cus=UList.find_userList_all();
		
		UList.register_user("lisa", "8660", null,null,12341234);
		
		System.out.println("-------------------\n");
	}

	@Test
	void testFind_userList_all() {
		System.out.println("----------testFind_userList_all()---------\n");
		assertNotNull(UList.find_userList_all());
		System.out.println("-------------------\n");
	}

	@Test
	void testChange_user_status() {
		ArrayList<Customer> cus = new ArrayList<Customer>();
		System.out.println("-------testChange_user_status------------\n");
		cus=UList.find_userList_all();
		assertNotNull(cus);
		UList.change_user_status(0);
		
		System.out.println("-------------------\n");
	}

	@Test
	void testDelete_user_from_list() {
		
		System.out.println("---------testDelete_user_from_list----------\n");
		
		int i =UserList.UserList.size();
		UList.find_userList_all();
		UList.delete_user_from_list(2);
		assertEquals(i-1,UserList.UserList.size());
		System.out.println("-------------------\n");
	}

}
