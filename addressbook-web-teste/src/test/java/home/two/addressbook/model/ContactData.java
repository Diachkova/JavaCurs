package home.two.addressbook.model;

public class ContactData {
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

  public ContactData(String name, String middleName, String surname, String nik, String title, String company,
                     String address, String email, String fax, String work, String mobile, String home) {
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
}
