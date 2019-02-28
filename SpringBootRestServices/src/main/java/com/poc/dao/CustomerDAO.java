/**
 * 
 */
package com.poc.dao;

import java.util.List;

import com.poc.model.Customer;

/**
 * @author karthika.manikantan
 *
 */
public interface CustomerDAO {

	public List<Customer> getAllCustomerDetails();
	public Customer getCustomerById(int id);
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public boolean deleteCustomer(int id);
}
