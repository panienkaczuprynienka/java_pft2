package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;

@XStreamAlias("addresses")
public class AddressData {
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  @Expose
  private String firstname;
  private String middlename;
  @Expose
  private String lastname;
  private String nickname;
  private String company;
  private String title;
  @Expose
  private String personalAddress;
  private String email;
  private String email2;
  private String email3;
  @Expose
  private String allEmails;
  private String group;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String faxPhone;
  @Expose
  private String allPhones;
  private String homepage;
  private File photo;

  public String getMiddlename() {
    return middlename;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getTitle() {
    return title;
  }

  public String getFaxPhone() {
    return faxPhone;
  }

  public String getHomepage() {
    return homepage;
  }

  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getPersonalAddress() {
    return personalAddress;
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

  public String getAllEmails() {
    return allEmails;
  }

  public String getGroup() {
    return group;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public File getPhoto() {
    return photo;
  }

  public AddressData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public AddressData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public AddressData withCompany(String company) {
    this.company = company;
    return this;
  }

  public AddressData withTitle(String title) {
    this.title = title;
    return this;
  }

  public AddressData withFaxPhone(String faxPhone) {
    this.faxPhone = faxPhone;
    return this;
  }

  public AddressData withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public AddressData withId(int id) {
    this.id = id;
    return this;
  }

  public AddressData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public AddressData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public AddressData withPersonalAddress(String personalAddress) {
    this.personalAddress = personalAddress;
    return this;
  }

  public AddressData withEmail(String email) {
    this.email = email;
    return this;
  }

  public AddressData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public AddressData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public AddressData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public AddressData withGroup(String group) {
    this.group = group;
    return this;
  }

  public AddressData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public AddressData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public AddressData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public AddressData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public AddressData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  @Override
  public String toString() {
    return "AddressData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AddressData that = (AddressData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
