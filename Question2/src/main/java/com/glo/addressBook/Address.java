package com.glo.addressBook;

import java.util.regex.Pattern;

public class Address {
    private String label;
    private String address;

    public Address(String label, String address) throws Exception {
        if (Pattern.matches("[A-Za-z ]+", label) && label.length() <= 255 && label != "") {
            this.label = label;
        } else {
            throw new Exception();
        }

        this.address = address;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
