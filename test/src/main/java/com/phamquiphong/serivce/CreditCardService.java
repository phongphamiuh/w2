/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phamquiphong.serivce;
import com.phamquiphong.entity.CreditCard;

public interface CreditCardService {
	
    public CreditCard getCreditCard(int id);
    
    public void saveCreditCard(CreditCard card, int personId);
    
    public void updateCreditCard(CreditCard card, int personId);
    
    public void deleteCreditCard(int id);    
  
}
