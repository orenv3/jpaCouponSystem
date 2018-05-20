// package jpa.coupon.system.dao;
//
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;
//
// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class DaoCustomerTests {
//
// @Autowired
// private CustomerDBDAO custDb;
//
// @Autowired
// private CouponDBDAO coupDb;
//
// @Test
// public void contextLoads() {
// }
//
// @Test
// public void DBDAOTest() {
//
// // ____________________________________________________//
// ////////// create /////////////////////////
// // System.out.println("============ create ====================");
// // for (int i = 0; i < 10; i++) {
// // Customer cust = new Customer();
// // cust.setName("customer-" + i);
// // cust.setPassword("password");
// // try {
// // custDb.create(cust);
// // } catch (CustomerExistException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // }
//
// // ____________________________________________________//
// ////////// get all customers /////////////////////////
// // try {
// // System.out.println("========= get all customers =========");
// // ArrayList<Customer> custList = custDb.getAllCustomers();
// // for (Customer customer : custList) {
// // System.out.println(customer);
// // }
// // } catch (CustomerNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
//
// // _____________________________________________//
// /////////////// update //////////////////////
// // System.out.println("=============== update cust 26 =========== ");
// // try {
// // custDb.update("update_cust", 26);
// // } catch (CustomerNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
//
// /////////// read customer //////
// // try {
// // Customer c = custDb.read(26);
// // System.out.println(" ======== cust 26 after update ====\n" + c);
// // } catch (CustomerNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
//
// // ________________ Customer purchase ______________ //
// // System.out.println("=========== Customer purchase. =============");
// // try {
// // System.out.println("====== coupons of cust 26 before
// // ==============");
// // ArrayList<Coupon> cupL = custDb.getCoupons(23);
// // for (Coupon coupon : cupL) {
// // System.out.println(coupon + "<========= coupon ==========");
// // }
// // custDb.purchaseCoupon(14, 23);
// // custDb.purchaseCoupon(10, 26);
// // custDb.purchaseCoupon(12, 26);
//
// // } catch (CustomerNotFoundException | CouponNotFoundException e) {
// // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // System.out.println("====== coupons of cust 26 after ================
// // ");
// // try {
// // ArrayList<Coupon> cupL = custDb.getCoupons(23);
// // for (Coupon coupon : cupL) {
// // System.out.println(coupon + "<========= coupon ==========");
// // }
// // } catch (CustomerNotFoundException | CouponNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
//
// // try {
// // System.out.println("=================check check==================");
// // Coupon check = coupDb.getCouponByCustomerId(13, 19);
// // Coupon check2 = coupDb.getCouponByCustomerId(144, 23);
// // Optional<Coupon> check3 =
// // Optional.ofNullable(coupDb.getCouponByCustomerId(222, 23));
// // System.out.println("check1 =======>" + check);
// // System.out.println("check2 =======>" + check2);
// // System.out.println("check3 =======>" + check3);
// // } catch (CouponNotFoundException | CustomerNotFoundException e) {
// // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // _________________________________________//
// ///////// delete customer //////
// // try {
// // custDb.delete(26);
// // } catch (CustomerNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
//
// // ______________ get cust by name and password ____________//
//
// // System.out.println("============cust by name&&pass============");
// // System.out.println(custDb.getCustomerByNameAndPassword("customer-0",
// // "password"));
// }
// }
