package jpa.coupon.system.facades;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jpa.coupon.system.beans.Company;
import jpa.coupon.system.beans.Coupon;
import jpa.coupon.system.dao.CompanyDBDAO;
import jpa.coupon.system.dao.CouponDBDAO;
import jpa.coupon.system.general.Clients;
import jpa.coupon.system.general.CouponType;
import jpa.coupon.system.myExceptions.CompanyNotFoundException;
import jpa.coupon.system.myExceptions.CouponExistException;
import jpa.coupon.system.myExceptions.CouponNotFoundException;

@Component
public class CompanyFacade implements CouponClientFacade {

	@Autowired
	CompanyDBDAO companyQueries;

	@Autowired
	CouponDBDAO couponQueries;

	private Company loginCompany;

	/**
	 * This method checks whether the given log-in information is valid. If the
	 * log-in information is correct - the method configure the logged-in
	 * company object to this facade and return the facade (this).
	 * 
	 * @return if the information is valid the method return the facade.
	 *         Otherwise, returns null.
	 */
	@Override
	public CouponClientFacade login(String name, String password, Clients type) throws CompanyNotFoundException {
		if (!(type == Clients.COMPANY))
			throw new CompanyNotFoundException("The client type should be company.");

		Optional<Company> checkCompany = companyQueries.getComapnyByNameAndPassword(name, password);
		if (checkCompany.isPresent()) {
			{
				loginCompany = checkCompany.get();
				return this;
			}
		} else
			throw new CompanyNotFoundException(
					"At least one of the parameters(name or password) is not correct. Company not found");

	}

	/**
	 * Create coupon. The coupon is created by company(logged-in company). The
	 * coupon title is unique there is no duplication in the DB.
	 * 
	 * @param coupon
	 * @throws CompanyNotFoundException
	 * @throws CouponExistException
	 */
	public void createCoupon(Coupon coupon) throws CompanyNotFoundException, CouponExistException {

		if (coupon == null || coupon.getTitle() == null || coupon.getTitle().isEmpty())
			throw new CouponExistException("Either the coupon is null Or its title empty/null");
		if (loginCompany == null)
			throw new CompanyNotFoundException("The company user not logged-in");
		Optional<Coupon> checkCoup = Optional.ofNullable(couponQueries.getCouponByName(coupon.getTitle()));
		if (checkCoup.isPresent())
			throw new CouponExistException("The coupon with the title: " + coupon.getTitle() + " already exists");
		if (coupon.getAmount() > 10)
			couponQueries.create(coupon, loginCompany.getId());
		else
			throw new CouponExistException("The coupon's amount have to be at least 10");
	}

	/**
	 * Remove a coupon. The deletion occurs by the owner of the coupon(logged-in
	 * company)
	 * 
	 * @param coupon
	 * @throws CompanyNotFoundException
	 * @throws CouponNotFoundException
	 */
	public void removeCoupon(Coupon coupon) throws CompanyNotFoundException, CouponNotFoundException {
		checkAllValues(coupon);
		couponQueries.delete(coupon.getId(), loginCompany.getId());
	}

	/**
	 * Update a coupon. The method DO NOT edit the following: id, title,
	 * startDate and type.
	 * 
	 * @param coupon
	 * @throws CouponNotFoundException
	 * @throws CompanyNotFoundException
	 */
	public void updateCoupon(Coupon coupon) throws CouponNotFoundException, CompanyNotFoundException {
		checkAllValues(coupon);
		couponQueries.update(coupon.getEndDate(), coupon.getPrice(), coupon.getAmount(), coupon.getImage(),
				coupon.getMessage(), coupon.getId(), loginCompany.getId());
	}

	/**
	 * Get the logged-in company.
	 * 
	 * @return Company object
	 * @throws CompanyNotFoundException
	 */
	public Company getCompany() throws CompanyNotFoundException {
		if (loginCompany == null)
			throw new CompanyNotFoundException("The company user not logged-in");
		return loginCompany;
	}

	/**
	 * Get coupon by ID
	 * 
	 * @param couponID
	 * @return coupon
	 * @throws CouponNotFoundException
	 * @throws CompanyNotFoundException
	 */
	public Coupon getCoupon(int couponID) throws CouponNotFoundException, CompanyNotFoundException {
		return checkAllValues(couponQueries.read(couponID));
	}

	/**
	 * Get all logged-in company's coupons
	 * 
	 * @return list of coupons
	 * @throws CouponNotFoundException
	 * @throws CompanyNotFoundException
	 */
	public List<Coupon> getAllCompanyCoupons() throws CouponNotFoundException, CompanyNotFoundException {
		if (loginCompany == null)
			throw new CompanyNotFoundException("company not logged-in ");
		List<Coupon> l = couponQueries.getAllCompanyCoupons(loginCompany.getId());
		if (l.isEmpty() || l == null)
			throw new CouponNotFoundException("No coupons in the system");
		return l;

	}

	/**
	 * Get company's coupon by type. If the company has this type of coupons it
	 * return List.
	 * 
	 * @param type
	 * @return List of coupons
	 * @throws CouponNotFoundException
	 */
	public List<Coupon> getCouponBySpecificType(CouponType type) throws CouponNotFoundException {
		List<Coupon> l = couponQueries.getCouponByTypeAndCompanyId(type, loginCompany.getId());
		if (l.isEmpty() || l == null)
			throw new CouponNotFoundException("There are no coupon with type:" + type);
		return l;
	}

	/**
	 * All company's coupon order by type
	 * 
	 * @return List of Coupons
	 * @throws CouponNotFoundException
	 */
	public List<Coupon> getCompanyCouponsOrderByType() throws CouponNotFoundException {
		List<Coupon> l = couponQueries.getCompanyCouponOrderByType(loginCompany.getId());
		if (l.isEmpty() || l == null)
			throw new CouponNotFoundException("There are no coupon for the company: " + loginCompany.getName());
		return l;
	}

	/**
	 * Private method that checks valid parameters. It checks whether there is
	 * valid logged-in company that uses those methods. It also checks if the
	 * coupon object is not null or not in the DB.
	 * 
	 * @param coup
	 * @return
	 * @throws CouponNotFoundException
	 * @throws CompanyNotFoundException
	 */
	private Coupon checkAllValues(Coupon coup) throws CouponNotFoundException, CompanyNotFoundException {
		if (loginCompany == null)
			throw new CompanyNotFoundException("The company user not logged-in");
		if (coup == null)
			throw new CouponNotFoundException("The submitted coupon is null");

		Optional<Coupon> checkCoup = Optional
				.ofNullable(couponQueries.getCouponByIdAndCompanyId(loginCompany.getId(), coup.getId()));
		if (!checkCoup.isPresent())
			throw new CouponNotFoundException("The coupon with the title: " + coup.getTitle() + " does not exists");
		return coup;
	}
}
