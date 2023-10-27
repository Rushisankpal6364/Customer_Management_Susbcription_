package Validation_Package;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;
import Customer_Package.Customer;
import Enumm_Package.Service_Plan;
import Exception_Package.InvalidEmail;
import Exception_Package.InvalidPlan;
import Exception_Package.InvalidRegAmt;



public class Validation_Rules {
	
	public static void Validateplan(String p) throws InvalidPlan {
		boolean flag=false;
		Service_Plan[] arr=Service_Plan.values();
		for(int i=0;i<arr.length;i++) {
			if(arr[i].toString().equals(p));
			flag=true;
			break;
		}
		if(flag==false) {
			throw new InvalidPlan("Invalid plan Selected");
		}
	}
		public static void ValidateRegAmt(Service_Plan plan, double price) throws InvalidRegAmt{
			if(plan.getPlan()!=price) {
				throw new InvalidRegAmt("Price doesn't match to price you entered..!!!!");
			}
		}
		private static void Validateemail(String email) throws InvalidEmail{
			if(!(Pattern.matches("^[a-z).*@gmail.com$",email)));
			throw new InvalidEmail("You entered Invalid Email..!");
		}
		
			
		
	
	
	//Validate all inputs
	public static Customer ValidateAllInputs(String firstName,String lastName,String email,String password,double registrationAmount,LocalDate dob,Service_Plan Plan,
			List<Customer>Customer) throws InvalidPlan, InvalidRegAmt, InvalidEmail{
			ValidateRegAmt(Plan,registrationAmount);
			Validateemail(email);
			//int customerId,String firstName,String lasName,String email,String password,double registrationAmount,LocalDate dob,Service_Plan plan
			return new Customer(firstName, lastName, email, password, registrationAmount, dob,Plan);
		
		
	}

	
}


