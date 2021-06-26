
package com.phamquiphong.entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {
	 @Id
	 @Column(name = "id")
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer id;
	 
	 @Column(name = "first_name")
	 private String firstName;
	 
	 @Column(name = "last_name")
	 private String lastName;
	 
	 @Column(name = "money")
	 private Double money;
	 
	 @OneToMany(mappedBy = "person",fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	 private List<CreditCard> creditCards;
	 
	 public Integer getId() {
	  return id;
	 }
	
	 public void setId(Integer id) {
	  this.id = id;
	 }
	
	 public String getFirstName() {
	  return firstName;
	 }
	
	 public void setFirstName(String firstName) {
	  this.firstName = firstName;
	 }
	
	 public String getLastName() {
	  return lastName;
	 }
	
	 public void setLastName(String lastName) {
	  this.lastName = lastName;
	 }
	
	 public Double getMoney() {
	  return money;
	 }
	
	 public void setMoney(Double money) {
	  this.money = money;
	 }
	
	 public List<CreditCard> getCreditCards() {
	  return creditCards;
	 }

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}	
	 
}
