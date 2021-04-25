package ru.netology.pyas.missedcalls;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class PhoneCalls {

    public class MissedCall {

        private Contact contact;

        private String phone;

        private LocalDateTime time;

        private MissedCall(Contact contact, String phone, LocalDateTime time) {
            this.contact = contact;
            this.phone = phone;
            this.time = time;
        }

        public Contact getContact() {
            return contact;
        }

        public String getPhone() {
            return phone;
        }

        public LocalDateTime getTime() {
            return time;
        }

        @Override
        public String toString() {
            return String.format("%tF %1$tT %s", time, contact == null ? phone : contact);
        }
    }

    private Map<String, Contact> contacts = new HashMap<>();
    private Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    public void addContact(Contact contact) {
        contacts.put(contact.getPhone(), contact);
    }

    public Contact getContact(String phone) {
        return contacts.get(phone);
    }

    public boolean removeContact(String phone) {
        return contacts.remove(phone) != null;
    }

    public void addMissedCall(LocalDateTime time, String phone) {
        missedCalls.put(time, phone);
    }

    public void clearMissedCalls() {
        missedCalls.clear();
    }

    public Iterator<MissedCall> getMissedCallsIterator() {
        return missedCalls.entrySet()
            .stream().map(
                entry -> new MissedCall(contacts.get(entry.getValue()), entry.getValue(), entry.getKey())
            ).iterator();
    }
}
