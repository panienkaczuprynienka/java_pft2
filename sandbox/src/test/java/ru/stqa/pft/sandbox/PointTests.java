package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance(){
    Point p1 = new Point (2.0,10.0);
    Point p2 = new Point (2.0,1.0);
    Point p3 = new Point (20.0,20.0);

    Assert.assertEquals(9.0, p1.distance(p2));

    Assert.assertNotEquals(0.0,p1.distance(p2),"Test sprawdził,że długość istnieje (nie jest zerowa)");

    Assert.assertNotNull(p1.distance(p2),"Wartość długości nie jest zerowa");

    Assert.assertNotSame(p1.distance(p2),p1.distance(p3));

    Assert.assertTrue(p1.distance(p3)>10.0);



  }
}


