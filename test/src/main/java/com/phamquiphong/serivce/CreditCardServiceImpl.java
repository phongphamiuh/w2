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
import com.phamquiphong.repository.CreditCardRepository;
import com.phamquiphong.repository.PersonRepositiry;

@Service
public class CreditCardServiceImpl implements CreditCardService {
	
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired 
    private PersonRepositiry personRepo;
    
    @Override
	public CreditCard getCreditCard(int theId)
	{
	     return creditCardRepository
	    		 .findById(theId)
	    		 .get();
	}
    
    @Override
    public void saveCreditCard(CreditCard card, int personId)
    {
    	card.setPerson(personRepo.findById(personId).get());
    	creditCardRepository.save(card);
    }
    
    @Override
    public void updateCreditCard(CreditCard card, int personId)
    {
    	card.setPerson(personRepo.findById(personId).get());
    	creditCardRepository.save(card);
    }
    
    @Override
    public void deleteCreditCard(int id)
    {
    	creditCardRepository.deleteCreditCardWithId(id);
    }
    
   
}
