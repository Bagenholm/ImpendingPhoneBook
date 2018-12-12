package util;

import data.Contact;

import java.util.List;
import java.util.stream.Collectors;

public class ContactFinder {

    public List<Contact> searchByName(String name, Handler handler){
        List<Contact> searchResults;
       searchResults = handler.contactBook.getContactList().stream()
               .filter(contact -> contact.getName().contains(name)).collect(Collectors.toList());
       return searchResults;
    }

    public List<Contact> searchByEmail(String email, Handler handler){
        List<Contact> searchResults;
        searchResults = handler.contactBook.getContactList().stream()
                .filter(contact -> contact.getEmail().contains(email)).collect(Collectors.toList());
        return searchResults;
    }

    public List<Contact> searchByAddress(String address, Handler handler){
        List<Contact> searchResults;
        searchResults = handler.contactBook.getContactList().stream()
                .filter(contact -> contact.getEmail().contains(address)).collect(Collectors.toList());
        return searchResults;
    }

    public List<Contact> searchByNote(String note, Handler handler){
        List<Contact> searchResults;
        searchResults = handler.contactBook.getContactList().stream()
                .filter(contact -> contact.getNote().contains(note)).collect(Collectors.toList());
        return searchResults;
    }

    public List<Contact> searchByBirthDate(String date, Handler handler){
        List<Contact> searchResults;
        searchResults = handler.contactBook.getContactList().stream()
                .filter(contact -> contact.getBirthDate().toString().contains(date)).collect(Collectors.toList());
        return searchResults;
    }

    public List<Contact> searchByPhoneNumber(String number, Handler handler){
        List<Contact> searchResults;
        searchResults = handler.contactBook.getContactList().stream()
                .filter(contact -> contact.getEmail().contains(number)).collect(Collectors.toList());
        return searchResults;
    }

    public List<Contact> searchByAny(String any, Handler handler){
        List<Contact> searchResults;
        searchResults = handler.contactBook.getContactList().stream()
                .filter(contact -> contact.info().contains(any)).collect(Collectors.toList());
        return searchResults;
    }

}
