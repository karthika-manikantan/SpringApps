/**
 * 
 */
package com.poc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poc.model.Customer;

/**
 * @author karthika.manikantan
 *
 */
@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

	/* (non-Javadoc)
	 * @see com.poc.dao.CustomerDAO#getAllCustomerDetails()
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomerDetails() {
		
		List<Customer> customerList = new ArrayList<Customer>();
		Query query = getSession().createQuery("FROM Customer");
		customerList = query.list();
		return customerList;
	}

	/* (non-Javadoc)
	 * @see com.poc.dao.CustomerDAO#getCustomerById(int)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		Customer customer = getSession().get(Customer.class, id);
		System.out.println("Customer by ID : " +customer.getName());
		return customer;
	}

	/* (non-Javadoc)
	 * @see com.poc.dao.CustomerDAO#addCustomer(com.poc.model.Customer)
	 */
	@SuppressWarnings("unused")
	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		getSession().save(customer);
		return customer;
	}

	/* (non-Javadoc)
	 * @see com.poc.dao.CustomerDAO#updateCustomer(com.poc.model.Customer)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		String hql = "UPDATE Customer SET name = :custName , email = :custEmail , address = :custAddr WHERE id = :custId";
		Query query = getSession().createQuery(hql);
		query.setParameter("custName", customer.getName());
		query.setParameter("custEmail", customer.getEmail());
		query.setParameter("custAddr", customer.getAddress());
		query.setParameter("custId", customer.getId());
		int result = query.executeUpdate();
		if(result > 0)
			return customer;
		return null;
	}

	/* (non-Javadoc)
	 * @see com.poc.dao.CustomerDAO#deleteCustomer(int)
	 */
	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		String hql = "DELETE FROM Customer WHERE id = :custId";
		Query query = getSession().createQuery(hql);
		query.setParameter("custId", id);
		int result = query.executeUpdate();
		if(result > 0)
			return true;
		return false;
	}

}
