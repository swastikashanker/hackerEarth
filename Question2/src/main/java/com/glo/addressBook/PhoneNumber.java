package com.glo.addressBook;

import java.util.regex.Pattern;

public class PhoneNumber {
    private String label;
    private String phoneNumber;

    public PhoneNumber(String label, String phoneNumber) throws Exception {
        if (Pattern.matches("[A-Za-z ]+", label) && label.length() <= 255 && label != "") {
            this.label = label;
        } else {
            throw new Exception();
        }

        if (Pattern.matches("[0-9]{10}", phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new Exception();
        }
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
