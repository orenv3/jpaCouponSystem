package jpa.coupon.system.facades;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jpa.coupon.system.beans.Company;
import jpa.coupon.system.beans.Customer;
import jpa.coupon.system.dao.CompanyDBDAO;
import jpa.coupon.system.dao.CustomerDBDAO;
import jpa.coupon.system.general.Clients;
import jpa.coupon.system.myExceptions.AdminExceptions;
import jpa.coupon.system.myExceptions.CompanyExistException;
import jpa.coupon.system.myExceptions.CompanyNotFoundException;
import jpa.coupon.system.myExceptions.CustomerExistException;
import jpa.coupon.system.myExceptions.CustomerNotFoundException;

@Component
public class AdminFacade implements CouponClientFacade {

	@Autowired
	private CompanyDBDAO compDbQueries;

	@Autowired
	private CustomerDBDAO custDbQueries;

	private final String adminLoggin = "adminadmin";

	private AdminFacade admin;

	/**
	 * This method indicates whether the given login Information is valid. If
	 * the login information is correct - the method set the company to this
	 * facade object and return this facade object.
	 * 
	 * @return if the information is valid the method return this facade (after
	 *         setting the current login company to the current object). if the
	 *         information is invalid the method returns null;
	 * @throws AdminExceptions
	 */
	@Override
	public CouponClientFacade login(String name, String password, Clients type) throws AdminExceptions {

		if (!(type == Clients.ADMIN))
			throw new AdminExceptions("The client type should be admin");
		if ((name + password).equals(adminLoggin)) {
			admin = this;
			return (CouponClientFacade) this;
		}
		throw new AdminExceptions("At least one of the parameters(name or password is not correct.");
	}

	/***
	 * Creating Company
	 *
	 * @param company
	 * @throws CompanyExistException
	 * @throws AdminExceptions
	 */
	public void createCompany(Company company) throws CompanyExistException, AdminExceptions {
		if (company == null)
			throw new CompanyExistException("Company object is null");
		if (admin != null) {
			Optional<Company> checkName = compDbQueries.getCompanyByName(company.getName());
			if (checkName.isPresent())
				throw new CompanyExistException("Company name: " + checkName.get().getName() + " already Exists");

			compDbQueries.create(company);
		} else
			throw new AdminExceptions("Admin not logged-in");

	}

	/**
	 * Remove company from DB
	 * 
	 * @param company
	 * @throws CompanyNotFoundException
	 * @throws AdminExceptions
	 */
	public void removeCompany(Company company) throws CompanyNotFoundException, AdminExceptions {
		if (admin != null) {
			isCompanyPresent(company);
			compDbQueries.delete(company.getId());
		} else
			throw new AdminExceptions("Admin not logged-in");
	}

	/**
	 * Update Company. Only password AND email can be modify.
	 * 
	 * @param company
	 * @throws CompanyNotFoundException
	 * @throws AdminExceptions
	 */
	public void updateCompany(Company company) throws CompanyNotFoundException, AdminExceptions {
		if (admin != null) {
			isCompanyPresent(company);
			compDbQueries.update(company.getPassword(), company.getEmail(), company.getId());
		} else
			throw new AdminExceptions("Admin not logged-in");
	}

	/**
	 * Get a company
	 * 
	 * @param id
	 * @return Company
	 * @throws CompanyNotFoundException
	 * @throws AdminExceptions
	 */
	public Company getCompany(int id) throws CompanyNotFoundException, AdminExceptions {
		if (admin == null) {
			throw new AdminExceptions("Admin not logged-in");
		} else {
			Optional<Company> c = compDbQueries.read(id);
			if (!(c.isPresent()))
				isCompanyPresent(null);

			return c.get();
		}

	}

	/**
	 * Get a list of all the companies in DB
	 * 
	 * @return
	 * @throws AdminExceptions
	 * @throws CompanyNotFoundException
	 */
	public List<Company> getAllCompanies() throws AdminExceptions, CompanyNotFoundException {
		if (admin == null) {
			throw new AdminExceptions("Admin not logged-in");
		} else {
			ArrayList<Company> list = (ArrayList<Company>) compDbQueries.readAllCompanies();
			if (list.isEmpty())
				throw new CompanyNotFoundException("There is no company in the system");
			else
				return list;
		}
	}

