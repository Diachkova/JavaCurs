package ff.test;

public class GroupDataFF {
  private final String groupName;
  private final String header;
  private final String footer;

  public GroupDataFF(String groupName, String header, String footer) {
    this.groupName = groupName;
    this.header = header;
    this.footer = footer;
  }

  public String getGroupName() {
    return groupName;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }
}
