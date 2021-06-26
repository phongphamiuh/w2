/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.onetomany.controller;

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
import com.se.onetomany.service.PersonService;
import com.se.onetomany.service.CreditCardService;
import com.se.onetomany.entity.Person;
import com.se.onetomany.entity.CreditCard;
import java.util.List;

@Controller
@RequestMapping("/creditcard")
public class CreditCardController {
     @Autowired
    // need to inject our customer service
    private CreditCardService creditCardService;
     @PostMapping("/saveCard")
    public String saveCreditCard(@ModelAttribute("creditCardAttribute") CreditCard theCard, 
            @RequestParam("personId") int personId) {
        // save the customer using our service
        creditCardService.saveCreditCard(theCard, personId);	
        return "redirect:/person/list";
    }
    @PostMapping("/updateCard")
    public String updateCreditCard(@ModelAttribute("creditCardAttribute") CreditCard theCard,
            @RequestParam("personId") int personId)
    {
        // save the customer using our service
        creditCardService.updateCreditCard(theCard, personId);	
        return "redirect:/person/list";
    }
     @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel, @RequestParam("personId") int personId) {
        // create model attribute to bind form data
        CreditCard theCard = new CreditCard();
        theModel.addAttribute("creditCardAttribute", theCard);
        theModel.addAttribute("personId", personId);
        theModel.addAttribute("isUpdate", false);
        return "credit-form";    }  
    
     @GetMapping("/showFormForUpdate")
   public String showFormForUpdate(   @RequestParam("personId") int personId,
           @RequestParam("creditCardId") int creditCardId,
           Model theModel) {
        // get the creditcard from our service
        CreditCard theCreditCard = creditCardService.getCreditCard(creditCardId);
        // set creditcard as a model attribute to pre-populate the form
        theModel.addAttribute("creditCardAttribute", theCreditCard);
         theModel.addAttribute("personId", personId);
        theModel.addAttribute("isUpdate", true);
        
        
        // send over to our form		
        return "credit-form";    }  
      @GetMapping("/delete")
    public String deleteCreditCard(@RequestParam("creditCardId") int theId) {

            // delete the customer
            creditCardService.deleteCreditCard(theId);

            return "redirect:/person/list";
    }
}
