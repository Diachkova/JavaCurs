package home.one;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Andrey on 13.11.2016.
 */
public class PrimeTests {

  @Test
  public void testPrimes() {
    Assert.assertTrue(Prime.isPrime(Integer.MAX_VALUE));
  }


  @Test
  public void testТщтPrimes() {
    Assert.assertFalse(Prime.isPrime(Integer.MAX_VALUE-2));
  }
}
