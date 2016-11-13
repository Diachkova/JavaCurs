package home.two.addressbook.tests;

import home.two.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification(){
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().creatGroup(new GroupData("Test1", null, "Test3"));
      app.getNavigationHelper().gotoGroupPage();
    }
    int before = app.getGroupHelper().getGroupCount();
    System.out.println("before " + before);
    app.getGroupHelper().selectGroup(before - 1);
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("Test3", null, null));
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().gotoGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
    System.out.println("after " + after);
  }
}
