package home.two.addressbook.tests;

import home.two.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {


    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();

        if (! app.getGroupHelper().isThereAGroup()) {
            //System.out.println(" не нашлась группа");
            app.getGroupHelper().creatGroup(new GroupData("Test1", null, "Test3"));
            app.getNavigationHelper().gotoGroupPage();
       // } else {
         //   System.out.println("нашлась группа");
        }

        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getNavigationHelper().gotoGroupPage();
    }

}
