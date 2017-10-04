package ru.stqa.pft.sandbox;

public class Parallelogram {
  public double a;
  public double b;


  public Parallelogram(double a, double b){
    this.a=a;
    this.b=b;
  }

  public  double obwod(){
    return 2*this.a+2*this.b;
  }
}
