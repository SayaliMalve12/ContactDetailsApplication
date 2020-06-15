package com.a.repository;

import org.springframework.data.repository.CrudRepository;

import com.a.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
