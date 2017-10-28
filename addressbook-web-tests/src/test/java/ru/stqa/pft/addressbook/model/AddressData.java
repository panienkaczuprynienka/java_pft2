package ru.stqa.pft.addressbook.model;

public class AddressData {
  private int id;
  private final String firstname;
  private final String lastname;
  private final String personalAddress;
  private String group;

  public int getId() {
    return id;
  }

  public AddressData(String firstname, String lastname, String personalAddress, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.lastname = lastname;
    this.personalAddress = personalAddress;
    this.group = group;
  }

  public AddressData(int id, String firstname, String lastname, String personalAddress, String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.personalAddress = personalAddress;
    this.group = group;
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

  public String getGroup() { return group; }


  public void setId(int id) {
    this.id = id;
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

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

}
