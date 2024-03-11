import controller.Programming;
import controller.Validation;

public class main {
    public static void main(String[] args) {
        String[] mChon = {"Vietnamese","English", "Exit"};
        Validation validation = new Validation();
        Programming program = new Programming("========= Login Program ==========", mChon, validation);
        program.run();
    }
}
