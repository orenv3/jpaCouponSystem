package jpa.coupon.system.dao;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import jpa.coupon.system.beans.Coupon;
import jpa.coupon.system.general.CouponType;
import jpa.coupon.system.myExceptions.CompanyNotFoundException;
import jpa.coupon.system.myExceptions.CouponExistException;
import jpa.coupon.system.myExceptions.CouponNotFoundException;
import jpa.coupon.system.myExceptions.CustomerNotFoundException;

@Service
public interface CouponDAO {

	/**
	 * Creating new Coupon by its Company(owner).
	 * 
	 * @param coupon
	 *            coupon object to create.
	 * @param companyId
	 *            id of the company that owns this coupon.
	 * @throws CouponExistException
	 * @throws CompanyNotFoundException
	 */
	void create(Coupon coupon, int companyId) throws CouponExistException, CompanyNotFoundException;

	/**
	 * Removing Coupon by its Company
	 * 
	 * @param couponId
	 * @param companyId
	 * @throws CouponNotFoundException
	 * @throws CompanyNotFoundException
	 */
	void delete(int couponId, int companyId) throws CouponNotFoundException, CompanyNotFoundException;

	/**
	 * Update Coupon object. Setting only 5 values: endDate, price, amount,
	 * image, message. find the object by id of the coupon & its Company.
	 * 
	 * @param endDate
	 * @param price
	 * @param amount
	 * @param image
	 * @param message
	 * @param couponId
	 * @param companyId
	 * @throws CouponNotFoundException
	 * @throws CompanyNotFoundException
	 */
	void update(Date endDate, double price, int amount, String image, String message, int couponId, int companyId)
			throws CouponNotFoundException, CompanyNotFoundException;

	/**
	 * Get Coupon by ID
	 * 
	 * @param couponId
	 * @return Optional<Coupon> Optional Coupon object.
	 * @throws CouponNotFoundException
	 */
	Coupon read(int couponId) throws CouponNotFoundException;

	/***
	 * Get all company coupons
	 * 
	 * @return ArrayList<Coupon> list of all the coupons
	 * @throws CompanyNotFoundException
	 * @throws CouponsNotFoundException
	 */
	ArrayList<Coupon> getAllCompanyCoupons(int companyId) throws CouponNotFoundException, CompanyNotFoundException;

	/***
	 * Get all customer coupons
	 * 
	 * @return ArrayList<Coupon> list of all the coupons
	 * @throws CustomerNotFoundException
	 * @throws CouponsNotFoundException
	 */
	ArrayList<Coupon> getAllCustomerCoupons(int customerId) throws CouponNotFoundException, CustomerNotFoundException;

	/***
	 * Get all Coupons by type
	 * 
	 * @param type
	 * @return ArrayList<Coupon>
	 * @throws CouponNotFoundException
	 */
	ArrayList<Coupon> getCouponByTypeAndCompanyId(CouponType type, int companyId) throws CouponNotFoundException;

}
