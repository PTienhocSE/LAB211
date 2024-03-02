
import controller.StudentManagement;



public class main {

    public static void main(String[] args) {
        String mChon[] = {"Create", "Find and Sort", "Update/Delete", "Report", "Exit"};
        StudentManagement studentManagement = new StudentManagement("WELCOME TO STUDENT MANAGEMENT", mChon);
        studentManagement.run();
    }
}
//sua static 
// sua to String
//them view STudent
//dem 10 dua
// menu getValidCourse() {
//        System.out.println("Available courses:");
//        System.out.println("1. Java");
//        System.out.println("2. .Net");
//        System.out.println("3. C/C++");
//        System.out.print("Enter course number: ");
