import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LibraryManagmentTest {

	//Test case for book ID validity 
	@Test
	public void testBookId() throws Exception{
		Book book1 = new Book (100, "Is a valid ID");
		Book book2 = new Book (999, "Is a valid ID");

		//Checks if the valid numbers are in fact valid
		assertTrue(book1.isValidId(100));
		assertTrue(book2.isValidId(999));
		
		//Throws exceptions when a number does not fall between 100 to 999
		assertThrows(Exception.class, () -> new Book(99, "Number is invalid to low. Choose between 100 - 999"));
		assertThrows(Exception.class, () -> new Book(1000, "Number is invalid to high. Choose between 100 - 999"));
	}
	

}
