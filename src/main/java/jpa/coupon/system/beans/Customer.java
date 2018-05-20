package jpa.coupon.system.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String name;

	@Column
	private String password;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Coupon> coupons = new ArrayList<>();

	/**
	 * Empty Customer CTR
	 * 
	 * @param custName
	 * @param password
	 */
	public Customer() {
	}

	/**
	 * Customer CTR without id value
	 * 
	 * @param custName
	 * @param password
	 */
	public Customer(String custName, String password) {
		super();
		this.name = custName;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Coupon> getCouponsListInCustomer() {
		return coupons;
	}

	public void setCouponsListInCustomer(List<Coupon> couponsListInCustomer) {
		coupons = couponsListInCustomer;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

}
