package home.one;

public class myfirstprogram {

	public static void main(String[] args) {

    Point p1 = new Point(4, 4);
    Point p2 = new Point(1, 1);

    System.out.println("Расстояние между точками с координатами " + "(" + p1.x + ";" + p1.y + ")" + " и " +
          "(" + p2.x + ";" + p2.y + ")" + " = " + p1.distance(p2));

    Point p3 = new Point(7, 7);
    Point p4 = new Point(7, 7);

    System.out.println("Расстояние между точками с координатами " + "(" + p3.x + ";" + p3.y + ")" + " и " +
            "(" + p4.x + ";" + p4.y + ")" + " = " + p3.distance(p4));

    Point p5 = new Point(-5, 8);
    Point p6 = new Point(8, -5);

    System.out.println("Расстояние между точками с координатами " + "(" + p5.x + ";" + p5.y + ")" + " и " +
            "(" + p6.x + ";" + p6.y + ")" + " = " + p5.distance(p6));
	}

}