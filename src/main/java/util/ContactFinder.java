package util;

import data.Contact;

import java.util.List;
import java.util.stream.Collectors;

public class ContactFinder {


    Handler handler;

    public ContactFinder(Handler handler) {
        this.handler = handler;
    }

    public Contact selectContact(List<Contact> list){
        if(list.size() == 1){
            return list.get(0);
        }else{
            for (int i = 0; i < list.size() ; i++) {
                System.out.println("[" + i + "]" + list.get(i).toString());
            }
            System.out.println("Please choose an index");
            return list.get(handler.input.verifyInt(0,list.size()));
        }
    }

    public List<Contact> searchByName(String name){
        List<Contact> searchResults;
       searchResults = handler.contactBook.getContactList().stream()
               .filter(contact -> contact.getName().contains(name)).collect(Collectors.toList());
       return searchResults;
    }

    public List<Contact> searchByEmail(String email){
        List<Contact> searchResults;
        searchResults = handler.contactBook.getContactList().stream()
                .filter(contact -> contact.getEmail().contains(email)).collect(Collectors.toList());
        return searchResults;
    }

    public List<Contact> searchByAddress(String address){
        List<Contact> searchResults;
        searchResults = handler.contactBook.getContactList().stream()
                .filter(contact -> contact.getAddress().contains(address)).collect(Collectors.toList());
        return searchResults;
    }

    public List<Contact> searchByNote(String note){
        List<Contact> searchResults;
        searchResults = handler.contactBook.getContactList().stream()
                .filter(contact -> contact.getNote().contains(note)).collect(Collectors.toList());
        return searchResults;
    }

    public List<Contact> searchByBirthDate(String date){
        List<Contact> searchResults;
        searchResults = handler.contactBook.getContactList().stream()
                .filter(contact -> contact.getBirthDate().toString().contains(date)).collect(Collectors.toList());
        return searchResults;
    }

    public List<Contact> searchByPhoneNumber(String number){
        List<Contact> searchResults;
        searchResults = handler.contactBook.getContactList().stream()
                .filter(contact -> contact.getNumber().contains(number)).collect(Collectors.toList());
        return searchResults;
    }

    public List<Contact> searchByAny(String any){
        List<Contact> searchResults;
        searchResults = handler.contactBook.getContactList().stream()
                .filter(contact -> contact.info().contains(any)).collect(Collectors.toList());
        return searchResults;
    }

}
