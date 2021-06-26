/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phamquiphong.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phamquiphong.entity.CreditCard;
import com.phamquiphong.entity.Person;
import com.phamquiphong.repository.CreditCardRepository;
import com.phamquiphong.repository.PersonRepositiry;

/**
 *
 * @author TriPham
 */
@Service
public class PersonServiceImpl implements PersonService{
	
    @Autowired
    private PersonRepositiry personRepositiry;
    @Autowired
    private CreditCardRepository creditCardRepository;
    
    @Override
    public List<Person> getPersons()
    {
        return personRepositiry.findAll();
    }
   
    @Override
    public Person savePerson(Person thePerson)
    {
    	return personRepositiry.save(thePerson);
    }
    
    @Override
    public Person getPerson(int thePersonId)
    {
        return personRepositiry.findById(thePersonId).get();
    }
    
    @Override
    public void deletePerson(int thePersonId)
    {
    	personRepositiry.deleteById(thePersonId);
    }
    
    @Override
    public List<CreditCard> getCreditCards(Integer thePersonId)
    {
        return creditCardRepository.findAllByPersonId(thePersonId);
    }
    
    @Override
    public CreditCard getCreditCard(int personId, int creditCardId)
    {
        return creditCardRepository.getCreditCardByPersonId(personId, creditCardId);
    }
}
