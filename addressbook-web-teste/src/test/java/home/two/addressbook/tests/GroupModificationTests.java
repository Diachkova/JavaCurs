package home.two.addressbook.tests;

import home.two.addressbook.model.GroupData;
import org.testng.annotations.Test;

/**
 * Created by Andrey on 31.10.2016.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification(){
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("Test12", "Test21", "Test31"));
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().gotoGroupPage();
  }
}
