package jpa.coupon.system.restAPI;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jpa.coupon.system.beans.Company;
import jpa.coupon.system.beans.Customer;
import jpa.coupon.system.facades.AdminFacade;
import jpa.coupon.system.myExceptions.AdminExceptions;
import jpa.coupon.system.myExceptions.CompanyExistException;
import jpa.coupon.system.myExceptions.CompanyNotFoundException;
import jpa.coupon.system.myExceptions.CustomerExistException;
import jpa.coupon.system.myExceptions.CustomerNotFoundException;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/adminRest")
@RestController
public class AdminRestAPI {

	private LogController loggerObj = new LogController(this.getClass());

	@Autowired
	private AdminFacade ADMIN;

	////////////////// Company methods ////////////////
	@RequestMapping(value = "/createCompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createCompany(@RequestBody Company company, HttpServletRequest request,
			HttpServletResponse response) {
		AdminFacade ADMIN = facade(request, response);
		try {
			ADMIN.createCompany(company);
		} catch (CompanyExistException | AdminExceptions e) {
			loggerObj.getLogger().debug(loggerObj.getCurrentDate() + " user: ADMIN could not create company: " + company
					+ ". Exception error: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		loggerObj.getLogger().info(loggerObj.getCurrentDate() + " user: ADMIN created: " + company + " successfully");
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN)
				.body("user: ADMIN created: " + company + " successfully");
	}

	@RequestMapping(value = "/removeCompany", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity removeCompany(@RequestBody Company company, HttpServletRequest request,
			HttpServletResponse response) {
		AdminFacade ADMIN = facade(request, response);
		try {
			ADMIN.removeCompany(company);
		} catch (CompanyNotFoundException | AdminExceptions e) {
			loggerObj.getLogger().debug(loggerObj.getCurrentDate() + " user ADMIN could not delete company: " + company
					+ ". Exception error: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}

		loggerObj.getLogger().info(loggerObj.getCurrentDate() + " user: ADMIN deleted: " + company + " successfully");
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN)
				.body("user: ADMIN deleted: " + company + " successfully");
	}

	@RequestMapping(value = "/updateCompany", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateCompany(@RequestBody Company company, HttpServletRequest request,
			HttpServletResponse response) {
		AdminFacade ADMIN = facade(request, response);
		try {
			ADMIN.updateCompany(company);
		} catch (CompanyNotFoundException | AdminExceptions e) {
			loggerObj.getLogger().debug(loggerObj.getCurrentDate() + " user ADMIN could not update company: " + company
					+ ". Exception error: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		String message = "user: ADMIN updated company to: " + company + " successfully";
		loggerObj.getLogger().info(loggerObj.getCurrentDate() + " " + message);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(message);

	}

	@RequestMapping(value = "/getCompany/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getCompany(@PathVariable("id") int id, HttpServletRequest request,
			HttpServletResponse response) {
		// AdminFacade ADMIN = facade(request, response);

		Company company = null;
		try {
			company = ADMIN.getCompany(id);
		} catch (CompanyNotFoundException | AdminExceptions e) {
			loggerObj.getLogger()
					.debug(loggerObj.getCurrentDate()
							+ " The user ADMIN could not fetched a company details via getCompany(id) method."
							+ " The entered id is:[ " + id + " ]" + ". Exception error: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		loggerObj.getLogger().info(loggerObj.getCurrentDate()
				+ " The user ADMIN fetched a company details via getCompany(id) method. Company: " + company);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(company);
	}

	@RequestMapping(value = "/getAllCompanies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getAllCompanies(HttpServletRequest request, HttpServletResponse response) {
		AdminFacade ADMIN = facade(request, response);
		ArrayList<Company> companies = null;
		try {
			companies = (ArrayList<Company>) ADMIN.getAllCompanies();
		} catch (AdminExceptions | CompanyNotFoundException e) {
			loggerObj.error(loggerObj.getCurrentDate() + " User ADMIN could not get list via method getAllCompanies()."
					+ ". Exception error: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		loggerObj.getLogger()
				.info(loggerObj.getCurrentDate() + " User ADMIN get details via method getAllCompanies().");
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(companies);
	}

	////////////////// Customer methods ////////////////
	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createCustomer(@RequestBody Customer customer, HttpServletRequest request,
			HttpServletResponse response) {
		AdminFacade ADMIN = facade(request, response);
		try {
			ADMIN.createCustomer(customer);
		} catch (CustomerExistException | AdminExceptions e) {
			loggerObj.getLogger().debug(loggerObj.getCurrentDate() + " User: ADMIN could not create customer: "
					+ customer + ". Exception error: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		String message = " User: ADMIN created: " + customer + " successfully";
		loggerObj.getLogger().info(loggerObj.getCurrentDate() + message);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(message);
	}

	@RequestMapping(value = "/removeCustomer", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity removeCustomer(@RequestBody Customer customer, HttpServletRequest request,
			HttpServletResponse response) {
		AdminFacade ADMIN = facade(request, response);
		try {
			ADMIN.removeCustomer(customer);
		} catch (CustomerNotFoundException | AdminExceptions e) {
			loggerObj.getLogger().debug(loggerObj.getCurrentDate() + " User ADMIN could not delete customer:" + customer
					+ ". Exception error: " + e.getMessage());
			e.printStackTrace();
		}
		String msg = " User: ADMIN deleted: " + customer + " successfully";
		loggerObj.getLogger().info(loggerObj.getCurrentDate() + msg);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(msg);
	}

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateCustomer(@RequestBody Customer customer, HttpServletRequest request,
			HttpServletResponse response) {
		AdminFacade ADMIN = facade(request, response);
		try {
			ADMIN.updateCustomer(customer);
		} catch (CustomerNotFoundException | AdminExceptions e) {
			loggerObj.getLogger().debug(loggerObj.getCurrentDate() + " User ADMIN could not update customer:" + customer
					+ ". Exception error: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		String msg = " User: ADMIN uptaded: " + customer + " successfully";
		loggerObj.getLogger().info(loggerObj.getCurrentDate() + msg);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(msg);
	}

	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getCustomer(@PathVariable("id") int id, HttpServletRequest request,
			HttpServletResponse response) {
		AdminFacade ADMIN = facade(request, response);
		Customer customer = null;
		try {
			customer = ADMIN.getCustomer(id);
		} catch (CustomerNotFoundException | AdminExceptions e) {
			loggerObj.getLogger()
					.debug(loggerObj.getCurrentDate()
							+ " The user ADMIN could not fetched a customer details via method: getCustomer(id). The entered id is:[ "
							+ id + " ]" + ". Exception error: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		String msg = " User: ADMIN get customer details: " + customer + " successfully";
		loggerObj.getLogger().info(loggerObj.getCurrentDate() + msg);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(customer);
	}

	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getAllCustomers(HttpServletRequest request, HttpServletResponse response) {
		AdminFacade ADMIN = facade(request, response);
		ArrayList<Customer> list = null;
		try {
			list = (ArrayList<Customer>) ADMIN.getAllCustomers();
		} catch (AdminExceptions | CustomerNotFoundException e) {
			loggerObj.getLogger()
					.debug(loggerObj.getCurrentDate()
							+ " User ADMIN could not get details via method getAllCustomers()." + ". Exception error: "
							+ e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		loggerObj.getLogger()
				.info(loggerObj.getCurrentDate() + " User ADMIN get details via method getAllCustomers().");
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(list);
	}

	private AdminFacade facade(HttpServletRequest request, HttpServletResponse response) {
		return (AdminFacade) request.getSession().getAttribute("facade");
	}

	// /**
	// * just to test the admin user
	// */
	// @PostConstruct
	// private void init() {
	// this.get();
	// }
	//
	// /**
	// * This method mimic admin user logged-in
	// *
	// * @return
	// */
	// private AdminFacade get() {
	// CouponClientFacade s;
	// try {
	// s = ADMIN.login("admin", "admin", Clients.ADMIN);
	// ADMIN = (AdminFacade) s;
	// } catch (AdminExceptions e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	// return ADMIN;
	// }

}
