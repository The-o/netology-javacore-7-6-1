package ru.netology.pyas.missedcalls;

public class Contact {

    private String firstname;

    private String lastname;

    private String phone;

    private ContactGroup group;

    public Contact(String phone) {
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public ContactGroup getGroup() {
        return group;
    }

    public void setGroup(ContactGroup group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return String.format("%s %s", lastname, firstname);
    }

}
