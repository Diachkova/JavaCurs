package home.two.addressbook.tests;

import home.two.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    System.out.println("before " + before);
    app.getGroupHelper().creatGroup(new GroupData("Test1", null, "Test3"));
    app.getNavigationHelper().gotoGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    System.out.println("after " + after);
    Assert.assertEquals(after, before + 1);
  }

}
