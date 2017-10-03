package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("jozek");
    hello("wiesiek");
    hello("marek");

    double len=5;
    System.out.println("powierzchnia kwadratu o boku " + len + "wynosi "+area(len));

    double a=4;
    double b=6;
    System.out.println("powierzchnia prostokata o bokach " + a + " i " +b + " wynosi " + area(a,b));
  }

  public static void hello(String somebody){
    System.out.println("Hello, "+somebody + "!");
  }

  public static double area(double l){
    return l*l;
  }

  public static double area(double a, double b){
    return a*b;
  }
}