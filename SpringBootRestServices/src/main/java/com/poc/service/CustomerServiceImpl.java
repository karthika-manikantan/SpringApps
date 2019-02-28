/**
 * 
 */
package com.poc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.dao.CustomerDAO;
import com.poc.model.Customer;

/**
 * @author karthika.manikantan
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	/* (non-Javadoc)
	 * @see com.poc.service.CustomerService#getAllCustomerDetails()
	 */
	@Autowired
	CustomerDAO customerDAO;
	@Override
	public List<Customer> getAllCustomerDetails() {
		// TODO Auto-generated method stub
		return customerDAO.getAllCustomerDetails();
	}

	/* (non-Javadoc)
	 * @see com.poc.service.CustomerService#getCustomerById(int)
	 */
	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomerById(id);
	}

	/* (non-Javadoc)
	 * @see com.poc.service.CustomerService#addCustomer(com.poc.model.Customer)
	 */
	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.addCustomer(customer);
	}

	/* (non-Javadoc)
	 * @see com.poc.service.CustomerService#updateCustomer(com.poc.model.Customer)
	 */
	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.updateCustomer(customer);
	}

	/* (non-Javadoc)
	 * @see com.poc.service.CustomerService#deleteCustomer(int)
	 */
	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return customerDAO.deleteCustomer(id);
	}

}
