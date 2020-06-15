package com.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.a.model.Contact;
import com.a.service.ContactService;


@Controller
public class ContactController {
	@Autowired
	ContactService service;

	@RequestMapping(value = "/list-contacts", method = RequestMethod.GET)
	public String showContacts(ModelMap model) {
		model.put("contacts", service.retrieveContacts());
		return "list-contacts";
	}

	@RequestMapping(value = "/delete-contact", method = RequestMethod.GET)
	public String deleteContact(@RequestParam int id) throws Exception {
		 Contact contact =  service.retrieveContact(id);
		 System.out.println("id = "+id);
		 if(contact.getId() <= 0)
	            throw new Exception("Could not find contact with id- " + id);

		service.deleteContact(id);

		return "redirect:/list-contacts";
	}

	@GetMapping(path = "/update-contact/{id}")
	public String showUpdateTodoPage(@PathVariable int id, ModelMap model) throws Exception {
		Contact contact = service.retrieveContact(id);
		model.put("contact", contact);
		return "contact";
	}
	@RequestMapping(value = "/update-contact/{id}", method = RequestMethod.POST)
	public String updateContact(Contact contact, @PathVariable int id, ModelMap model) throws Exception {
		contact = service.updateContact(id,contact);
		model.put("contact", contact);
		return "redirect:/list-contacts";
	}


	@RequestMapping(value = "/add-contact", method = RequestMethod.POST)
	public String addContact(ModelMap model, Contact contact) {

		service.addContact(contact);
		return "redirect:/list-contacts";
	}
	@RequestMapping(value = "/add-contact", method = RequestMethod.GET)
	public String showAddContactPage(ModelMap model) {

		model.addAttribute("contact", new Contact("", "", "", "", ""));
		return "contact";
	}
}