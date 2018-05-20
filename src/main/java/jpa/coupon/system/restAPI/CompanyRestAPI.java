package jpa.coupon.system.restAPI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jpa.coupon.system.beans.Company;
import jpa.coupon.system.beans.Coupon;
import jpa.coupon.system.facades.CompanyFacade;
import jpa.coupon.system.myExceptions.CompanyNotFoundException;
import jpa.coupon.system.myExceptions.CouponExistException;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/CompanyRestAPI")
@RestController
public class CompanyRestAPI {

	@Autowired
	private LogController logger;

	@RequestMapping(value = "/createCoupon", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createCoupon(@RequestBody Coupon coupon, HttpServletRequest request,
			HttpServletResponse response) {
		CompanyFacade currentLogginCompany = facade(request, response);
		Company companyDetails = (Company) getCurrentLoggin(request, response).getBody();
		try {
			currentLogginCompany.createCoupon(coupon);
		} catch (CompanyNotFoundException | CouponExistException e) {
			logger.debug(logger.getCurrentDate() + " The company: " + companyDetails + " could not create the coupon: "
					+ coupon + ". Exception error: " + e.getMessage());
		}
		logger.info(logger.getCurrentDate() + " The company: " + companyDetails + " create the coupon: " + coupon
				+ " successfully");
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN)
				.body("The coupon " + coupon.getTitle() + " created successfully");
	}

	public void removeCoupon() {

	}

	/**
	 * Get the Company details of the current (logged in) company.
	 * 
	 * @param comapny
	 * @param request
	 * @param response
	 * @return ResponseEntity of company object in the body or error message if
	 *         there is exception.
	 */
	public ResponseEntity getCompany(@RequestBody Company comapny, HttpServletRequest request,
			HttpServletResponse response) {
		CompanyFacade currentLogginCompany = facade(request, response);
		Company companyDetails = null;
		try {
			companyDetails = currentLogginCompany.getCompany();
		} catch (CompanyNotFoundException e) {
			logger.debug(logger.getCurrentDate() + " A company: " + companyDetails
					+ " could not fetch the details Exception error: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}

		logger.info(
				logger.getCurrentDate() + " The company " + companyDetails.getName() + " get the details successfully");
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(companyDetails);
	}

	/**
	 * Get the current (logged in) company facade.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	private CompanyFacade facade(HttpServletRequest request, HttpServletResponse response) {
		return (CompanyFacade) request.getSession().getAttribute("facade");
	}

	/**
	 * Get the Company details of the current (logged in) company. This method
	 * decrease the amount of try/catch of getComapny() method in the whole
	 * class. The detail of company important for the logs of the system. //This
	 * method signature different from getCompany method.//
	 * 
	 * @param request
	 * @param response
	 * @return ResponseEntity of a company in the body.
	 */
	private ResponseEntity getCurrentLoggin(HttpServletRequest request, HttpServletResponse response) {
		CompanyFacade cf = facade(request, response);
		Company current = null;
		try {
			current = cf.getCompany();
		} catch (CompanyNotFoundException e) {
			logger.debug(logger.getCurrentDate() + "The company: " + current
					+ " could not get details via method: getCurrentLoggin" + ". Exception error: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		logger.info(
				logger.getCurrentDate() + " The method getCurrentLoggin() executed successfully. company:" + current);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(current);
	}

}
