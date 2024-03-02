/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phuct
 */
public class Contact {
    private int contactId;
    private String fullName;
    private String firstName;
    private String lastName;
    private String group;
    private String address;
    private String phone;

    public Contact() {
    }

    public Contact(int contactId, String fullName, String firstName, String lastName, String group, String address, String phone) {
        this.contactId = contactId;
        this.fullName = fullName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "contact{" + "contactId=" + contactId + ", fullName=" + fullName + ", firstName=" + firstName + ", lastName=" + lastName + ", group=" + group + ", address=" + address + ", phone=" + phone + '}';
    }
    
    
}
