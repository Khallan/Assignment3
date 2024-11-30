import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Constructor;
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
	
	@Test
	public void testBorrowReturn() throws Exception {
		
		//This checks if there is a book available with the same ID
		Book book = new Book (100, "Programming");
		assertTrue(book.isAvailable());
		
		//Initiates the member test case
		Member member = new Member(1111, "George");
		
		//This calls the transaction and then uses it to call borrowBook for the specific book and member, then ensures 
		//if the book is unavailable, or already borrowed
		Transaction transaction = Transaction.getTransaction();	
		assertTrue(transaction.borrowBook(book, member));
		
		//If the same book is then borrowed again, there will be a fail
		assertFalse(transaction.borrowBook(book, member));
		
		//Then this returns the book, sets it back to available and test if member1 has the book
		transaction.returnBook(book, member);
		assertTrue(book.isAvailable());
		assertFalse(member.getBorrowedBooks().contains(book));
			
		//This calls the return function again and checks if the member has the book which he does not as it has been returned
		transaction.returnBook(book, member); 
	    assertTrue(book.isAvailable()); 
	    assertFalse(member.getBorrowedBooks().contains(book));

	}
	@Test
	public void testSingletonTransaction() throws Exception {
		
//		try {
//			//Gets the constructor from the transaction class
//			Constructor<Transaction> constructor = Transaction.class.getDeclaredConstructor();
//			int modifiers = constructor.getModifiers();	
//			assertTrue(Modifier.PRIVATE, modifiers & modifi);
//			
//		} catch (Exception e) {
//			//If the constructor is not found
//			
//		}
		

	}
	
	

}
