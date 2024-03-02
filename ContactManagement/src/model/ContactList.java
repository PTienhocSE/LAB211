/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author phuct
 */
public class ContactList {
    private ArrayList<Contact> contactList = new ArrayList<>();

    public ContactList() {
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    public void removeContact(Contact contact) {
        contactList.remove(contact);
    }

    public Contact getContactById(int id) {
        for (Contact contact : contactList) {
            if (contact.getContactId() == id) {
                return contact;
            }
        }
        return null;
    }
}

