package home.one;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceOtherTests {
  @Test
  public void testRes(){
    Point p1 = new Point(7, 7);
    Point p2 = new Point(7, 7);
    DistanceOther t = new DistanceOther(p1, p2);
    Assert.assertEquals(t.res(), 0.0);
  }
}
