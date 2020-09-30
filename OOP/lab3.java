package com.JavaClg.class3;

import java.util.*;
import java.text.DecimalFormat;

class Point {
    double cordX;
    double cordY;

    Point(double cordX, double cordY) {
        this.cordX = cordX;
        this.cordY = cordY;
    }
}

class Rectangle {
    Point p1;
    Point p2;
    double height;
    double width;

    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;

    }

    public double getHeight() {
        return Math.abs(p2.cordY - p1.cordY);
    }

    public double getWidth() {
        return Math.abs(p2.cordX - p1.cordX);
    }

    public double getArea() {
        return Math.abs(p2.cordY - p1.cordY) * Math.abs(p2.cordX - p1.cordX);
    }

}

class Circle {

    double radius;
    double area;

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public Circle(double r) {
        radius = r;

    }

    public double getRadius() {
        return radius;
    }

    public String getArea() {
        area = radius * radius * Math.PI;
        return df2.format(area);
    }
}

public class lab3 {
    public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    double x1, x2, y1, y2, r;
    System.out.println("Enter the x & y coordinate of first corner point of rectangle: ");
    x1 = in.nextDouble();
    y1 = in.nextDouble();

    System.out.println("Enter the x & y coordinate of second corner point of rectangle: ");
    x2 = in.nextDouble();
    y2 = in.nextDouble();

    Point s1 = new Point(x1, y1);
    Point s2 = new Point(x2, y2);

    Rectangle r1 = new Rectangle(s1, s2);

    System.out.println("Height of rectangle " + r1.getHeight() + "\n" + "Width of rectangle " + r1.getWidth() + "\n"
            + "Area of rectangle is " + r1.getArea() + "\n");

    if (Math.abs(s2.cordY - s1.cordY) > Math.abs(s2.cordX - s1.cordX)) {
        r = Math.abs(s2.cordX - s1.cordX) / 2.0;
    }

    else {

        r = Math.abs(s2.cordY - s1.cordY) / 2.0;
    }
    Circle c1 = new Circle(r);

    System.out.println("Radius of circle " + c1.getRadius() + "\n" + "Area of circle " + c1.getArea());
    System.out.println("The area of largest circle is less than area of rectangle");
}

}
