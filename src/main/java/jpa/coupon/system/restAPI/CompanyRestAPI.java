package jpa.coupon.system.restAPI;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import jpa.coupon.system.beans.Coupon;
import jpa.coupon.system.facades.CompanyFacade;
import jpa.coupon.system.general.CouponType;
import jpa.coupon.system.myExceptions.CompanyNotFoundException;
import jpa.coupon.system.myExceptions.CouponExistException;
import jpa.coupon.system.myExceptions.CouponNotFoundException;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/CompanyRestAPI")
@RestController
public class CompanyRestAPI {

	private LogController loggerObj = new LogController(this.getClass());

	/**
	 * Create coupon. The coupon is created by company(logged-in company). The
	 * coupon title is unique there is no duplication in the DB.
	 * 
	 * @param coupon
	 * @param request
	 * @param response
	 * @return ResponseEntity String of an error or success message
	 */
	@RequestMapping(value = "/createCoupon", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createCoupon(@RequestBody Coupon coupon, HttpServletRequest request,
			HttpServletResponse response) {
		CompanyFacade currentLogginCompany = facade(request, response);
		Company companyDetails = (Company) getCurrentLoggingCompany(request, response).getBody();
		try {
			currentLogginCompany.createCoupon(coupon);
		} catch (CompanyNotFoundException | CouponExistException e) {
			loggerObj.getLogger().debug(loggerObj.getCurrentDate() + " The company: " + companyDetails
					+ " could not create the coupon: " + coupon + ". Exception error: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN)
					.body("The coupon " + coupon + " did not create " + ". Exception error: " + e.getMessage());
		}
		loggerObj.getLogger().info(loggerObj.getCurrentDate() + " The company: " + companyDetails
				+ " created the coupon: " + coupon + " successfully");
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN)
				.body("The coupon " + coupon.getTitle() + " created successfully");
	}

	/**
	 * Remove a coupon. The deletion occurs by the owner of the coupon(logged-in
	 * company)
	 * 
	 * @param coupon
	 * @param request
	 * @param response
	 * @return ResponseEntity String of an error or success message
	 */
	@RequestMapping(value = "/removeCoupon", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity removeCoupon(@RequestBody Coupon coupon, HttpServletRequest request,
			HttpServletResponse response) {
		CompanyFacade currentLogginCompany = facade(request, response);
		Company companyDetails = (Company) getCurrentLoggingCompany(request, response).getBody();

		try {
			currentLogginCompany.removeCoupon(coupon);
		} catch (CompanyNotFoundException | CouponNotFoundException e) {
			loggerObj.getLogger().debug(loggerObj.getCurrentDate() + " The company: " + companyDetails
					+ " could not remove the coupon: " + coupon + ". Exception error: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN)
					.body("The coupon " + coupon + " did not remove " + ". Exception error: " + e.getMessage());
		}
		loggerObj.getLogger().info(loggerObj.getCurrentDate() + " The company: " + companyDetails
				+ " removed the coupon: " + coupon + " successfully");
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN)
				.body("The coupon " + coupon.getTitle() + " removed successfully");

	}

	/**
	 * Update a coupon. The method DO NOT edit the following: id, title,
	 * startDate and type.
	 * 
	 * @param coupon
	 * @param request
	 * @param response
	 * @return ResponseEntity String of an error or success message
	 */
	@RequestMapping(value = "/updateCoupon", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateCoupon(@RequestBody Coupon coupon, HttpServletRequest request,
			HttpServletResponse response) {
		CompanyFacade currentLogginCompany = facade(request, response);
		Company companyDetails = (Company) getCurrentLoggingCompany(request, response).getBody();
		try {
			currentLogginCompany.updateCoupon(coupon);
		} catch (CouponNotFoundException | CompanyNotFoundException e) {
			loggerObj.getLogger().debug(loggerObj.getCurrentDate() + " The company: " + companyDetails
					+ " could not update the coupon: " + coupon + ". Exception error: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN)
					.body("The coupon " + coupon + " did not updated " + ". Exception error: " + e.getMessage());

		}
		loggerObj.getLogger().info(loggerObj.getCurrentDate() + " The company: " + companyDetails
				+ " updated the coupon: " + coupon + " successfully");
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN)
				.body("The coupon " + coupon.getTitle() + " updated successfully");
	}

	@RequestMapping(value = "/getCoupon/{couponID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getCoupon(@PathVariable("couponID") int couponID, HttpServletRequest request,
			HttpServletResponse response) {
		CompanyFacade currentLogginCompany = facade(request, response);
		Company companyDetails = (Company) getCurrentLoggingCompany(request, response).getBody();
		Coupon coupon;
		try {
			coupon = currentLogginCompany.getCoupon(couponID);
		} catch (CouponNotFoundException | CompanyNotFoundException e) {
			loggerObj.getLogger().debug(loggerObj.getCurrentDate() + " The company: " + companyDetails
					+ " could not get the coupon ID: " + couponID + ". Exception error: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN)
					.body("Can not get the coupon: ID =  " + couponID + ". Exception error: " + e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(coupon);
	}

	@RequestMapping(value = "/getCouponBySpecificType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getCouponBySpecificType(CouponType type, HttpServletRequest request,
			HttpServletResponse response) {
		CompanyFacade currentLogginCompany = facade(request, response);
		Company companyDetails = (Company) getCurrentLoggingCompany(request, response).getBody();
		List<Coupon> list = null;
		try {
			currentLogginCompany.getCouponBySpecificType(type);
		} catch (CouponNotFoundException e) {
			loggerObj.getLogger().debug(loggerObj.getCurrentDate() + " The company: " + companyDetails
					+ " could not get the coupon by type: " + type + ". Exception error: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN)
					.body("Can not get coupons by type: type =  " + type + ". Exception error: " + e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(list);
	}

	/**
	 * Get the Company details of the current (logged in) company.
	 * 
	 * @param comapny
	 * @param request
	 * @param response
	 * @return ResponseEntity of company object in the body or an error message
	 *         if there is exception.
	 */
	@RequestMapping(value = "/getCompany", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getCompany(@RequestBody Company comapny, HttpServletRequest request,
			HttpServletResponse response) {
		CompanyFacade currentLogginCompany = facade(request, response);
		Company companyDetails = null;
		try {
			companyDetails = currentLogginCompany.getCompany();
		} catch (CompanyNotFoundException e) {
			loggerObj.getLogger().debug(loggerObj.getCurrentDate() + " A company: " + companyDetails
					+ " could not fetch the details Exception error: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}

		loggerObj.getLogger().info(loggerObj.getCurrentDate() + " The company " + companyDetails.getName()
				+ " get the details successfully");
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(companyDetails);
	}

	/**
	 * Get the current (logged in) details from web or servlet.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	private CompanyFacade facade(HttpServletRequest request, HttpServletResponse response) {
		return (CompanyFacade) request.getSession().getAttribute("facade");
	}

	/**
	 * Get the Company details of the current (logged in) company for the logs
	 * in this class. This method decreases the try/catch and code amount in the
	 * whole class. (This method signature different from getCompany() method)
	 * 
	 * @param request
	 * @param response
	 * @return ResponseEntity of a company in the body.
	 */
	private ResponseEntity getCurrentLoggingCompany(HttpServletRequest request, HttpServletResponse response) {
		CompanyFacade cf = facade(request, response);
		Company current = null;
		try {
			current = cf.getCompany();
		} catch (CompanyNotFoundException e) {
			loggerObj.getLogger()
					.debug(loggerObj.getCurrentDate() + "The company: " + current
							+ " could not get details via method: getCurrentLoggingCompany()" + ". Exception error: "
							+ e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
		}
		loggerObj.getLogger().info(loggerObj.getCurrentDate()
				+ " The method getCurrentLoggingCompany() executed successfully. company:" + current);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(current);
	}

}
