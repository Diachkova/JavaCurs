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
    app.getGroupHelper().initGroupMofification();
    app.getGroupHelper().fillGroupForm(new GroupData("Test1", "Test2", "Test3"));
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().gotoGroupPage();
  }
}
