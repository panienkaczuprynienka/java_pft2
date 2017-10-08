package ru.stqa.pft.addressbook;

public class AddressData {
  private final String firstname;
  private final String lastname;
  private final String address;

  public AddressData(String firstname, String lastname, String address) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }
}
