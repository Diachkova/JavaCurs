package home.one;

public class MyFirstProgram {

	public static void main(String[] args) {

    Point p1 = new Point(4, 4);
    Point p2 = new Point(1, 1);

    System.out.println("Расстояние между точками с координатами " + "(" + p1.x + ";" + p1.y + ")" + " и " +
          "(" + p2.x + ";" + p2.y + ")" + " = " + p1.distance(p2));

    p1 = new Point(7, 7);
    p2 = new Point(7, 7);

      System.out.println("Расстояние между точками с координатами " + "(" + p1.x + ";" + p1.y + ")" + " и " +
              "(" + p2.x + ";" + p2.y + ")" + " = " + p1.distance(p2));

    p1 = new Point(-5, 8);
    p2 = new Point(8, -5);

      System.out.println("Расстояние между точками с координатами " + "(" + p1.x + ";" + p1.y + ")" + " и " +
              "(" + p2.x + ";" + p2.y + ")" + " = " + p1.distance(p2));

      p1 = new Point(7, 7);
      p2 = new Point(7, 7);
      DistanceOther t = new DistanceOther(p1, p2);

      System.out.println("Расстояние между точками с координатами " + "(" + p1.x + ";" + p1.y + ")" + " и " +
              "(" + p2.x + ";" + p2.y + ")" + " = " + t.res());

  }

}