package com.phamquiphong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phamquiphong.entity.Person;
import com.phamquiphong.serivce.PersonService;

@RestController
@RequestMapping("/rest/person")
public class PersonRestController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/{id}")
	public Person getPerson(@PathVariable int id) {
		return personService.getPerson(id);
	}
	
	@PostMapping
	public Person getPerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	@PutMapping
	public Person putPerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	@DeleteMapping("/{id}")
	public String deletePerson(@PathVariable int id) {
		personService.deletePerson(id);
		return "Delete person " + id;
	}
	
}
