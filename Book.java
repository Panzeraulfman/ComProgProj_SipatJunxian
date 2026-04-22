import java.util.*;

public class Book {
   private String title;
   private int availableCopies;
   private List<User> waitlist;

   public Book(String title, int availableCopies){
       this.title = title;
       this.availableCopies = availableCopies;
       this.waitlist = new ArrayList<>();
   }

   // Checks out books + keeps track of copies
   public void checkout(User user){
       if (availableCopies > 0){
           availableCopies--;
           System.out.println("\nSystem: '" + title + "' has been checked out by " + user.getName() + ".");
           System.out.println("System: Copies left: " + availableCopies);
       } 
       
       else{
           System.out.println("\nSystem: Sorry, '" + title + "' is currently unavailable.");
           addToWaitlist(user);
       }
   }

   // Sends to waitlist
   public void addToWaitlist(User user){
       if (availableCopies > 0){
           System.out.println("System: '" + title + "' is available, so no waitlist is needed.");
           return;
       }

       if (waitlist.contains(user)){
           System.out.println("System: " + user.getName() + " is already on the waitlist for '" + title + "'.");
           return;
       }

       waitlist.add(user);
       System.out.println("System: Added " + user.getName() + " to the waitlist for '" + title + "'.");
   }

   // Returns + waitlist processing
   public void returnItem(){
       System.out.println("\nSystem: A copy of '" + title + "' has been returned to the desk.");

       availableCopies++;
       System.out.println("System: Copies now available: " + availableCopies);

       if (waitlist.isEmpty()){
           System.out.println("System: Nobody is waiting. Copy placed on shelf.");
       } 
       
       else{
           User nextInLine = waitlist.remove(0);

           System.out.println("System: Auto-processing waitlist for " + nextInLine.getName() + "...");
           nextInLine.notifyBookAvailable(title);

           checkout(nextInLine);
       }
   }

   // Method for title of book
   public String getTitle(){
       return title;
   }

   // Method for number of copies
   public int getAvailableCopies(){
       return availableCopies;
   }
}