	/**
	 * Create customer object
	 * 
	 * @param customer
	 * @throws CustomerExistException
	 * @throws AdminExceptions
	 */
	public void createCustomer(Customer customer) throws CustomerExistException, AdminExceptions {
		if (customer == null)
			throw new CustomerExistException("Customer object is null");
		if (admin != null) {
			Optional<Customer> checkCust = Optional.ofNullable(custDbQueries.getCustomerByName(customer.getName()));
			if (checkCust.isPresent())
				throw new CustomerExistException("The customer name:" + customer.getName() + " already exist");
			custDbQueries.create(customer);
		} else
			throw new AdminExceptions("Admin not logged-in");

	}

	/**
	 * Remove customer object
	 * 
	 * @param customer
	 * @throws CustomerNotFoundException
	 * @throws AdminExceptions
	 */
	public void removeCustomer(Customer customer) throws CustomerNotFoundException, AdminExceptions {
		if (admin != null) {
			isCustomerPresent(customer);
			custDbQueries.delete(customer.getId());
		} else
			throw new AdminExceptions("Admin not logged-in");
	}

	/**
	 * Update customer. Only password can be modify.
	 * 
	 * @param customer
	 * @throws CustomerNotFoundException
	 * @throws AdminExceptions
	 */
	public void updateCustomer(Customer customer) throws CustomerNotFoundException, AdminExceptions {
		if (admin != null) {
			isCustomerPresent(customer);
			custDbQueries.update(customer.getPassword(), customer.getId());
		} else
			throw new AdminExceptions("Admin not logged-in");
		if (admin != null) {
			isCustomerPresent(customer);
			custDbQueries.update(customer.getPassword(), customer.getId());
		} else
			throw new AdminExceptions("Admin not logged-in");

	}

	/**
	 * Get customer
	 * 
	 * @param id
	 * @return
	 * @throws CustomerNotFoundException
	 * @throws AdminExceptions
	 */
	public Customer getCustomer(int id) throws CustomerNotFoundException, AdminExceptions {
		if (admin == null) {
			throw new AdminExceptions("Admin not logged-in");
		} else {
			Customer customer = custDbQueries.read(id);
			isCustomerPresent(customer);
			return customer;
		}

	}

	/**
	 * Get all customers from DB
	 * 
	 * @return List of customer ArrayList
	 * @throws AdminExceptions
	 * @throws CustomerNotFoundException
	 */
	public List<Customer> getAllCustomers() throws AdminExceptions, CustomerNotFoundException {
		if (admin == null) {
			throw new AdminExceptions("Admin not logged-in");
		} else {
			ArrayList<Customer> list = (ArrayList<Customer>) custDbQueries.getAllCustomers();
			if (list.isEmpty())
				throw new CustomerNotFoundException("There is no customers in the system");
			else
				return list;
		}
	}

	/**
	 * Checking whether the company object is valid && found in DB
	 * 
	 * @param company
	 * @return true if the object valid. otherwise, throw exception.
	 * @throws CompanyNotFoundException
	 */
	private boolean isCompanyPresent(Company company) throws CompanyNotFoundException {
		if (company == null)
			throw new CompanyNotFoundException("The company object is null.");
		Optional<Company> checkName = compDbQueries.read(company.getId());
		if (!(checkName.isPresent()))
			throw new CompanyNotFoundException(
					"The company not Exists. id:" + company.getId() + " name:" + company.getName());
		return true;
	}

	/**
	 * Checking whether the customer object is valid && found in DB
	 * 
	 * @param customer
	 * @return true if the object valid. otherwise, throw exception.
	 * @throws CustomerNotFoundException
	 */
	private boolean isCustomerPresent(Customer customer) throws CustomerNotFoundException {
		if (customer == null)
			throw new CustomerNotFoundException("The customer object is null.");
		Optional<Customer> checkName = Optional.ofNullable(custDbQueries.read(customer.getId()));
		if (!(checkName.isPresent()))
			throw new CustomerNotFoundException(
					"The customer not Exists. id:" + customer.getId() + " name:" + customer.getName());
		return true;
	}

}
