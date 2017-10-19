package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

  @Test
  public void testPrime(){
    Assert.assertTrue(Prime.isPrime(Integer.MAX_VALUE));
  }

  @Test
  public void testPrimeFast(){
    Assert.assertTrue(Prime.isPrimeFast(Integer.MAX_VALUE));
  }

  @Test
  public void testNotPrime(){
    Assert.assertFalse(Prime.isPrime(Integer.MAX_VALUE-3));
  }

  @Test(enabled=false)
  public void testPrimeLong(){
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Prime.isPrime(n));
  }
}
