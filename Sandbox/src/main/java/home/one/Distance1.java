package home.one;

/**
 * Created by Andrey on 29.10.2016.
 */
public class Distance1 {
    public Point point1;
    public Point point2;

    public Distance1(Point point1, Point point2) {
      this.point1 = point1;
      this.point2 = point2;
    }
    public double res() {

      return Math.sqrt((point2.x-point1.x)*(point2.x-point1.x) + (point2.y-point1.y)*(point2.y-point1.y));
    }
  }

