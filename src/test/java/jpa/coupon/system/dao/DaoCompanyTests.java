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
// public class DaoCompanyTests {
//
// @Autowired
// private CompanyDBDAO compDb;
//
// @Test
// public void contextLoads() {
// }
//
// @Test
// public void companyTestDBDAO() {
//
// // __________________________________________//
// //////////////// CompanyDBDAO ///////////////
//
// // _________________________________
// // ///////Create companies //////
// // try {
// // compDb.create(new Company("Aroma", "1234", "aroma@gmail.com"));
// // } catch (CompanyExistException e1) {
// // // TODO Auto-generated catch block
// // e1.printStackTrace();
// // }
// // try {
// // compDb.create(new Company("IDSoftware", "1234",
// // "IDSoftware@gmail.com"));
// // } catch (CompanyExistException e) {
// // System.out.println(e.getMessage());
// // }
// // try {
// // compDb.create(new Company("sofaman", "1234", "sofaman@gmail.com"));
// // } catch (CompanyExistException e) {
// // System.out.println(e.getMessage());
// // }
// // try {
// // compDb.create(new Company("company-1", "password",
// // "company-1@gmail.com"));
// // } catch (CompanyExistException e1) {
// // // TODO Auto-generated catch block
// // e1.printStackTrace();
// // }
//
// // _________________________________
// /////////// DELETE company//////////
// // try {
// // compDb.delete(6);
// // } catch (CompanyNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
//
// // ___________________________________________________
// /////////// update only password && email/////////
// // try {
// // compDb.update("password", "company-2@email", 2);
// // } catch (CompanyNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// // __________________________________
// /////// update by save method && read methods////
// // Optional<Company> c;
// // try {
// // c = compDb.read(2);
// // System.out.println(c.get());
// // c.get().setEmail("fromOptional@@");
// // c.get().setName("company-2");
// // c.get().setPassword("password");
// // System.out.println(c.get());
// // compDb.updateSave(c.get());
// // } catch (CompanyNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
//
// // ____________________________________
// /////// read all companies ////////
// // System.out.println("=============read all ===========");
// // try {
// // ArrayList<Company> list = compDb.readAllCompanies();
// // if (list != null) {
// // for (Company comp : list) {
// // System.out.println(comp);
// // System.out.println("======================");
// // }
// // }
// // } catch (CompanyNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
//
// // _______________________________
// // ////////////// login & Get by name//////////
// // System.out.println("=============login===========");
// // System.out.println(compDb.login("oren", "password"));
// // System.out.println(compDb.login("company-2", "oren"));
// // System.out.println(compDb.login("company-2", "password"));
// //
// // if (compDb.getCompanyByName("company-2").isPresent()) {
// // System.out.println("get by name company-2 --> " +
// // compDb.getCompanyByName("company-2").get());
// // }
// // if (compDb.getCompanyByName("company-99").isPresent()) {
// // System.out.println("get by name company-99 --> " +
// // compDb.getCompanyByName("company-99").get());
// // }
// //
//
// // ______________________________________
// /////////// read all company's coupons ///////
//
// // try {
// // System.out.println("============read all coupon of
// // company-1=============");
// // ArrayList<Coupon> c = compDb.readAllCompanyCoupons(2);
// // for (Coupon coupon : c) {
// // System.out.println(coupon);
// // System.out.println("===========");
// // }
// // } catch (CompanyNotFoundException | CouponNotFoundException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// }
// }
