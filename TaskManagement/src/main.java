
import controller.Programming;


public class main {
    public static void main(String[] args) {
        String mChon[] = {"Add Task","Delete Task","Display Task", "Exit"};
        Programming program = new Programming("========= Task Management ==========", mChon);
        program.run();
    }
}
