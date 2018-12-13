package data;

import util.Handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactBook {


    private List<Contact> contactList;


    public ContactBook() {
        contactList = new ArrayList<>();
    }

    public ContactBook(List<Contact> contactList) {
        if (contactList!=null)
        this.contactList = contactList;
        else {
            throw new IllegalArgumentException("Null not accepted as input parameter");
        }
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }


    /**
     * Add method which checks for duplicates and that contact is not null.
     */

    public void add(Contact contact) {

        if (contact != null) {

            if (getContactList().stream().anyMatch(contact1 -> contact1.equals(contact))) {
                System.out.println("Duplicate contact found. Do you really want to add contact? (1) Yes (2) No");
                int result = new Handler().input.verifyInt(1, 2);
                if (result == 1) {
                    getContactList().add(contact);
                }
            } else {
                getContactList().add(contact);
            }
        } else {
            System.out.println("No contact selected, no contact added");
        }

    }

    /**
     * Null proof size method
     */
    public int size() {
        if(getContactList()!=null) {
            return getContactList().size();
        }
        else
            return 0;
    }


    @Override
    public String toString() {
        return "ContactBook{" +
                "contactList=" + contactList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactBook that = (ContactBook) o;
        return Objects.equals(contactList, that.contactList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactList);
    }
}
