package com.a.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a.model.Contact;
import com.a.repository.ContactRepository;

@Service
public class ContactService {
	    @Autowired
		ContactRepository repository;

	    public List<Contact> retrieveContacts() {
	        return (List<Contact>) repository.findAll();
	    }

	    public Contact retrieveContact(int id) throws Exception {

	    	Optional<Contact> contact =repository.findById(id);
	        if(!contact.isPresent())
	            throw new Exception("Could not find contact with id- " + id);

	        return contact.get();
	    }

	    public Contact updateContact(int id, Contact contactUpdate) throws Exception{
	        System.out.println(this.getClass().getSimpleName() + " - Update employee details by id is invoked.");

	        Optional<Contact> contact =  repository.findById(id);
	        if (!contact.isPresent())
	            throw new Exception("Could not find contact with id- " + id);

	        if(contactUpdate.getFirstName() == null || contactUpdate.getFirstName().isEmpty())
	        	contactUpdate.setFirstName(contact.get().getFirstName());
	        if(contactUpdate.getLastName() == null || contactUpdate.getLastName().isEmpty())
	        	contactUpdate.setLastName(contact.get().getLastName());
	        if(contactUpdate.getPhone() == null || contactUpdate.getPhone().isEmpty())
	        	contactUpdate.setPhone(contact.get().getPhone());
	        if(contactUpdate.getEmail() == null || contactUpdate.getEmail().isEmpty())
	        	contactUpdate.setEmail(contact.get().getEmail());
	        if(contactUpdate.getStatus() == null || contactUpdate.getStatus().isEmpty())
	        	contactUpdate.setStatus(contact.get().getStatus());

	        contactUpdate.setId(id);
	        return repository.save(contactUpdate);
	    }

	    public Contact addContact(Contact contactUpdate) {
	    	contactUpdate.setStatus("Active");
	    	return repository.save(contactUpdate);
	    }

	    public void deleteContact(int id) throws Exception {
	    	Contact contact = retrieveContact(id);
	    	contact.setStatus("Inactive");
	    	updateContact(id, contact);
	    }
}
