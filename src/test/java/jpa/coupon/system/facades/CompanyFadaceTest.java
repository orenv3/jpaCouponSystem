// package jpa.coupon.system.facades;
//
// import java.util.Calendar;
// import java.util.Date;
//
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;
//
// import jpa.coupon.system.general.Clients;
// import jpa.coupon.system.myExceptions.CompanyNotFoundException;
//
// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class CompanyFadaceTest {
//
// @Autowired
// CompanyFacade compFacade;
//
// final int start = 1;
// final int end = 2;
//
// private Date rndStartDate(int date) {
// int yearMax = 0;
// int yearMin = 0;
// if (date == end) {
// yearMax = 2022;
// yearMin = 2018;
// } else {
// yearMax = 2017;
// yearMin = 2014;
// }
//
// Calendar calStrat = Calendar.getInstance();
// int year = (int) (Math.random() * (yearMax - yearMin) + yearMin);
// int month = (int) (Math.random() * (12 - 1) + 1);
// int day = (int) (Math.random() * (28 - 1) + 1);
// calStrat.set(year, month, day);
// java.util.Date sDate = calStrat.getTime();
// return sDate;
// }
//
// @Test
// public void contextLoads() {
// }
//
// @Test
// public void companyFacadeTest() {
//
// try {
// CouponClientFacade cf = compFacade.login("company-1", "password1",
// Clients.COMPANY);
// compFacade = (CompanyFacade) cf;
// } catch (CompanyNotFoundException e) {
// e.printStackTrace();
// }
// // ______________________ get company form facade ____________//
// // try {
// // Company c1 = compFacade.getCompany();
// // System.out.println("compFacade Company==>" + c1);
// // } catch (CompanyNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
//
// // _________________ create coupons && check duplication ____//
// // for (int i = 8; i < 10; i++) {
// // Coupon c = new Coupon();
// // c.setTitle("coupon-" + i);
// // c.setAmount(12);
// // c.setStartDate(rndStartDate(start));
// // c.setEndDate(rndStartDate(end));
// // c.setMessage("test coupon" + i);
// // c.setPrice((int) (Math.random() * 200));
// // c.setType(CouponType.rnd());
// // c.setImage("image" + i);
// // try {
// // compFacade.createCoupon(c);
// // } catch (CompanyNotFoundException | CouponExistException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // System.out.println("============= check coupon name empty
// // ============");
// // Coupon checkName = new Coupon();
// // try {
// // compFacade.createCoupon(checkName);
// // } catch (CompanyNotFoundException | CouponExistException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // System.out.println("============= check coupon is null
// // ============");
// // Coupon checkNull = null;
// // try {
// // compFacade.createCoupon(checkNull);
// // } catch (CompanyNotFoundException | CouponExistException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
//
// //// ____________ get coupon ______________//
// // ____________ get coupon -> try to get coupon that company do not owns
// // Coupon itIsCoupon19 = null;
// // System.out.println("get coupon - try to get coupon that company do
// // not owns");
// // try {
// // itIsCoupon19 = compFacade.getCoupon(19);
// // System.out.println("itIsCoupon19 ==>" + itIsCoupon19);
// // } catch (CouponNotFoundException | CompanyNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // Coupon notInDB = null;
// // System.out.println("=============== get coupon - try to get notInDB
// // coupon ");
// // try {
// // notInDB = compFacade.getCoupon(222);
// // System.out.println("notInDB ==>" + notInDB);
// // } catch (CouponNotFoundException | CompanyNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// //
// // // ____________ update coupon _______________//
// // // ____ update coupon -> try to update coupon that company do not
// // owns
// // // _ itIsCoupon19__//
// // try {
// // System.out.println("update coupon itIsCoupon19 - try to update coupon
// // that company do not owns");
// // compFacade.updateCoupon(itIsCoupon19);
// // } catch (CouponNotFoundException | CompanyNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// //
// // // ____________ update notInDB coupon _____ //
// // try {
// // System.out.println("update coupon notInDB - try to update coupon that
// // not in DB");
// // compFacade.updateCoupon(notInDB);
// // } catch (CouponNotFoundException | CompanyNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // // ____________ update null coupon __________//
// // Coupon itIsNull = null;
// // try {
// // System.out.println("update coupon itIsNull
// // -=========================");
// // compFacade.updateCoupon(itIsNull);
// // } catch (CouponNotFoundException | CompanyNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // Coupon checkGood9 = null;
// // // ___________ good get coupon 25 && good update _____//
// // Coupon checkGood9 = null;
// // try {
// // checkGood9 = compFacade.getCoupon(18);
// // System.out.println("coupon-18 ==> " + checkGood9);
// // } catch (CouponNotFoundException | CompanyNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // System.out.println("==================remove coupon
// // 18=================");
// // try {
// // compFacade.removeCoupon(checkGood9);
// // } catch (CompanyNotFoundException | CouponNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// //
// // System.out.println("==================remove coupon 18
// // again=================");
// // try {
// // compFacade.removeCoupon(checkGood9);
// // } catch (CompanyNotFoundException | CouponNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// //
// // System.out.println("==================remove coupon null
// // =================");
// // try {
// // compFacade.removeCoupon(null);
// // } catch (CompanyNotFoundException | CouponNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // checkGood9.setAmount(25);
// // checkGood9.setMessage("company4 owns coupon9");
// // try {
// // System.out.println("update coupon");
// // compFacade.updateCoupon(checkGood9);
// // } catch (CouponNotFoundException | CompanyNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // ____________________ lists tests ____________ //
// // List<Coupon> couponList = null;
// // System.out.println("=========================================");
// // try {
// // couponList = compFacade.getAllCoupons();
// // for (Coupon coupon : couponList) {
// // System.out.println("coupon ==>" + coupon);
// // }
// // } catch (CouponNotFoundException | CompanyNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // System.out.println("=========================================");
// // try {
// // couponList = compFacade.getCompanyCouponsOrderByType();
// // for (Coupon coupon : couponList) {
// // System.out.println("coupon ==>" + coupon);
// // }
// // } catch (CouponNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // System.out.println("=========================================");
// // try {
// // couponList = compFacade.getCouponBySpecificType(CouponType.SPORTS);
// // for (Coupon coupon : couponList) {
// // System.out.println("coupon ==>" + coupon);
// // }
// // } catch (CouponNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// }
//
// }
