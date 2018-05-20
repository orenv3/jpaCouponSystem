package jpa.coupon.system.dao;

import java.util.ArrayList;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jpa.coupon.system.beans.Coupon;
import jpa.coupon.system.general.CouponType;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Integer> {

	/**
	 * Delete Coupon by id
	 * 
	 * @param id
	 *            coupon id
	 */
	@Transactional
	@Modifying
	void deleteById(int id);

	/**
	 * Decrease the coupon's amount lowers in 1
	 * 
	 * @param couponId
	 *            coupon id
	 */
	@Transactional
	@Modifying
	@Query("UPDATE Coupon coup SET coup.amount = amount-1 WHERE coup.id = :couponId")
	void decreaseAmount(@Param("couponId") int couponId);

	/**
	 * Get the coupon's amount by id
	 * 
	 * @param couponId
	 */
	int findAmountById(int couponId);

	/**
	 * Update Coupon object. The only values that this method updates are:
	 * endDate, price, amount, message, image
	 * 
	 * @param endDate
	 * @param price
	 * @param amount
	 * @param message
	 * @param image
	 * @param couponId
	 * @param companyId
	 */
	@Transactional
	@Modifying
	@Query("UPDATE Coupon coup SET coup.endDate= :endDate, coup.price = :price, "
			+ "coup.amount = :amount, coup.message = :message, coup.image = :image "
			+ "WHERE coup.id = :couponId AND coup.company.id = :companyId")
	void updateCoupon(@Param("endDate") Date endDate, @Param("price") double price, @Param("amount") int amount,
			@Param("message") String message, @Param("image") String image, @Param("couponId") int couponId,
			@Param("companyId") int companyId);

	/**
	 * Remove all the coupons of specific company by id.
	 * 
	 * @param companyId
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM Coupon coup WHERE coup.company.id = :companyId")
	void removeAllCompanyCoupons(@Param("companyId") int companyId);

	/**
	 * Remove a coupon of specific company by company id & coupon id
	 * 
	 * @param companyId
	 * @param couponId
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM Coupon coup WHERE coup.company.id = :companyId AND coup.id = :couponId")
	void removeCompanyCoupon(@Param("companyId") int companyId, @Param("couponId") int couponId);

	/**
	 * Remove coupon by its name(title)
	 * 
	 * @param title
	 */
	@Transactional
	@Modifying
	void deleteByTitle(String title);

	/***
	 * Get Coupon by id
	 *
	 * @param id
	 * @return Coupon object
	 */
	Coupon findById(int id);

	/**
	 * Get coupon by name(title)
	 * 
	 * @param title
	 * @return
	 */
	Coupon findBytitle(String title);

	/**
	 * Get list of coupons by type
	 * 
	 * @param CouponType
	 *            type
	 * @return ArrayList<Coupon> ArrayList of coupons.
	 */
	ArrayList<Coupon> findBytype(CouponType type);

	/**
	 * Get all company's coupons order by type
	 * 
	 * @param compId
	 * @return
	 */
	@Query("SELECT coup FROM Coupon coup WHERE coup.company.id = :compId ORDER BY type")
	ArrayList<Coupon> orederByTypeAndCompany(@Param("compId") int compId);

	/**
	 * Get list of coupons by price
	 * 
	 * @param double
	 *            price
	 * @return ArrayList<Coupon> ArrayList of coupons.
	 */
	ArrayList<Coupon> findByPrice(double price);

	/**
	 * Get list of company's coupons by price
	 * 
	 * @param double
	 *            price
	 * @return ArrayList<Coupon> ArrayList of coupons.
	 */
	ArrayList<Coupon> findByPriceAndCompanyId(double price, int comapnyId);

	/**
	 * Get list of coupons by its own company id. The coupons in the result must
	 * be owned by this specific company.
	 * 
	 * @param companyId
	 * @return ArrayList<Coupon> ArrayList of coupons
	 */
	ArrayList<Coupon> findByCompanyId(int companyId);

	/**
	 * Get coupon by its id and its owner(company) id
	 * 
	 * @param couponId
	 * @param companyId
	 * @return
	 */
	Coupon findByidAndCompanyId(int couponId, int companyId);

	/**
	 * Get list of coupons of specific customer by customer id.
	 * 
	 * @param customerId
	 * @return
	 */
	@Query("SELECT coup FROM Coupon coup WHERE coup.id IN(SELECT coup.id FROM coup.customers c WHERE c.id  = :customerId)")
	ArrayList<Coupon> findCustomerCoupons(@Param("customerId") int customerId);

	/***
	 * Get customer's coupon by its ID
	 *
	 * @param customerId
	 * @return Coupon
	 */
	Coupon findByidAndCustomersId(int couponId, int customerId);

	/**
	 * Get all Company's Coupons by type
	 * 
	 * @param type
	 * @param compId
	 * @return
	 */
	ArrayList<Coupon> findByTypeAndCompanyId(CouponType type, int compId);

	/***
	 * Get all Customer's Coupons by type
	 *
	 * @param type
	 * @param customerId
	 * @return ArrayList<Coupon>
	 */
	ArrayList<Coupon> findBytypeAndCustomersId(CouponType type, int customerId);

	/**
	 * Get Customer's Coupons by price
	 * 
	 * @param customerId
	 * @param price
	 * @return ArrayList<Coupon> list of coupons by price
	 */
	ArrayList<Coupon> findByPriceAndCustomersId(int customerId, double price);

}
