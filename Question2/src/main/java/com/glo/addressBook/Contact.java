package com.glo.addressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Contact {
    private String name;
    private String organisation;
    private List<PhoneNumber> phoneNumbers;
    private List<Address> addresses;

    public Contact(String name, String organisation) throws Exception {
        if (Pattern.matches("[A-Za-z ]+", name) && name.length() <= 255 && name != "") {
            this.name = name;
        } else {
            throw new Exception();
        }
        if (organisation.length() <= 255) {
            this.organisation = organisation;
        } else {
            throw new Exception();
        }
    }






    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        if (this.phoneNumbers == null) {
            this.phoneNumbers = new ArrayList<>();
        }
        this.phoneNumbers.add(phoneNumber);
    }

    public void addAddress(Address address) {
        if (this.addresses == null) {
            this.addresses = new ArrayList<>();
        }
        this.addresses.add(address);
    }
}
