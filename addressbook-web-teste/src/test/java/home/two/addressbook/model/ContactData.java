package home.two.addressbook.model;

public class ContactData {

  private int id;
  private final String name;
  private final String middleName;
  private final String surname;
  private final String nik;
  private final String title;
  private final String company;
  private final String address;
  private final String email;
  private final String fax;
  private final String work;
  private final String mobile;
  private final String home;
  private String group;


  public ContactData(int id, String name, String middleName, String surname, String nik, String title, String company,
                     String address, String email, String fax, String work, String mobile, String home, String group) {
    this.id = id;
    this.name = name;
    this.middleName = middleName;
    this.surname = surname;
    this.nik = nik;
    this.title = title;
    this.company = company;
    this.address = address;
    this.email = email;
    this.fax = fax;
    this.work = work;
    this.mobile = mobile;
    this.home = home;
    this.group = group;
  }

  public ContactData(String name, String middleName, String surname, String nik, String title, String company,
                     String address, String email, String fax, String work, String mobile, String home, String group) {
    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.middleName = middleName;
    this.surname = surname;
    this.nik = nik;
    this.title = title;
    this.company = company;
    this.address = address;
    this.email = email;
    this.fax = fax;
    this.work = work;
    this.mobile = mobile;
    this.home = home;
    this.group = group;
  }
  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getSurname() {
    return surname;
  }

  public String getNik() {
    return nik;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }

  public String getFax() {
    return fax;
  }

  public String getWork() {
    return work;
  }

  public String getMobile() {
    return mobile;
  }

  public String getHome() {
    return home;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return surname != null ? surname.equals(that.surname) : that.surname == null;

  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    return result;
  }
}
