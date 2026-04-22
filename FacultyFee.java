public class FacultyFee implements FeeStrategy{
   @Override
   public double calculateFee(int daysLate) {
       return 0.00;
   }
}