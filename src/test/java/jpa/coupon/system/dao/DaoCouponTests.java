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
// public class DaoCouponTests {
//
// @Autowired
// private CouponDBDAO coupDb;
//
// @Autowired
// private CompanyDBDAO compDB;
//
// @Test
// public void contextLoads() {
// }
//
// @Test
// public void couponTestDBDAO() {
//
// // __________________________________________
// ////////// create coupon ///////////
// // for (int i = 6; i < 10; i++) {
// // Coupon c = new Coupon("coupon-" + i, new Date(), new Date(), 10,
// // CouponType.rnd(), "message-" + i, 10,
// // "image-" + i, compDB.getCompanyByName("company-1").get());
// // try {
// // coupDb.create(c, compDB.getCompanyByName("company-1").get().getId());
// // } catch (CouponExistException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // } catch (CompanyNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // }
//
// // _________________________________________
// // /////////////// DELETE Coupon by ID ///////////////
//
// // try {
// // ArrayList<Coupon> list = compDB.readAllCompanyCoupons(2);
// // for (Coupon coupon : list) {
// // System.out.println(coupon + " || ");
// // }
// // } catch (CompanyNotFoundException | CouponNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// //
// // System.out.println("=========company 1
// // coupons=====================");
// // try {
// // ArrayList<Coupon> list = compDB.readAllCompanyCoupons(1);
// // for (Coupon coupon : list) {
// // System.out.println(coupon + " || ");
// // }
// // } catch (CompanyNotFoundException | CouponNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // coupDb.deleteByCustomer(26);
// // try {
// // System.out.println("=========company 1
// // coupons=====================");
// // try {
// // ArrayList<Coupon> list = compDB.readAllCompanyCoupons(1);
// // for (Coupon coupon : list) {
// // System.out.println(coupon + " || ");
// // }
// // } catch (CouponNotFoundException | CompanyNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // } catch (CouponNotFoundException | CompanyNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // try {
// // coupDb.delete(8, 1);
// // System.out.println("=========company 1
// // coupons=====================");
// // try {
// // ArrayList<Coupon> list = compDB.readAllCompanyCoupons(1);
// // for (Coupon coupon : list) {
// // System.out.println(coupon + " || ");
// // }
// // } catch (CompanyNotFoundException | CouponNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // } catch (CouponNotFoundException | CompanyNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
//
// // ____________________________________
// //////////////// update ///
//
// // try {
// // Coupon testUpdt = coupDb.read(16);
// // testUpdt.setAmount(15);
// // testUpdt.setMessage("this is from save Entity");
// // coupDb.updateEntity(testUpdt);
// //
// // System.out.println("========= After one Save ========");
// // ArrayList<Coupon> list = compDB.readAllCompanyCoupons(5);
// // for (Coupon coupon : list) {
// // System.out.println(coupon + " ||");
// // }
// // System.out.println("========= another try ========");
// // testUpdt.setImage("this is image from reg update");
// // testUpdt.setPrice(55);
// // coupDb.update(testUpdt.getEndDate(), testUpdt.getPrice(),
// // testUpdt.getAmount(), testUpdt.getImage(),
// // testUpdt.getMessage(), 16, 5);
// // ArrayList<Coupon> list2 = compDB.readAllCompanyCoupons(5);
// // for (Coupon coupon : list2) {
// // System.out.println(coupon + " ||");
// // }
// //
// // } catch (CouponNotFoundException | CompanyNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
//
// // ______________________________________--
// ////////// read coupon && read all coupons //////
//
// // try {
// // System.out.println(coupDb.read(16));
// // } catch (CouponNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // System.out.println("============ all coupons now ===============");
// // try {
// // ArrayList<Coupon> list = coupDb.getAllCoupons();
// // for (Coupon coupon : list) {
// // System.out.println(coupon + " ||");
// // }
// // } catch (CouponNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// //
// // System.out.println("============ coupons by type ===============");
// // try {
// // ArrayList<Coupon> typeList = coupDb.getCouponByType(CouponType.FOOD);
// // for (Coupon coupon : typeList) {
// // System.out.println(coupon);
// // }
// // } catch (CouponNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
//
// // _______________ get by coup id && comp id --//
// // try {
// // System.out.println("coupon ==>" + coupDb.getCouponByIdAndCompanyId(2,
// // 33));
// // } catch (CouponNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
//
// // List<Coupon> coupList = null;
// // try {
// // coupList = coupDb.getCouponByTypeAndCompanyId(CouponType.SPORTS, 3);
// // for (Coupon coupon : coupList) {
// // System.out.println("coupon==> " + coupon);
// // }
// // } catch (CouponNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // coupList = coupDb.getCompanyCouponOrderByType(3);
// // for (Coupon coupon : coupList) {
// // System.out.println("coupon==> " + coupon);
// // }
//
// }
// }
