package jpa.coupon.system.facades;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jpa.coupon.system.beans.Coupon;
import jpa.coupon.system.beans.Customer;
import jpa.coupon.system.dao.CouponDBDAO;
import jpa.coupon.system.dao.CustomerDBDAO;
import jpa.coupon.system.general.Clients;
import jpa.coupon.system.myExceptions.CouponExistException;
import jpa.coupon.system.myExceptions.CouponNotFoundException;
import jpa.coupon.system.myExceptions.CustomerNotFoundException;

@Component
public class CustomerFacade implements CouponClientFacade {

	/////////////////////////////////////////////////////////////////////
	// TODO methods ByType() && ByPrice() ByDate()
	/////////////////////////////////////////////////////////////////////

	@Autowired
	CustomerDBDAO customerQueries;

	@Autowired
	CouponDBDAO couponQueries;

	private Customer loginCustomer;

	/**
	 * This method checks whether the given login information is valid. If the
	 * login information is correct - the method configure the logged-in
	 * customer to this facade and return this facade.
	 * 
	 * @return if the information is valid the method return the facade.
	 *         Otherwise, returns null.
	 */
	@Override
	public CouponClientFacade login(String name, String password, Clients type) throws CustomerNotFoundException {
		Optional<Customer> checkCustomer = null;
		if (type == Clients.CUSTOMER)
			checkCustomer = Optional.ofNullable(customerQueries.getCustomerByNameAndPassword(name, password));
		else
			throw new CustomerNotFoundException("The client type should be customer.");
		checkCustomer = Optional.ofNullable(customerQueries.getCustomerByNameAndPassword(name, password));

		if (checkCustomer.isPresent()) {
			loginCustomer = checkCustomer.get();
			return this;
		} else
			throw new CustomerNotFoundException(
					"At least one of the parameters(name or password) is not correct. Customer not found");
	}

	/**
	 * Get logging customer details
	 * 
	 * @return customer
	 */
	public Customer getLoginCustomer() {
		return loginCustomer;
	}

	/**
	 * Purchase Coupon if it exist on Coupon's table && customer didn't
	 * purchased it yet
	 * 
	 * @param coupon
	 * @throws CustomerNotFoundException
	 * @throws CouponNotFoundException
	 * @throws CouponExistException
	 */
	public void purchaseCoupon(Coupon coupon)
			throws CustomerNotFoundException, CouponNotFoundException, CouponExistException {
		if (loginCustomer == null)
			throw new CustomerNotFoundException("Customer is not logged in");

		Optional<Coupon> coup = Optional.ofNullable(couponQueries.read(coupon.getId()));
		if (!coup.isPresent())
			throw new CouponNotFoundException("The coupon does not exist");
		Optional<Coupon> duplicateCoupon = Optional
				.ofNullable(couponQueries.getCouponByCustomerId(coupon.getId(), loginCustomer.getId()));
		if (duplicateCoupon.isPresent())
			throw new CouponExistException("The customer " + loginCustomer.getName() + " already have the coupon: "
					+ duplicateCoupon.get().getTitle());
		if (coup.get().getAmount() > 0)
			customerQueries.purchaseCoupon(coupon.getId(), loginCustomer.getId());
		else
			throw new CouponExistException("The coupon is run out.");
	}

	/**
	 * Get all customer's purchased coupons
	 * 
	 * @return ArrayList
	 * @throws CustomerNotFoundException
	 * @throws CouponNotFoundException
	 */
	public ArrayList<Coupon> getAllPurchasedCoupon() throws CustomerNotFoundException, CouponNotFoundException {

		if (loginCustomer == null)
			throw new CustomerNotFoundException("Customer is not logged in");

		ArrayList<Coupon> purchasedCoupons = new ArrayList<>();
		purchasedCoupons = customerQueries.getCoupons(loginCustomer.getId());
		if (purchasedCoupons.isEmpty() || purchasedCoupons == null)
			throw new CouponNotFoundException("There are no coupons for the customer: " + loginCustomer.getName());
		return purchasedCoupons;
	}

	/**
	 * Get All coupons from the Database.
	 * 
	 * @return ArrayList
	 * @throws CustomerNotFoundException
	 * @throws CouponNotFoundException
	 */
	public ArrayList<Coupon> getAllCouponsInDatabase() throws CustomerNotFoundException, CouponNotFoundException {
		if (loginCustomer == null)
			throw new CustomerNotFoundException("Customer is not logged in");
		ArrayList<Coupon> allCoupons = couponQueries.getAllCouponsIn_DB();
		if (allCoupons.isEmpty() || allCoupons == null)
			throw new CouponNotFoundException("There are no coupons in the system");
		return allCoupons;
	}

}
