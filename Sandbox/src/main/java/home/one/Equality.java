package home.one;

/**
 * Created by ndya on 10.11.2016.
 */
public class Equality {

  public static void main(String[] args) {
    String s1 = "firefox2.0";
    String s2 = "firefox"+ Math.sqrt(4.0);

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));

  }

}
