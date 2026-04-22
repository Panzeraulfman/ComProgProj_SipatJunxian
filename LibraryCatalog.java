import java.util.*;

public class LibraryCatalog{
   private static LibraryCatalog instance;
   private Map<String, Book> inventory; // Map interface

   // Initialization of book inventory
   private LibraryCatalog(){
       inventory = new HashMap<>(); // Similar to dictionary in python

       inventory.put("CS101", new Book("Intro to Java Programming", 2)); // 2 CS101 books
       inventory.put("ENG205", new Book("Advanced English Literature", 1)); // 1 ENG205 book
       inventory.put("MAT300", new Book("Calculus III", 3)); // 3 MAT300 book
   }

   // Creates catalog if havent and return it
   public static LibraryCatalog getInstance(){
       if (instance == null){
           instance = new LibraryCatalog();
       }

       return instance;
   }

    // Get book by ID
   public Book getBook(String bookID) {
       return inventory.get(bookID);
   }
}