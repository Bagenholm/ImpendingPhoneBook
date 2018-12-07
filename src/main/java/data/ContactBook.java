package data;

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
