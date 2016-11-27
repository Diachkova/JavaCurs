package home.two.addressbook.appmanager;

import home.two.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class GroupHelper extends HelperBase {
  private ApplicationManager app;


  public GroupHelper(WebDriver wd, ApplicationManager app) {
    super(wd);
    this.app = app;
  }


  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getGroupName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void createNewGroup() {
    if (isElementPresent(By.name("new"))) {
      click(By.name("new"));
    } else {
      throw new RuntimeException("New button not found");
    }
  }

  public void modify(int index, GroupData group) {
    selectGroup(index);
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    app.goTo().groupPage();
  }

  public void deleteSelectedGroups() {
    if (isElementPresent(By.name("delete"))) {
      click(By.name("delete"));
    } else {
      throw new RuntimeException("Delete button not found");
    }
  }

  public void selectGroup(int index) {
    if (isElementPresent(By.name("selected[]"))) {
      getListElements(By.name("selected[]")).get(index).click();
    } else {
      throw new RuntimeException("Select button not found");
    }
  }


  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));

  }

  public void create(GroupData group) {
    createNewGroup();
    fillGroupForm(group);
    submitGroupCreation();
    app.goTo().groupPage();
  }

  public void delete(int index) {
    selectGroup(index);
    deleteSelectedGroups();
    app.goTo().groupPage();
  }

  public boolean isThereAGroup() {
    // if (!isElementPresent(By.tagName("h1"))
    //       && getElement(By.tagName("h1")).getText().equals("Groups")
    //     && isElementPresent(By.name("new"))) {
    // click(By.linkText("groups"));
    //}
    return isElementPresent(By.name("selected[]"));
  }


  public int getGroupCount() {
    return getCount(By.name("selected[]"));
  }

  public List<GroupData> list() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = getListElements(By.cssSelector("span.group"));
    System.out.println("elements list size = " + elements.size());
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      System.out.println("got id=" + id + ", name = " + name);
      groups.add(new GroupData().withId(id).withGroupName(name));
    }
    return groups;
  }
}

