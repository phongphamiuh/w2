/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phamquiphong.controller;
import java.util.List;

/**
 *
 * @author TriPham
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phamquiphong.entity.CreditCard;
import com.phamquiphong.entity.Person;
import com.phamquiphong.serivce.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	
    @Autowired
    private PersonService personService;
    
    @PostMapping("/save")
    public String savePerson(@ModelAttribute("person") Person person) { 

        personService.savePerson(person);	
        return "redirect:/person/list";
    }

    @GetMapping("/updateForm")
    public String updateForm(@RequestParam("personId") int id,
                    Model model) {
        Person person = personService.getPerson(id);	
        model.addAttribute("person", person);	
        return "person-form";    
     }

    @GetMapping("/saveForm")
    public String saveForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "person-form";       
    }  
     
    @GetMapping("/delete")
    public String deletePerson(@RequestParam("personId") int id) {
            personService.deletePerson(id);
            return "redirect:/person/list";
    }
    
    @GetMapping("/list")
    public String listPersons(Model model) {
        List<Person> person = personService.getPersons();
        model.addAttribute("persons", person);
        return "list-persons";
    }
    
}
