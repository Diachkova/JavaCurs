package home.two.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;

public class ContactData {
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  @Expose
  private String name;
  private String middleName;
  @Expose
  private String surname;
  private String nik;
  private String title;
  private String company;
  @Expose
  private String address;
  @Expose
  private String email;
  private String email2;
  private String email3;
  private String fax;
  private String work;
  private String mobile;
  @Expose
  private String home;
  private String allPhones;
  private String group;
  private String allAddress;
  private String allEmail;
  private String allData;
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }



  public String getAllName() {
    return allName;
  }

  public ContactData withAllName(String allName) {
    this.allName = allName;
    return this;
  }

  private String allName;

  public String getAllData() {
    return allData;
  }

  public ContactData withAllData(String allData) {
    this.allData = allData;
    return this;
  }



  public String getAllAddress() {
    return allAddress;
  }

  public ContactData withAllAddress(String allAddress) {
    this.allAddress = allAddress;
    return  this;
  }

  public String getAllEmail() {
    return allEmail;
  }

  public ContactData withAllEmail(String allEmail) {
    this.allEmail = allEmail;
    return  this;
  }


  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }



  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactData withSurname(String surname) {
    this.surname = surname;
    return this;
  }

  public ContactData withNik(String nik) {
    this.nik = nik;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }
  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }
  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactData withWork(String work) {
    this.work = work;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withHome(String home) {
    this.home = home;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
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
  public String getEmail2() {
    return email2;
  }
  public String getEmail3() {
    return email3;
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

    if (id != that.id) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return surname != null ? surname.equals(that.surname) : that.surname == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    return result;
  }
}
