package jpa.coupon.system.myExceptions;

public class CouponNotFoundException extends Exception {

	/**
	 * Class that describes exceptions to throw for CouponDAO
	 */
	private static final long serialVersionUID = 1L;

	public CouponNotFoundException() {
		super();
	}

	public CouponNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CouponNotFoundException(String message) {
		super(message);

	}

	@Override
	public synchronized Throwable getCause() {
		// TODO Auto-generated method stub
		return super.getCause();
	}

	@Override
	public synchronized Throwable initCause(Throwable arg0) {
		// TODO Auto-generated method stub
		return super.initCause(arg0);
	}

}
