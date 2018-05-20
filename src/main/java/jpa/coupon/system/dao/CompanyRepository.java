package jpa.coupon.system.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jpa.coupon.system.beans.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {

	/***
	 * Update Company in the Database. Setting only password & email
	 * 
	 * @param password
	 * @param email
	 * @param companyId
	 */
	@Transactional
	@Modifying
	@Query("UPDATE Company comp SET comp.password = :password, comp.email = :email WHERE comp.id= :companyId")
	void updateCompany(@Param("password") String password, @Param("email") String email,
			@Param("companyId") int companyId);

	/***
	 * Get Company by its name via the Database
	 * 
	 * @param companyName
	 * @return Company
	 */
	Company findByNameAndPassword(String companyName, String password);

	/***
	 * Find company by id via the Database
	 * 
	 * @param id
	 * @return
	 */
	Company findById(int id);

	/***
	 * Get Company by name via the Database
	 * 
	 * @param name
	 * @return Company
	 */
	Company findByName(String name);

	/**
	 * find all companies via the Database
	 * 
	 * @return ArrayList<Company> list of companies
	 */
	ArrayList<Company> findAll();

}
