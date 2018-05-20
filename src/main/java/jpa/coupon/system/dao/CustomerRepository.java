package jpa.coupon.system.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jpa.coupon.system.beans.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	/**
	 * Add a coupon to customer object by customer id & coupon id.
	 * 
	 * @param couponId
	 * @param customerId
	 */
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO customer_coupons (customers_id, coupons_id) VALUES (:customerId, :couponId)", nativeQuery = true)
	void insertCustomerCoupon(@Param("couponId") int couponId, @Param("customerId") int customerId);

	/**
	 * get customer by name && password
	 * 
	 * @param custName
	 * @param password
	 * @return
	 */
	Customer findByNameAndPassword(String custName, String password);

	/**
	 * Get customer by name
	 * 
	 * @param name
	 * @return customer
	 */
	Customer findByName(String name);

	/***
	 * Get Customer by ID
	 * 
	 * @param id
	 * @return
	 */
	Customer findById(int id);

	@Transactional
	@Modifying
	@Query("UPDATE Customer cust SET cust.password = :password WHERE cust.id = :customerId")
	void update(@Param("password") String password, @Param("customerId") int customerId);
}
