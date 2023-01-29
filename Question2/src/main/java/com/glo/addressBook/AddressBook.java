package com.glo.addressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) throws Exception {
        if (!isAlreadyPresent(contact.getName())) {
            this.contacts.add(contact);
        } else {
            throw new Exception();
        }
    }

    public void deleteContact(String name) throws Exception {
        if (isAlreadyPresent(name)) {
            this.contacts.remove(getContactByName(name));
        } else {
            throw new Exception();
        }
    }

    public void updateContact(String name, Contact contact) throws Exception {
        if (isAlreadyPresent(name)) {

            deleteContact(name);
            this.contacts.add(contact);
        } else {
            throw new Exception();
        }
    }

    public List<Contact> searchByName(String name) {
        List<Contact> contactsByName = null;
        if (name.isEmpty()) {
            contactsByName = this.contacts;
        } else {
            contactsByName = this.contacts
                    .stream()
                    .filter(contact -> contact.getName().toLowerCase().startsWith(name.toLowerCase()))
                    .collect(Collectors.toList());
        }
        return contactsByName;
    }

    public List<Contact> searchByOrganisation(String name) {
        List<Contact> contactsByOrganisation = null;
        if (name.isEmpty()) {
            contactsByOrganisation = this.contacts;
        } else {
            contactsByOrganisation = this.contacts
                    .stream()
                    .filter(contact -> contact.getOrganisation().toLowerCase().startsWith(name.toLowerCase()))
                    .collect(Collectors.toList());
        }
        return contactsByOrganisation;
    }

    // to get the contact from list
    private Contact getContactByName(String name) {
        Contact currentContact = null;
        for (Contact contact : this.contacts) {
            if (contact.getName().equalsIgnoreCase(name))
                currentContact = contact;
        }
        return currentContact;
    }

    // to check if the contact with name already present
    private boolean isAlreadyPresent(String name) {
        boolean isPresent = false;
        for (Contact contact : this.contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }
}
