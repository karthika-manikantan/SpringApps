/**
 * 
 */
package com.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.model.Customer;
import com.poc.service.CustomerService;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * @author karthika.manikantan
 *
 */
@RestController
@RequestMapping(value="/customerInfo")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@ResponseBody
	@RequestMapping(value="/customers", method=RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Customer> getAllCustomers(){
		
		List<Customer> customerList = customerService.getAllCustomerDetails();
		return customerList;
	}
	
	@ResponseBody
	@RequestMapping(value="/customer/{id}", method=RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public Customer getCustomerById(@PathVariable("id") int id){
		
		Customer customer = customerService.getCustomerById(id);
		return customer;
	}
	
	@RequestMapping(value="/addCustomer", method=RequestMethod.POST,  consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public Customer addCustomer(@RequestBody Customer customer){
		
		System.out.println("Creating Employee in back end : " +customer.getName());
		return customerService.addCustomer(customer);
	}
	
	@ResponseBody
	@RequestMapping(value="/updateCustomer", method=RequestMethod.PUT,  produces={ MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public Customer updateCustomer(@RequestBody Customer customer){
		
		System.out.println("Updating Customer : "+customer.getName());
		return customerService.updateCustomer(customer);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteCustomer/{id}", method=RequestMethod.DELETE,  produces= MediaType.TEXT_EVENT_STREAM_VALUE)
	public String deleteCustomer(@PathVariable("id") int id){
		
		System.out.println("Deleting Customer : "+id);
		boolean result = customerService.deleteCustomer(id);
		if(result)
			return "Deleted Customer Details..!!!"+id;
		return "Not Deleted..!!"+id;
		}
}
