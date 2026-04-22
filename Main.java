public class Main {
   public static void main(String[] args) {
       LibraryCatalog catalog = LibraryCatalog.getInstance();

       Book javaTextbook = catalog.getBook("CS101");
       Book engTextbook = catalog.getBook("ENG205");
       Book mathTextbook = catalog.getBook("MAT300");

       User alice = new Student("Alice");
       User drBob = new Faculty("Dr. Bob");
       User charlie = new Student("Charlie");
       User drPhilip = new Faculty("Dr. Philip");
       User david = new Student("David");

       System.out.println("\n--- SCENARIO 1: CHECKOUT & WAITLIST ---");

       // CS101 has 2 copies
       javaTextbook.checkout(alice);
       javaTextbook.checkout(charlie);

       // After 2 copies next person borrowing will be on waitlist
       javaTextbook.checkout(david);

       // David tries again -> should not be added twice
       javaTextbook.checkout(david);

       engTextbook.checkout(drBob);

       // waitlisted
       engTextbook.checkout(drPhilip);

       mathTextbook.checkout(drBob);

       System.out.println("\n--- SCENARIO 2: RETURN & NOTIFY ---");

       // One CS101 copy is returned then david is notified
       javaTextbook.returnItem();

       // ENG205 is returned then dr.Phillip is notified
       engTextbook.returnItem();

       // No queue
       mathTextbook.returnItem();

       System.out.println("\n--- SCENARIO 3: LATE FEES ---\n");
       alice.processLateReturn(12);
       drBob.processLateReturn(32);
   }
}