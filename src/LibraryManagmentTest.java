import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LibraryManagmentTest {

	@Test
	public void testBookId() throws Exception{
		Book book1 = new Book (100, null);
		Book book2 = new Book (999, null);
		//Book book3 = new Book (10, null);
		//Book book4 = new Book (1000, null);

		
		//Checks if the valid numbers are in fact valid
		assertTrue(book1.isValidId(100));
		assertTrue(book2.isValidId(999));
		//Throws exceptions when a number does not fall between 100 to 999
		assertThrows(Exception.class, () -> new Book(99, "Number is invalid to low. 100 - 999"));
		assertThrows(Exception.class, () -> new Book(1000, null));
		


	}
	

}
