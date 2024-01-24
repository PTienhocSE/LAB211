
import controller.Programming;


public class main {
    public static void main(String[] args) {
        String mChon[] = {"Calculate Superlative Equation", "Calculate Quadratic Equation", "Exit"};
        Programming programming = new Programming("\n========= Equation Program =========", mChon);
        programming.run();
    }
}
