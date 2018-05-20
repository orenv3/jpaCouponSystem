package jpa.coupon.system.myExceptions;

public class CustomerNotFoundException extends Exception {

	/**
	 * Class that describes exceptions to throw for CustomerDAO
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomerNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
