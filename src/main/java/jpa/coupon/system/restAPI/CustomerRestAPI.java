package jpa.coupon.system.restAPI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.coupon.system.facades.CustomerFacade;

public class CustomerRestAPI {

	private CustomerFacade facade(HttpServletRequest request, HttpServletResponse response) {
		return (CustomerFacade) request.getSession().getAttribute("facade");
	}
}
