package jpa.coupon.system.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.coupon.system.beans.Coupon;
import jpa.coupon.system.beans.Customer;
import jpa.coupon.system.myExceptions.CouponNotFoundException;
import jpa.coupon.system.myExceptions.CustomerExistException;
import jpa.coupon.system.myExceptions.CustomerNotFoundException;

@Service
public class CustomerDBDAO implements CustomerDAO {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	CouponRepository couponRepo;

	/***
	 * Creating new Customer
	 * 
	 * @param customer
	 */
	@Override
	public void create(Customer customer) throws CustomerExistException {
		customerRepo.save(customer);
	}

	/***
	 * Removing Customer by ID
	 * 
	 * @param customerId
	 */
	@Override
	public void delete(int customerId) throws CustomerNotFoundException {
		customerRepo.deleteById(customerId);
	}

	/***
	 * Updating Customer set only password by ID
	 * 
	 * @param password
	 * @param customerId
	 */
	@Override
	public void update(String password, int customerId) throws CustomerNotFoundException {
		customerRepo.update(password, customerId);

	}

	/***
	 * Get Customer by ID
	 * 
	 * @param customerId
	 * @return Customer
	 */
	@Override
	public Customer read(int customerId) throws CustomerNotFoundException {
		return customerRepo.findById(customerId);
	}

	/***
	 * Get all Customers
	 * 
	 * @return ArrayList<Customer>
	 */
	@Override
	public ArrayList<Customer> getAllCustomers() throws CustomerNotFoundException {
		return (ArrayList<Customer>) customerRepo.findAll();
	}

	/***
	 * Get all Customer's Coupons
	 * 
	 * @param customerId
	 * @return ArrayList<Coupon>
	 */
	@Override
	public ArrayList<Coupon> getCoupons(int customerId) throws CustomerNotFoundException, CouponNotFoundException {
		return couponRepo.findCustomerCoupons(customerId);
	}

	/**
	 * Get customer by name and password
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	public Customer getCustomerByNameAndPassword(String name, String password) throws CustomerNotFoundException {
		return customerRepo.findByNameAndPassword(name, password);
	}

	/**
	 * Get customer by name
	 * 
	 * @param name
	 * @return customer
	 */
	public Customer getCustomerByName(String name) throws CustomerExistException {
		return customerRepo.findByName(name);
	}

	/**
	 * Customer purchase. Adding a coupon to customer.
	 * 
	 * @param couponId
	 * @param customerId
	 */
	public void purchaseCoupon(int couponId, int customerId) throws CustomerNotFoundException, CouponNotFoundException {
		customerRepo.insertCustomerCoupon(couponId, customerId);
		couponRepo.decreaseAmount(couponId);
	}

	/***
	 * Login method for Customers
	 * 
	 * @param custName
	 * @param password
	 * @return true if exist
	 */
	@Override
	public boolean login(String custName, String password) {
		Optional<Customer> checkObject = Optional.ofNullable(customerRepo.findByNameAndPassword(custName, password));
		if (checkObject.isPresent())
			return true;
		return false;
	}

}
