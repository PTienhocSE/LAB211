package controller;

import java.util.Scanner;
import view.Menu;
import model.Number;

public class Programming extends Menu {
    Scanner sc = new Scanner(System.in);
    Validation valid = new Validation();

    public Programming(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                calculateEquation();
                break;
            case 2:
                quadraticEquation();
                break;
            case 3:
                System.exit(0);
        }
    }

    public void calculateEquation() {
        System.out.println("\n----- Calculate Equation -----");
        System.out.print("Enter A: ");
        double a = valid.checkInputDouble();
        System.out.print("Enter B: ");
        double b = valid.checkInputDouble();
        double x = -b / a;
        System.out.println("Solution: x = " + new Number(x));
        Validation.checkProperties(new Number(a), new Number(b), new Number(x));
    }

    public void quadraticEquation() {
        System.out.println("\n----- Calculate Quadratic Equation -----");
        System.out.print("Enter A: ");
        double a = valid.checkInputDouble();
        System.out.print("Enter B: ");
        double b = valid.checkInputDouble();
        System.out.print("Enter C: ");
        double c = valid.checkInputDouble();
        double delta = b * b - 4 * a * c;
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        System.out.println("Solution: x1 = " + new Number(x1) +
                " and x2 = " + new Number(x2));
        Validation.checkProperties(new Number(a), new Number(b), new Number(c), new Number(x1), new Number(x2));
    }
}
