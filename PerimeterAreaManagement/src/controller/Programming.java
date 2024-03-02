/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Circle;
import model.Rectangle;
import model.Triangle;

/**
 *
 * @author phuct
 */
public class Programming {
    Validation valid = new Validation();
    public Triangle inputTriangle() {
        while (true) {
            System.out.print("Please input side A of Triangle: ");
            double a = valid.checkInputDouble();
            System.out.print("Please input side B of Triangle: ");
            double b = valid.checkInputDouble();
            System.out.print("Please input side C of Triangle: ");
            double c = valid.checkInputDouble();
            if (a + b > c && b + c > a && a + c > b) {
                return new Triangle(a, b, c);
            } else {
                System.out.println("Re-input");
            }
        }
    }

    public Rectangle inputRectangle() {
        System.out.print("Please input side width of Rectangle: ");
        double width = valid.checkInputDouble();
        System.out.print("Please input length of Rectangle: ");
        double length = valid.checkInputDouble();
        return new Rectangle(width, length);
    }

    public Circle inputCircle() {
        System.out.print("Please input radius of Circle: ");
        double radius = valid.checkInputDouble();
        return new Circle(radius);
    }
    
    public void display(Triangle trigle, Rectangle rectangle, Circle circle) {
        rectangle.printResult();
        circle.printResult();
        trigle.printResult();
    }
}
