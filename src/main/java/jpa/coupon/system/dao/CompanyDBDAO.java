package jpa.coupon.system.dao;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.coupon.system.beans.Company;
import jpa.coupon.system.beans.Coupon;
import jpa.coupon.system.myExceptions.CompanyExistException;
import jpa.coupon.system.myExceptions.CompanyNotFoundException;
import jpa.coupon.system.myExceptions.CouponNotFoundException;

@Service
public class CompanyDBDAO implements CompanyDAO {

	@Autowired
	private CouponRepository couponRepo;

	@Autowired
	private CompanyRepository companyRepo;

	/**
	 * Creating new Company object
	 * 
	 * @param company
	 * @throws CompanyExistException
	 */
	@Override
	public void create(Company company) throws CompanyExistException {
		companyRepo.save(company);
	}

	/**
	 * Removing Company by ID
	 * 
	 * @param companyId
	 *            find the company by company id value
	 * @throws CompanyNotFoundException
	 */
	@Override
	public void delete(int companyId) throws CompanyNotFoundException {
		companyRepo.deleteById(companyId);
	}

	/***
	 * Updating Company. Setting only password & email find the company by ID
	 * 
	 * @param password
	 * @param email
	 * @param companyId
	 *            find the company by company id value
	 * @throws CompanyNotFoundException
	 */
	@Override
	public void update(String password, String email, int companyId) throws CompanyNotFoundException {
		companyRepo.updateCompany(password, email, companyId);
	}

	/**
	 * Updating Company.
	 * 
	 * @param comp
	 */
	public void updateSave(Company comp) {
		companyRepo.save(comp);
	}

	/**
	 * Get Company by ID
	 * 
	 * @param companyId
	 *            find the company by company id value
	 * @return Optional<Company> Optional Company object
	 * @throws CompanyNotFoundException
	 */
	@Override
	public Optional<Company> read(int companyId) throws CompanyNotFoundException, NoSuchElementException {
		Optional<Company> byId = Optional.ofNullable(companyRepo.findById(companyId));
		return byId;
	}

	/**
	 * Get all Companies
	 * 
	 * @return ArrayList<Company> list of all companies in the Database.
	 * @throws CompanyNotFoundException
	 */
	@Override
	public ArrayList<Company> readAllCompanies() throws CompanyNotFoundException {
		return (ArrayList<Company>) companyRepo.findAll();
	}

	/**
	 * Get all Coupons of a specific company by its id
	 * 
	 * @param companyId
	 *            find the company by company id value
	 * @return ArrayList<Coupon> list of all current company's coupon (company
	 *         by id)
	 * @throws CompanyNotFoundException
	 * @throws CouponNotFoundException
	 */
	@Override
	public ArrayList<Coupon> readAllCompanyCoupons(int companyId)
			throws CompanyNotFoundException, CouponNotFoundException {
		return couponRepo.findByCompanyId(companyId);
	}

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
	@Override
	public boolean login(String compName, String password) {
		Optional<Company> check = Optional.ofNullable(companyRepo.findByNameAndPassword(compName, password));
		if (check.isPresent())
			return true;
		return false;
	}

	/****
	 * Get Company by name
	 * 
	 * @param name
	 *            company name
	 * @return Optional<Company> Optional Company object
	 */
	public Optional<Company> getCompanyByName(String name) {
		return Optional.ofNullable(companyRepo.findByName(name));
	}

	/**
	 * Get Company by both name and password. If one of the values is incorrect
	 * so it is empty answer.
	 * 
	 * @param name
	 *            company name
	 * @param password
	 *            company password
	 * @return Optional<Company> if the given name and password are correct then
	 *         it returns Optional Company object. Otherwise, returns null.
	 * @throws CompanyNotFoundException
	 */
	public Optional<Company> getComapnyByNameAndPassword(String name, String password) throws CompanyNotFoundException {
		Company byNameAndPwd = companyRepo.findByNameAndPassword(name, password);
		return Optional.ofNullable(byNameAndPwd);
	}
}
