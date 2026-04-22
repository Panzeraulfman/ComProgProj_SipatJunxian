public class StudentFee implements FeeStrategy{
   @Override
   public double calculateFee(int daysLate) {
       return daysLate * 1.00;
   }
}