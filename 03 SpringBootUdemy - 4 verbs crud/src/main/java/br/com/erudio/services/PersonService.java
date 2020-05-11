package br.com.erudio.services;

import java.awt.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();
	
	public Person findByID(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Ciro");
		person.setLastName("Teixeira");
		person.setAddress("Alverca do Ribatejo");
		person.setGender("Male");
		
		return person;
	}
	
	public ArrayList<Person> findAll(){
		ArrayList<Person> list = new ArrayList<Person>();
		
		for(int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			list.add(person);
		}
		
		return list;
	}
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
		
	}
	
	public Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Name " + i);
		person.setLastName("Lastname " + i);
		person.setAddress("Somewher in Portugal " + i);
		person.setGender("Male");
		
		return person;
	}
	
}
