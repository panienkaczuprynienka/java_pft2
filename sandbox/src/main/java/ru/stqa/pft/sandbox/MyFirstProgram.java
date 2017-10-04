package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  /*public static void main(String[] args) {
    hello("jozek");
    hello("wiesiek");
    hello("marek");

    Square s = new Square(5);

    System.out.println("powierzchnia kwadratu o boku " + s.l + "wynosi " + s.area());

    Rectangle r = new Rectangle(4, 6);

    System.out.println("powierzchnia prostokata o bokach " + r.a + " i " + r.b + " wynosi " + r.area());
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }
}*/


  private static double distance(Point p1, Point p2) {

    p1 = new Point();
    p2 = new Point();

    double dx;
    double dy;
    dx = p2.x - p1.x;
    dy = p2.y - p1.y;

    return Math.sqrt((dx * dx) + (dy * dy));
  }

  public static void main(String[] args) {
    Point p1 = new Point();
    Point p2 = new Point();


    System.out.println("dlugosc odcinka o współrzędnych" + p1.x + p1.y + " oraz " + p2.x + p2.y + " wynosi " + distance(p1, p2));

  }
}

