import java.util.List;

public class ContactBook {


    private List<Contact> contactList;

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
}
