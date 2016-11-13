package home.two.addressbook.appmanager;

import home.two.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class GroupHelper extends HelperBase {


  public GroupHelper(WebDriver wd) {
    super(wd);
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

  public void creatGroup(GroupData group) {
    createNewGroup();
    fillGroupForm(group);
    submitGroupCreation();
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

  public List<GroupData> getGroupList() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = getListElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      String id = element.findElement(By.tagName("input")).getAttribute("value");
      GroupData group = new GroupData(id, name, null, null);
      groups.add(group);
    }
    return groups;
  }
}

