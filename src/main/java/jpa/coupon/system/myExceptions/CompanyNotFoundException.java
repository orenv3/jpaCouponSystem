package jpa.coupon.system.myExceptions;

public class CompanyNotFoundException extends Exception {

	/**
	 * Class that describes exceptions to throw for CompanyDAO
	 */
	private static final long serialVersionUID = 1L;

	public CompanyNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CompanyNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CompanyNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CompanyNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
