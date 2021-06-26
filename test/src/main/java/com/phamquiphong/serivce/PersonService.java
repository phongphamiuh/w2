/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phamquiphong.serivce;
import java.util.List;

import com.phamquiphong.entity.CreditCard;
import com.phamquiphong.entity.Person;


public interface PersonService {
    public List<Person> getPersons();
    
    public Person savePerson(Person thePerson);
    
    public Person getPerson(int personId);
    
    public void deletePerson(int personId);
    
    public List<CreditCard> getCreditCards(Integer personId);
    
    public CreditCard getCreditCard(int personId, int creditCardId);
}
