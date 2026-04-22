
public abstract class User{
   private String name;
   private FeeStrategy feeStrategy;

   public User(String name, FeeStrategy feeStrategy){
       this.name = name;
       this.feeStrategy = feeStrategy;
   }

   // Name of user
   public String getName(){
       return name;
   }

   // Notifies user when book is available
   public void notifyBookAvailable(String bookTitle){
       System.out.println("PING! Notification for " + name + ": '" + bookTitle + "' is now available!");
   }

   // Late return fees
   public void processLateReturn(int daysLate){
       double fee = feeStrategy.calculateFee(daysLate); // Fee depends on status of user
       System.out.println(name + " returned a book late. Fee charged: $" + String.format("%.2f", fee));
   }
}