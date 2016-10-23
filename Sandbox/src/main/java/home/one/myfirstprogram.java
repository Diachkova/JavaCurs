package home.one;

public class MyFirstProgram {

	public static void main(String[] args) {

    Point p1 = new Point(1, 1);
    Point p2 = new Point(3, 3);

    System.out.println("Расстояние между точками с координатами " + p1.x + "," + p1.y + " и " +  p2.x + "," + p2.y +
            " = " + distance(p1, p2));
  }
  public static double distance(Point p1, Point p2) {
    return Math.sqrt((p2.x-p1.x)*(p2.x-p1.x) + (p2.y-p1.y)*(p2.y-p1.y));
  }

}