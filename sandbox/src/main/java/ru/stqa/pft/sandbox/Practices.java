package ru.stqa.pft.sandbox;

public class Practices {


  public static double distance(Point p1, Point p2) {

    double dx;
    double dy;
    dx = p2.x - p1.x;
    dy = p2.y - p1.y;

    return Math.sqrt((dx * dx) + (dy * dy));
  }

  public static void main(String[] args) {
    Point p1 = new Point(4.0,2.0);
    Point p2 = new Point(8.0,4.0);


    System.out.println("Dlugość odcinka o współrzędnych " + p1.x +" "+ p1.y + " oraz " + p2.x +" "+ p2.y + " wynosi " + distance(p1, p2));

  }
}
