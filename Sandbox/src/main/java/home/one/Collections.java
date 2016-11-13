package home.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrey on 13.11.2016.
 */
public class Collections {
  public  static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};

    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");


    for (String l : langs) {
      System.out.println(" я хочу выучить " + l);
    }
  }
}
