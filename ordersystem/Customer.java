/*Problem Statement:

 * We want to develop a Order Management system.  You have been assigned to work on
part of the system and you will be developing the Customer class.  
 The Customer class has the attributes - id, name, homePhone, cellPhone,
workPhone, street, city, state, zip.
 Create a constructor to create Customer class and it will get the parameters id and
name.
 It should have methods to printPhoneNumbers &amp; printShippingAddress.
 It should have setPrintingAddress method to change the address.  street, city, state
and zip is provided as parameters
 setPhoneNumbers to set the phone numbers.  All 3 phone numbers are provided as
parameters
 Provide a method to print all the values of fields in customer object
Develop another class called CustomerTest.  This class should create 3 Customers and call
each of the Customer methods.
 */

package com.ordersystem;


public class Customer {
	private int customerNumber;
	private String name;
	private String homePhone;
	private String cellPhone;
	private String workPhone;
	private String street;
	private String state;
	private String city;
	private String zipcode;
	
	//private List <PurchaseOrder> pO;
	
	
	//getter & Setter
	public String getHomePhone() {
		return homePhone;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public String getStreet() {
		return street;
	}
	public String getState() {
		return state;
	}
	public String getCity() {
		return city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public List<PurchaseOrder> getpO() {
//		return pO;
//	}
//	public void setpO(List<PurchaseOrder> pO) {
//		this.pO = pO;
//	}
//	
	
	public Customer(int id , String name) 
	{
		this.customerNumber = id;
		this.name = name;
	}
	public Customer(String name2) {
		this.name=name2;
	}
	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", name=" + name + ", homePhone=" + homePhone
				+ ", cellPhone=" + cellPhone + ", workPhone=" + workPhone + ", street=" + street + ", state=" + state
				+ ", city=" + city + ", zipcode=" + zipcode + "]";
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	void printPhoneNumber()
	{
		 System.out.println("--------Phone Details-------");
		 System.out.println("Home Phone: "+homePhone +"\nCell Phone: "+cellPhone+"\nWork Phone: "+workPhone);
	}
	void pringShippingAddress()
	{
		System.out.println("--------Shipping Details-------");
		System.out.println("Street: "+street+",\nCity: "+city+",\nState: "+state+",\nZip Code: "+zipcode);
	}
	
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	void print()
	{
		System.out.println("Customer Details-----------------------------------------");
		System.out.println("Customer Id :"+customerNumber);
		System.out.println("Name :"+name);
		System.out.println("-----Contact No------");
		System.out.println("Home Phone: "+homePhone +"\nCell Phone: "+cellPhone+"\nWork Phone: "+workPhone);
		System.out.println("-----Address-----");
		System.out.println("Street: "+street+",\nCity: "+city+",\nState: "+state+",\nZip Code: "+zipcode);

	}
	

}
