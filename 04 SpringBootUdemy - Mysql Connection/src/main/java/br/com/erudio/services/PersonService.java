package br.com.erudio.services;

import java.awt.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	PersonRepository rep;
	
	public ArrayList<Person> findAll(){
		return (ArrayList<Person>) rep.findAll();
	}
	
	public Person create(Person person) {
		return rep.save(person);
	}
	
	public Person findByID(Long id) {
		return rep.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records for this ID"));
	}
	
	public Person update(Person person) {
		Person entity = rep.findById(person.getId()).orElseThrow(() 
				-> new ResourceNotFoundException("No records for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return rep.save(entity);
	}
	
	public void delete(Long id) {
		Person entity = rep.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("No records for this ID"));
		rep.delete(entity);
	}
	
	
}
