package jpa.coupon.system.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import jpa.coupon.system.beans.Coupon;
import jpa.coupon.system.beans.Customer;
import jpa.coupon.system.myExceptions.CouponNotFoundException;
import jpa.coupon.system.myExceptions.CustomerExistException;
import jpa.coupon.system.myExceptions.CustomerNotFoundException;

@Service
public interface CustomerDAO {

	/***
	 * Creating new Customer
	 * 
	 * @param customer
	 */
	void create(Customer customer) throws CustomerExistException;

	/***
	 * Removing Customer by ID
	 * 
	 * @param customerId
	 */
	public void delete(int customerId) throws CustomerNotFoundException;

	/***
	 * Updating Customer set only password by ID
	 * 
	 * @param password
	 * @param customerId
	 */
	public void update(String password, int customerId) throws CustomerNotFoundException;

	/***
	 * Get Customer by ID
	 * 
	 * @param customerId
	 * @return Customer
	 */
	public Customer read(int customerId) throws CustomerNotFoundException;

	/***
	 * Get all Customers
	 * 
	 * @return ArrayList<Customer>
	 */
	public ArrayList<Customer> getAllCustomers() throws CustomerNotFoundException;

	/***
	 * Get all Customer's Coupons
	 * 
	 * @param customerId
	 * @return ArrayList<Coupon>
	 */
	public ArrayList<Coupon> getCoupons(int customerId) throws CustomerNotFoundException, CouponNotFoundException;

	/***
	 * Login method for Customers
	 * 
	 * @param custName
	 * @param password
	 * @return true if exist
	 */
	public boolean login(String custName, String password);

}
