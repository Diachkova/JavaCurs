package home.two.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTestsChrome extends TestBase {


  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    createNewGroup();
    fillGroupForm(new GroupData("Test1", "Test2", "Test3"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
