package jpa.coupon.system.facades;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminFadaceTest {

	@Autowired
	AdminFacade admin;

	@Test
	public void contextLoads() {
	}

	@Test
	public void adminFacadeTest() {

		CouponClientFacade s;
		// try {
		// s = admin.login("admin", "admin", Clients.ADMIN);
		// admin = (AdminFacade) s;
		// } catch (AdminExceptions e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//
		// // ============================ COMPANY TESTS ===================
		// // ===============================================================
		//
		// // ________________ create && check duplication___________________//
		// for (int i = 6; i < 7; i++) {
		// System.out.println("=============== check duplication
		// ================");
		//
		// try {
		// Company company = new Company();
		// company.setName("company-" + i);
		// company.setPassword("password" + i);
		// company.setEmail("email@" + i);
		// admin.createCompany(company);
		// } catch (CompanyExistException | AdminExceptions e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// _____________________ get all companies ______________//
		// System.out.println("\n================== list all companies
		// ============");
		// ArrayList<Company> list1;
		// try {
		// list1 = (ArrayList<Company>) admin.getAllCompanies();
		// for (Company company : list1) {
		// System.out.println("==> " + company);
		// }
		// } catch (AdminExceptions | CompanyNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// // __________________________get company && check NONE _________//
		// System.out.println("========== get none comapny ============");
		//
		// try {
		// admin.getCompany(45);
		// } catch (CompanyNotFoundException | AdminExceptions e2) {
		// e2.printStackTrace();
		// }
		// try {
		// System.out.println("========== get comapny 6 before
		// DEL============");
		// System.out.println(admin.getCompany(6));
		// } catch (CompanyNotFoundException | AdminExceptions e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//
		// _________________ remove company && check remove none ____________
		// ///
		// System.out.println("================== remove company to see if
		// coupon on customer is del============");
		// Company c1 = null;
		// try {
		// Company NONE = new Company();
		// NONE.setName("kk");
		// System.out.println("===========================check
		// NONE-------------------");
		// admin.removeCompany(NONE);
		// } catch (CompanyNotFoundException | AdminExceptions e) {
		// e.printStackTrace();
		// }
		// try {
		// c1 = admin.getCompany(3);
		// } catch (CompanyNotFoundException | AdminExceptions e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// System.out.println("company ===>" + c1);
		// // TODO Auto-generated catch block
		// try {
		// System.out.println(" = = = = = = = = delete company-2= id 3 ");
		// admin.removeCompany(c1);
		// } catch (CompanyNotFoundException | AdminExceptions e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("===========================check company NONE del
		// c1 SECond time -------------------");
		// try {
		// admin.removeCompany(c1);
		// } catch (CompanyNotFoundException | AdminExceptions e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("===========================check company NONE
		// read c1 after delete -------------------");
		// try {
		// admin.getCompany(c1.getId());
		// } catch (CompanyNotFoundException | AdminExceptions e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// try {
		// System.out.println("================== list all companies
		// ============");
		// list1 = (ArrayList<Company>) admin.getAllCompanies();
		// System.out.println("==> list ==>" + list1);
		// } catch (AdminExceptions | CompanyNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// ____________ update Company ____________//
		// System.out.println("============ good update id 5 =====");
		// Company company = null;
		// Company checkName = null;
		// try {
		// company = admin.getCompany(5);
		// System.out.println("company 5==>" + company);
		// } catch (CompanyNotFoundException | AdminExceptions e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		// company.setEmail("update me");
		// company.setName("update55good");
		// System.out.println("company 5==>" + company);
		// admin.updateCompany(company);
		// } catch (CompanyNotFoundException | AdminExceptions e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		// checkName = admin.getCompany(7);
		// System.out.println("company 7==>" + checkName);
		// checkName.setName("company-1");
		// System.out.println("company 7==>" + checkName);
		// } catch (CompanyNotFoundException | AdminExceptions e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// try {
		// System.out.println("================ check exist name--> update
		// =======");
		// admin.updateCompany(checkName);
		// } catch (CompanyNotFoundException | AdminExceptions e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// try {
		// System.out.println("================ check exist NONE in--> update
		// =======");
		// Company checkExist = new Company();
		// checkExist.setName("ggggg");
		// admin.updateCompany(checkExist);
		// } catch (CompanyNotFoundException | AdminExceptions e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// // ============================ CUSTOMER TESTS ===================
		// // ================================================================
		//
		// // ________________ create customer
		// System.out.println("=============== check duplication
		// ================");
		// for (int i = 1; i < 10; i++) {
		// try {
		// Customer customer = new Customer();
		// customer.setName("customer-" + i);
		// customer.setPassword("password" + i);
		// admin.createCustomer(customer);
		// } catch (CustomerExistException | AdminExceptions e) {
		// e.printStackTrace();
		// }
		// }
		// _______________&& check duplication___________________//
		// try {
		// Customer customer = new Customer();
		// customer.setName("customer-3");
		// customer.setPassword("password");
		// admin.createCustomer(customer);
		// } catch (CustomerExistException | AdminExceptions e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// // ___________________ get all customers ________//
		// System.out.println("==================== get all customers =====");
		// ArrayList<Customer> custList;
		// try {
		// custList = (ArrayList<Customer>) admin.getAllCustomers();
		// for (Customer customer : custList) {
		// System.out.println("customer ==> " + customer);
		// }
		// } catch (AdminExceptions | CustomerNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("==================== DELETE customer =====");
		//
		// System.out.println("==================== DELETE customer NONE KKK &&
		// null =====");
		// Customer c = new Customer();
		// try {
		// // c.setName("KKK");
		// // admin.removeCustomer(c);
		// admin.createCustomer(c);
		// } catch (AdminExceptions | CustomerExistException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("==================== read customer id=16 =====");
		// try {
		// c = admin.getCustomer(9);
		// System.out.println("customer-2 id 9 ==> " + c);
		// } catch (CustomerNotFoundException | AdminExceptions e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("==================== DELETE customer id 16 //
		// =====");
		//
		// try {
		// admin.removeCustomer(c);
		// } catch (CustomerNotFoundException | AdminExceptions e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("==================== DELETE customer id 16 again
		// =====");
		// try {
		// admin.removeCustomer(c);
		// } catch (CustomerNotFoundException | AdminExceptions e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// // ___________________ update Customer ___________ //
		// Customer c = null;
		// try {
		// System.out.println("======== update null ===== ");
		// admin.updateCustomer(c);
		// } catch (CustomerNotFoundException | AdminExceptions e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// c = new Customer();
		// c.setName("kkk");
		// try {
		// System.out.println("======== update kkk ===== ");
		// admin.updateCustomer(c);
		// } catch (CustomerNotFoundException | AdminExceptions e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//
		// try {
		// c = admin.getCustomer(14);
		// c.setPassword("fromUpdate");
		//
		// } catch (CustomerNotFoundException | AdminExceptions e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		// System.out.println("======== update c ===== ");
		// admin.updateCustomer(c);
		// } catch (CustomerNotFoundException | AdminExceptions e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// try {
		// c = admin.getCustomer(14);
		// System.out.println(c);
		// } catch (CustomerNotFoundException | AdminExceptions e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		// c = admin.getCustomer(144);
		// } catch (CustomerNotFoundException | AdminExceptions e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println(c);
	}

}
