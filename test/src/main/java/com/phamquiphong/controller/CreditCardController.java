package com.phamquiphong.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phamquiphong.entity.CreditCard;
import com.phamquiphong.serivce.CreditCardService;

@Controller
@RequestMapping("/creditcard")
public class CreditCardController {
	
   @Autowired
   private CreditCardService creditCardService;
   
   @PostMapping("/save")
   public String saveCreditCard(@ModelAttribute("creditCard") CreditCard theCard, 
            @RequestParam("personId") int personId) {
        creditCardService.saveCreditCard(theCard, personId);	
        return "redirect:/person/list";
   }
   
   @PostMapping("/update")
   public String updateCreditCard(@ModelAttribute("creditCard") CreditCard creditCard,int personId)
   {
        creditCardService.updateCreditCard(creditCard,personId);	
        return "redirect:/person/list";
   }
   
   @GetMapping("/saveForm")
   public String showFormForAdd(Model model, @RequestParam("personId") int personId) {
        CreditCard creditCard = new CreditCard();
        model.addAttribute("creditCard", creditCard);
        model.addAttribute("personId", personId);
        model.addAttribute("isUpdate", false);
        return "credit-form";    
   }  
    
   @GetMapping("/updateForm")
   public String showFormForUpdate(@RequestParam("creditCardId") int creditCardId,
           Model model) {
        CreditCard creditCard = creditCardService.getCreditCard(creditCardId);         
        model.addAttribute("creditCard", creditCard);
        model.addAttribute("personId", creditCard.getPerson().getId());
        model.addAttribute("isUpdate", true);          
        return "credit-form";    
    }  
   
    @GetMapping("/delete")
    public String deleteCreditCard(@RequestParam("creditCardId") int id) {
        creditCardService.deleteCreditCard(id);
        return "redirect:/person/list";
    }
    
}
