package home.two.addressbook.tests;

import home.two.addressbook.model.GroupData;
import home.two.addressbook.model.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Groups before = (Groups) app.group().all();
    System.out.println("before " + before);
    GroupData group = new GroupData().withGroupName("Test1");
    app.group().create(group);
    Groups after = (Groups) app.group().all();

    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
