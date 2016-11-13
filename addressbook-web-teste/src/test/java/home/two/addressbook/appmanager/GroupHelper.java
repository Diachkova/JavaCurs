package home.two.addressbook.appmanager;

import home.two.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GroupHelper extends HelperBase{


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

  public void selectGroup() {
    if (isElementPresent(By.name("selected[]"))) {
      click(By.name("selected[]"));
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

}

