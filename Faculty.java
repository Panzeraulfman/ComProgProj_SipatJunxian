public class Faculty extends User{
   public Faculty(String name){
       super(name, new FacultyFee());
   }
}