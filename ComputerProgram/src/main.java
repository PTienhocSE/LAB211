
import controller.programming;

public class main {
    public static void main(String[] args) {
        String mChon[] = {"Normal Calculator","BMI Calculator","Exit"};
        programming program = new programming("========= Calculator Program =========", mChon);
        program.run();
    }
}
