/**
 * 
 */
package com.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author karthika.manikantan
 *
 */
@Entity
@Table(name="customer")
public class Customer {



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="customer_name")
	private String name;
	@Column(name="customer_email")
	private String email;
	@Column(name="customer_address")
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
}
