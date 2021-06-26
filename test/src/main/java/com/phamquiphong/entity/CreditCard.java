/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phamquiphong.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Credit_Card")
public class CreditCard {
	
	 @Id
	 @Column(name = "id")
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer id;
	  
	 @Column(name = "type")
	 private String type;
	 
	 @Column(name = "number")
	 private String number;
	 
	 @ManyToOne(optional = false)
	 @JoinColumn(name = "person_id")
	 Person person;
	
	 public Integer getId() {
	  return id;
	 }
	
	 public void setId(Integer id) {
	  this.id = id;
	 }
	
	 public String getType() {
	  return type;
	 }
	
	 public void setType(String type) {
	  this.type = type;
	 }
	
	 public String getNumber() {
	  return number;
	 }
	
	 public void setNumber(String number) {
	  this.number = number;
	 }

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	 
}
