package jpa.coupon.system.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jpa.coupon.system.beans.Company;
import jpa.coupon.system.beans.Coupon;
import jpa.coupon.system.myExceptions.CompanyExistException;
import jpa.coupon.system.myExceptions.CompanyNotFoundException;
import jpa.coupon.system.myExceptions.CouponNotFoundException;

@Service
public interface CompanyDAO {

	/**
	 * Creating new Company object
	 * 
	 * @param company
	 * @throws CompanyExistException
	 * @throws jpa.coupon.system.myExceptions.CompanyExistException
	 */
	void create(Company company) throws CompanyExistException;

	/**
	 * Removing Company by ID
	 * 
	 * @param companyId
	 *            find the company by company id value
	 * @throws CompanyNotFoundException
	 */
	void delete(int companyId) throws CompanyNotFoundException;

	/***
	 * Updating Company set only password & email by ID
	 * 
	 * @param password
	 * @param email
	 * @param companyId
	 *            find the company by company id value
	 * @throws CompanyNotFoundException
	 */
	void update(String password, String email, int companyId) throws CompanyNotFoundException;

	/**
	 * Get Company by ID
	 * 
	 * @param companyId
	 *            find the company by company id value
	 * @return Optional<Company> Optional Company object
	 * @throws CompanyNotFoundException
	 */
	Optional<Company> read(int companyId) throws CompanyNotFoundException;

	/**
	 * Get all Companies
	 * 
	 * @return ArrayList<Company> list of all companies in the Database.
	 * @throws CompanyNotFoundException
	 */
	ArrayList<Company> readAllCompanies() throws CompanyNotFoundException;

	/**
	 * Get all Coupons
	 * 
	 * @param companyId
	 *            find the company by company id value
	 * @return ArrayList<Coupon> list of all current company's coupon (company
	 *         by id)
	 * @throws CompanyNotFoundException
	 * @throws CouponNotFoundException
	 */
	ArrayList<Coupon> readAllCompanyCoupons(int companyId) throws CompanyNotFoundException, CouponNotFoundException;

	/**
	 * Login method for Company
	 * 
	 * @param compName
	 *            login company name
	 * @param password
	 *            login company password
	 * @return true if the given details are correct(in the Database),
	 *         otherwise, false.
	 */
	boolean login(String compName, String password);

}
