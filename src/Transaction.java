import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
	//Creates the object instance
	public static Transaction instance;
	
	//Creates the object
	private Transaction() {}
	
	//Checks if instance was already created, if not then a new Transaction Method is created
	public static Transaction getTransaction() {
		if (instance == null) {
			instance = new Transaction();
		}
		return instance;
	}
	
	public void saveTransaction(String transactionDetails) {
		try(FileWriter writer = new FileWriter("transactions.txt", true)){
			writer.write(transactionDetails + "\n");
		} catch(IOException e) {
			System.out.println("Error saving transaction: " + e.getMessage());
		}
				
	}

    // Perform the borrowing of a book
    public boolean borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.borrowBook();
            member.borrowBook(book); 
            String transactionDetails = getCurrentDateTime() + " - Borrowing: " + member.getName() + " borrowed " + book.getTitle();
            System.out.println(transactionDetails);
            
            //When a book has been borrowed it will be saved to the transaction txt
            saveTransaction(transactionDetails);
            return true;
        } else {
            System.out.println("The book is not available.");
            return false;
        }
    }

    // Perform the returning of a book
    public void returnBook(Book book, Member member) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.returnBook();
            String transactionDetails = getCurrentDateTime() + " - Returning: " + member.getName() + " returned " + book.getTitle();
            System.out.println(transactionDetails);
            
            //When a book has been returned it will be saved to the transaction txt
            saveTransaction(transactionDetails);
        } else {
            System.out.println("This book was not borrowed by the member.");
        }
    }

    // Get the current date and time in a readable format
    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    
    public void displayTransactionHistory() { 
    	try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))){
    		String line;
    		System.out.println("\nTransaction History");
    		System.out.println("===========================");
    		while ((line = reader.readLine()) != null) {
    			System.out.println(line);
    		}
    	} catch (IOException e) {
    		System.out.println("Error Reading Transaction History: " + e.getMessage());
    	}
    }
    
    
    
    
}