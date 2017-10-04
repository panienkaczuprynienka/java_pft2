package ru.stqa.pft.sandbox;

public class MySecondProgramPractices {

  public static void main(String[] args) {
    powitanie("Michalina");
    powitanie("Joanna");
    powitanie("Daniel");

    double zo=10;
    double wo=5;
    double so=7;
    System.out.println("powierzchnia rownolegloboku o wymiarach " + zo+ " oraz " + wo + " wynosi " + pole(zo,wo));


    Parallelogram p= new Parallelogram(10,5);
    System.out.println("obwod rownolegloboku o wymiarach " + p.a + " oraz " + p.b + " wynosi " + p.obwod());
  }


  public static void powitanie(String user) {
    System.out.println("Witaj " + user + ", dziś podam Ci pole i obwód równoległoboku");


  }

  public static double pole(double a, double h){
    return 0.5*(a*h);
  }


}

