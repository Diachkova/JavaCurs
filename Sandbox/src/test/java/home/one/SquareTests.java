package home.one;
import org.testng.annotations.Test;
/**
 * Created by Andrey on 29.10.2016.
 */
public class SquareTests {
  @Test
  public void testRes(){
    Point p1 = new Point(7, 7);
    Point p2 = new Point(7, 7);
    Distance1 t = new Distance1(p1, p2);
    assert t.res() == 0;
  }
}
