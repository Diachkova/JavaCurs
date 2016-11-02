package home.two.addressbook.tests;

import home.two.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTestsChrome extends TestBase {


  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createNewGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("Test1", "Test2", "Test3"));
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().gotoGroupPage();
  }

}
