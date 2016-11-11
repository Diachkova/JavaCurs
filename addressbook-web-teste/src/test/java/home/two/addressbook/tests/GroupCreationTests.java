package home.two.addressbook.tests;

import home.two.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().creatGroup(new GroupData("Test1", null, "Test3"));
    app.getNavigationHelper().gotoGroupPage();
  }

}
