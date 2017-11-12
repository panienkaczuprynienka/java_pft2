package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name="addressbook")
@XStreamAlias("addresses")
public class AddressData {
  @XStreamOmitField
  @Id
  @Column(name="id")
  private int id = Integer.MAX_VALUE;
  @Expose
  @Column(name="firstname")
  private String firstname;
  @Column(name="middlename")
  private String middlename;
  @Expose
  @Column(name="lastname")
  private String lastname;
  @Column(name="nickname")
  private String nickname;
  @Column(name="company")
  private String company;
  @Column(name="title")
  private String title;
  @Expose
  @Column(name="address")
  @Type(type="text")
  private String personalAddress;
  @Column(name="email")
  @Type(type="text")
  private String email;
  @Column(name="email2")
  @Type(type="text")
  private String email2;
  @Column(name="email3")
  @Type(type="text")
  private String email3;
  @Expose
  @Transient
  private String allEmails;
  @Transient
  private String group;
  @Column(name="home")
  @Type(type="text")
  private String homePhone;
  @Column(name="mobile")
  @Type(type="text")
  private String mobilePhone;
  @Column(name="work")
  @Type(type="text")
  private String workPhone;
  @Column(name="fax")
  @Type(type="text")
  private String faxPhone;
  @Expose
  @Transient
  private String allPhones;
  @Column(name="homepage")
  @Type(type="text")
  private String homepage;
  @Column(name="photo")
  @Type(type="text")
  @Transient
  private String photo;

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
    if (photo == null) {
      return null;
    } else {
      return new File(photo);
    }
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
    this.photo = photo.getPath();
    return this;
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

  @Override
  public String toString() {
    return "AddressData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

}
