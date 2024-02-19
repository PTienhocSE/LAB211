
import controller.Programming;

public class main {
     public static void main(String[] args) {
        String mChon[] = {"Add Worker","Up salary","Down salary","Display Information salary", "Exit"};
        Programming program = new Programming("======== Worker Management =========", mChon);
        program.run();
    }
}
