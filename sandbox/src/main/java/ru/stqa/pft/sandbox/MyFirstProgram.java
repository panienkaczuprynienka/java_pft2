package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("jozek");
    hello("wiesiek");
    hello("marek");

    Square s= new Square(5);

    System.out.println("powierzchnia kwadratu o boku " + s.l + "wynosi "+s.area());

    Rectangle r= new Rectangle (4,6);

    System.out.println("powierzchnia prostokata o bokach " + r.a + " i " + r.b + " wynosi " + r.area());
  }

  public static void hello(String somebody){
    System.out.println("Hello, "+somebody + "!");
  }



}