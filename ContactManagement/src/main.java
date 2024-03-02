
import controller.Programming;

public class main {
    public static void main(String[] args) {
        String mChon[] = {"Add a Contact","Display all Contact","Delete a Contact", "Exit"};
        Programming program = new Programming("========= Contact program =========", mChon);
        program.run();
    }
}
