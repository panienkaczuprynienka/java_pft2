package ru.stqa.pft.sandbox;

public class Practices {


  public static void main(String[] args) {
    Point p1 = new Point(4.0,2.0);
    Point p2 = new Point(8.0,4.0);


    System.out.println("Dlugość odcinka o współrzędnych " + p1.x +" "+ p1.y + " oraz " + p2.x +" "+ p2.y + " wynosi " + p1.distance(p2));

  }



}
