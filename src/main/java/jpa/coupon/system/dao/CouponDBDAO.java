package jpa.coupon.system.dao;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.coupon.system.beans.Company;
import jpa.coupon.system.beans.Coupon;
import jpa.coupon.system.general.CouponType;
import jpa.coupon.system.myExceptions.CompanyNotFoundException;
import jpa.coupon.system.myExceptions.CouponExistException;
import jpa.coupon.system.myExceptions.CouponNotFoundException;
import jpa.coupon.system.myExceptions.CustomerNotFoundException;

@Service
public class CouponDBDAO implements CouponDAO {

	@Autowired
	private CouponRepository couponRepo;

	@Autowired
	private CompanyRepository companyRepo;

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
	@Override
	public void create(Coupon coupon, int companyId) throws CouponExistException, CompanyNotFoundException {
		Company companyOwner = companyRepo.findById(companyId);
		coupon.setCompany(companyOwner);
		couponRepo.save(coupon);

	}

	/**
	 * Remove a coupon
	 * 
	 * @param couponId
	 * @param companyId
	 * @throws CouponNotFoundException
	 * @throws CompanyNotFoundException
	 */
	@Override
	public void delete(int couponId, int companyId) throws CouponNotFoundException, CompanyNotFoundException {
		couponRepo.removeCompanyCoupon(companyId, couponId);
	}

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
	@Override
	public void update(Date endDate, double price, int amount, String image, String message, int couponId,
			int companyId) throws CouponNotFoundException, CompanyNotFoundException {
		couponRepo.updateCoupon(endDate, price, amount, message, image, couponId, companyId);
	}

	/**
	 * Get Coupon by ID
	 * 
	 * @param couponId
	 * @return Coupon object.
	 * @throws CouponNotFoundException
	 */
	@Override
	public Coupon read(int couponId) throws CouponNotFoundException {
		return couponRepo.findById(couponId);
	}

	/**
	 * Get coupon by name(title)
	 * 
	 * @param name
	 * @return
	 */
	public Coupon getCouponByName(String name) {
		return couponRepo.findBytitle(name);
	}

	/***
	 * Get all company's coupons
	 * 
	 * @return ArrayList<Coupon> list of all the coupons
	 * @throws CouponsNotFoundException
	 */
	@Override
	public ArrayList<Coupon> getAllCompanyCoupons(int companyId)
			throws CouponNotFoundException, CompanyNotFoundException {
		return couponRepo.findByCompanyId(companyId);
	}

	/***
	 * Get all Company's Coupons by type. It returns list if the current company
	 * has this type of coupons.
	 * 
	 * @param type
	 * @return ArrayList<Coupon>
	 * @throws CouponNotFoundException
	 */
	@Override
	public ArrayList<Coupon> getCouponByTypeAndCompanyId(CouponType type, int companyId)
			throws CouponNotFoundException {
		return couponRepo.findByTypeAndCompanyId(type, companyId);
	}

	/**
	 * All company's coupon order by type
	 * 
	 * @param companyId
	 * @return
	 */
	public ArrayList<Coupon> getCompanyCouponOrderByType(int companyId) {
		return couponRepo.orederByTypeAndCompany(companyId);
	}

	/**
	 * Get all coupons from database
	 * 
	 * @return
	 */
	public ArrayList<Coupon> getAllCouponsIn_DB() {
		return (ArrayList<Coupon>) couponRepo.findAll();
	}

	/***
	 * Get all Coupons by price
	 * 
	 * @param price
	 * @return ArrayList<Coupon>
	 * @throws CouponNotFoundException
	 */
	public ArrayList<Coupon> getCouponsByPrice(double price, int companyId)
			throws CouponNotFoundException, CompanyNotFoundException {
		return couponRepo.findByPriceAndCompanyId(price, companyId);
	}

	/**
	 * Get Coupon by its ID and customer ID
	 * 
	 * @param couponId
	 * @param customerId
	 * @return coupon
	 * @throws CouponNotFoundException
	 * @throws CustomerNotFoundException
	 */
	public Coupon getCouponByCustomerId(int couponId, int customerId)
			throws CouponNotFoundException, CustomerNotFoundException {
		return couponRepo.findByidAndCustomersId(couponId, customerId);
	}

	/**
	 * Get Coupon By its ID && Company ID (owner id). In order to prevent
	 * mismatches
	 * 
	 * @param companyId
	 * @param couponId
	 * @return
	 * @throws CouponNotFoundException
	 */
	public Coupon getCouponByIdAndCompanyId(int companyId, int couponId) throws CouponNotFoundException {
		return couponRepo.findByidAndCompanyId(couponId, companyId);
	}

	/**
	 * Get all customer's coupons via customer id
	 */
	@Override
	public ArrayList<Coupon> getAllCustomerCoupons(int customerId)
			throws CouponNotFoundException, CustomerNotFoundException {
		return couponRepo.findCustomerCoupons(customerId);
	}
}
