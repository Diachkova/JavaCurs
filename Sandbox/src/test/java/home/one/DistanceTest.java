package home.one;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTest {
  @Test
  public void distanceTest(){
    Point p1 = new Point(1, 1);
    Point p2 = new Point(1, 1);

    Assert.assertEquals(p1.distance(p2), 0.0);

  }
}
