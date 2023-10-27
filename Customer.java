package Customer_Package;
import java.time.LocalDate;
import Enumm_Package.Service_Plan;


public class Customer implements Comparable <Customer>{
	private static int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double RegAmt;
	private LocalDate dob;
	private Service_Plan Plan;
	
	
	
	public Customer(String firstName,String lastName,String email,String password,double registrationAmount,LocalDate dob,Service_Plan plan){
		super();
		this.customerId=customerId++;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.password=password;
		this.RegAmt=RegAmt;
		this.dob=dob;
		this.Plan=plan;
	}
	
	//Add Overloaded Constructor for Primary Key
	
	public Customer(String email) {
		super();
		this.email=email;
	}
	
	public int getCustomerId() {
		return customerId;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}


	public double getRegAmt() {
		return RegAmt;
	}


	public LocalDate getDob() {
		return dob;
	}


	public Service_Plan getPlan() {
		return Plan;
	}
	
//	@Override
//	public String toString() {
//		return customerId="   "+firstName+"     "+lastName+"       "+email+"      "+password+"     "+registrationAmount+"      "+dob+"      "+Plan+"      ";
//	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", registrationAmount=" + RegAmt + ", dob=" + dob
				+ ", Plan=" + Plan +"Charges="+Plan.getPlan()+ "]";
	}
	
	@Override
	public boolean equals(Object anotherobj) {
		System.out.println("in customer eq ");
		if(anotherobj instanceof Customer)
		return this.email.equals(((Customer)anotherobj).email);
		return false;
	}



	@Override
	public int compareTo(Customer anotherCustomer) {
		System.out.println("in comparesTo: ");
		return this.email.compareTo(anotherCustomer.email);
	}

	public void setPlan(Service_Plan plan) {
		// TODO Auto-generated method stub
		this.Plan=plan;
		
	}

	public void setPassword(String newPassword) {
		// TODO Auto-generated method stub
		this.password=newPassword;
	}
	
}



