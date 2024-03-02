
import controller.Programming;
import model.Circle;
import model.Rectangle;
import model.Triangle;

public class main {
    public static void main(String[] args) {
        Programming programming = new Programming();
        Rectangle rectangle = programming.inputRectangle();
        Circle circle = programming.inputCircle();
        Triangle triangle = programming.inputTriangle();

        programming.display(triangle, rectangle, circle);
    }
}
