package home.two.addressbook.tests;

import home.two.addressbook.model.GroupData;
import home.two.addressbook.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.List.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() {
    ArrayList<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new GroupData().withGroupName("test1").withHeader("header1").withFooter("footer1")});
    list.add(new Object[] {new GroupData().withGroupName("test2").withHeader("header2").withFooter("footer2")});
    list.add(new Object[] {new GroupData().withGroupName("test3").withHeader("header3").withFooter("footer3")});
    return list.iterator();
  }


  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {
    app.goTo().groupPage();
    Groups before = app.group().all();
    System.out.println("before " + before);
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()+1));
    Groups after = app.group().all();
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    System.out.println("before " + before);
    GroupData group = new GroupData().withGroupName("Test'1");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));
  }

}
