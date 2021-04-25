/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ru.netology.pyas.missedcalls;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    private static final String PHONE = "555 01 55";

    @Test
    public void construct_with_phone() {
        assertDoesNotThrow(() -> new Contact(PHONE));
    }

    @Test
    public void construct_with_null_phone() {
        assertDoesNotThrow(() -> new Contact(null));
    }

    @Test
    public void setFirstname_string() {
        Contact contact = new Contact(PHONE);
        assertDoesNotThrow(() -> contact.setFirstname("First Name"));
    }

    @Test
    public void setFirstname_null() {
        Contact contact = new Contact(PHONE);
        assertDoesNotThrow(() -> contact.setFirstname(null));
    }

    @Test
    public void setLastname_string() {
        Contact contact = new Contact(PHONE);
        assertDoesNotThrow(() -> contact.setLastname("Last Name"));
    }

    @Test
    public void setLastname_null() {
        Contact contact = new Contact(PHONE);
        assertDoesNotThrow(() -> contact.setLastname(null));
    }

    @Test
    public void setGroup_group() {
        Contact contact = new Contact(PHONE);
        assertDoesNotThrow(() -> contact.setGroup(ContactGroup.FAMILY));
    }

    @Test
    public void setGroup_null() {
        Contact contact = new Contact(PHONE);
        assertDoesNotThrow(() -> contact.setGroup(null));
    }

    @Test
    public void getPhone_string() {
        Contact contact = new Contact(PHONE);
        String actual = contact.getPhone();

        assertEquals(PHONE, actual);
    }

    @Test
    public void getPhone_null() {
        Contact contact = new Contact(null);
        String actual = contact.getPhone();

        assertNull(actual);
    }

    @Test
    public void getFirstname_string() {
        String expected = "First Name";

        Contact contact = new Contact(PHONE);
        contact.setFirstname(expected);

        String actual = contact.getFirstname();

        assertEquals(expected, actual);
    }

    @Test
    public void getFirstname_null() {
        Contact contact = new Contact(PHONE);
        contact.setFirstname(null);

        String actual = contact.getFirstname();

        assertNull(actual);
    }

    @Test
    public void getLastname_string() {
        String expected = "Last Name";

        Contact contact = new Contact(PHONE);
        contact.setLastname(expected);

        String actual = contact.getLastname();

        assertEquals(expected, actual);
    }

    @Test
    public void getLastname_null() {
        Contact contact = new Contact(PHONE);
        contact.setLastname(null);

        String actual = contact.getLastname();

        assertNull(actual);
    }

    @Test
    public void getGroup_group() {
        ContactGroup expected = ContactGroup.FRIENDS;

        Contact contact = new Contact(PHONE);
        contact.setGroup(expected);

        ContactGroup actual = contact.getGroup();

        assertEquals(expected, actual);
    }

    @Test
    public void getGroup_null() {
        Contact contact = new Contact(PHONE);
        contact.setGroup(null);

        ContactGroup actual = contact.getGroup();

        assertNull(actual);
    }

    @Test
    public void toString_strings() {
        Contact contact = new Contact(PHONE);
        contact.setFirstname("FirstName");
        contact.setLastname("LastName");

        String expected = "LastName FirstName";
        String actual = contact.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void toString_null() {
        Contact contact = new Contact(PHONE);
        contact.setFirstname(null);
        contact.setLastname(null);

        String expected = "null null";
        String actual = contact.toString();

        assertEquals(expected, actual);
    }
}