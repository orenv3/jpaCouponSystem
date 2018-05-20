package jpa.coupon.system.facades;

import jpa.coupon.system.general.Clients;
import jpa.coupon.system.myExceptions.AdminExceptions;
import jpa.coupon.system.myExceptions.CompanyNotFoundException;
import jpa.coupon.system.myExceptions.CustomerNotFoundException;

public interface CouponClientFacade {

	CouponClientFacade login(String name, String password, Clients type)
			throws CustomerNotFoundException, CompanyNotFoundException, AdminExceptions;

}
