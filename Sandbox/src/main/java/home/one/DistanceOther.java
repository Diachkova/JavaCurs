package home.one;


public class DistanceOther {
    public Point point1;
    public Point point2;

    public DistanceOther(Point point1, Point point2) {
      this.point1 = point1;
      this.point2 = point2;
    }
    public double res() {

      return Math.sqrt((point2.x-point1.x)*(point2.x-point1.x) + (point2.y-point1.y)*(point2.y-point1.y));
    }
  }

