// package jpa.coupon.system.facades;
//
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;
//
// import jpa.coupon.system.dao.CouponDBDAO;
// import jpa.coupon.system.general.Clients;
// import jpa.coupon.system.myExceptions.CustomerNotFoundException;
//
// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class CustomerFadaceTest {
//
// @Autowired
// CustomerFacade customerFacade;
//
// @Autowired
// CouponDBDAO couponQueries;
//
// @Test
// public void contextLoads() {
// }
//
// @Test
// public void customerFacadeTest() {
//
// try {
// customerFacade = (CustomerFacade) customerFacade.login("customer-2",
// "password2", Clients.CUSTOMER);
// } catch (CustomerNotFoundException e) {
// e.printStackTrace();
// }
//
// System.out.println("============================");
// System.out.println("customer ==>" + customerFacade.getLoginCustomer());
// System.out.println("============================");
//
// // try {
// // ArrayList<Coupon> list = customerFacade.getAllCouponsInDatabase();
// // for (Coupon coupon : list) {
// // System.out.println("||coupon ===>" + coupon);
// // }
// // } catch (CustomerNotFoundException | CouponNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // try {
// // System.out.println("===purchased coup === ");
// // ArrayList<Coupon> list = customerFacade.getAllPurchasedCoupon();
// // for (Coupon coupon : list) {
// // System.out.println("||coupon ===>" + coupon);
// // }
// // } catch (CustomerNotFoundException | CouponNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // Coupon cup = null;
// // Coupon cup2 = null;
// // try {
// // cup = couponQueries.read(17);
// // cup2 = couponQueries.read(21);
// // } catch (CouponNotFoundException e) {
// // e.printStackTrace();
// // }
// //
// // try {
// // customerFacade.purchaseCoupon(cup);
// // customerFacade.purchaseCoupon(cup2);
// // } catch (CustomerNotFoundException | CouponNotFoundException |
// // CouponExistException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // try {
// // System.out.println("===purchased coup === ");
// // ArrayList<Coupon> list = customerFacade.getAllPurchasedCoupon();
// // for (Coupon coupon : list) {
// // System.out.println("||coupon ===>" + coupon);
// // }
// // } catch (CustomerNotFoundException | CouponNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// }
//
// }
