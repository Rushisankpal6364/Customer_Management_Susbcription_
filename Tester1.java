package Tester_Package;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import Admin_Package.Admin;
import CustRepo_Package.CustRepo;
import Customer_Package.Customer;
import Enumm_Package.Service_Plan;
import Exception_Package.InvalidEmail;
import Exception_Package.InvalidCredentials;
import Exception_Package.InvalidPlan;
import Exception_Package.InvalidRegAmt;
import Validation_Package.Validation_Rules;



public class Tester1 {

	public static void main(String[] args)
	throws InvalidPlan, InvalidRegAmt, InvalidEmail{
		String firstname,name;
		String lastname;
		String email;
		String password,newPassword;
		double RegAmt;
		LocalDate dob;
		ArrayList<Customer>Customers=new ArrayList<>();
		Customer dummy=new Customer("Rushikesh","Sankpal","r@gmail.com","rushhh",1000,LocalDate.now(),Service_Plan.valueOf("SILVER"));
		Customers.add(dummy);
		int choice;
		Customer c,cust=null;
		
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("1.Signup Customer");
			System.out.println("2.Login");
			System.out.println("3.Display Customer's");
			System.out.println("4.Check Available Plans");
			System.out.println("5.Find particular Customer");
			System.out.println("6.Change Password");
			System.out.println("7.Unsubscribe Plan");
			System.out.println("8.Delete Customer");
			System.out.println("Exit");
			choice=sc.nextInt();
			
			try {
				switch(choice) {
				case 1:
					System.out.println("Enter firstname :");
					firstname=sc.next();
					System.out.println("Enter lastname :");
					lastname=sc.next();
					System.out.println("Enter email :");
					email=sc.next();
					System.out.println("Enter password :");
					password=sc.next();
					System.out.println("Enter RegAmt :");
					RegAmt=sc.nextDouble();
					System.out.println("Enter dob :");
					dob=LocalDate.parse(sc.next());
					System.out.println("Enter a plan(SILVER/GOLD/DIAMOND/PLATINUM)");
					String plan = sc.next();
					
					
					c = Validation_Rules.ValidateAllInputs(firstname,lastname,email,password,RegAmt,dob,Service_Plan.valueOf(plan.toUpperCase()),Customers);
					Customers.add(c);
					break;
					
				case 2:
				
					System.out.println("Enter email");
					email = sc.next();
					CustRepo.findByemail(email, Customers);
					System.out.println("Enter password");
					password = sc.next();
					cust = CustRepo.InvalidCredentials(email, password, Customers);

					System.out.println("Login successful");
					System.out.println("want to edit your subscription ? (Y/N):");
					char val = sc.next().charAt(0);
					if (val == 'Y') {
						System.out.println("Enter new plan name");
						plan = sc.next();
						cust.setPlan(Service_Plan.valueOf(plan));
						System.out.println("Plan updated successfully..");
					}else {
						System.out.println("Loggin off....");
					}

					break;
				case 3:
					if(Customers.isEmpty()) {
						System.out.println("No users found!");
						break;
					}
					for (Customer c1 : Customers) {
						System.out.println(c1);
					}
					break;
				case 4:
					for (Service_Plan e : Service_Plan.values()) {
						System.out.println(e.toString() + "---->" + e.getPlan());
					}
					break;
				case 5:
					System.out.println("Enter admin credentials");
					System.out.println("Enter username:");
					name=sc.next();
					System.out.println("Enter password:");
					password=sc.next();
					if(name.equals(Admin.getUserName())&&password.equals(Admin.getPassword()))
					{
						System.out.println("Logged in as admin");
					}else {
						throw new InvalidCredentials("Authentication failed!");
					}
					System.out.println("Enter email :"); {
					email = sc.next();
					System.out.println(CustRepo.findByemail(email, Customers));
					break;
				}
				case 6:
					System.out.println("Enter email :");
					email = sc.next();
					CustRepo.findByemail(email, Customers);
					System.out.println("Enter old password:");
					password = sc.next();
					cust = CustRepo.InvalidCredentials(email, password, Customers);
					System.out.println("Enter new password");
					newPassword = sc.next();
					cust.setPassword(newPassword);
					System.out.println("Password updated successfully.");
					break;
				case 7:
					System.out.println("Enter email");
					email = sc.next();
					CustRepo.findByemail(email, Customers);
					System.out.println("Enter password");
					password = sc.next();
					cust = CustRepo.InvalidCredentials(email, password, Customers);
					System.out.println("Login successful");
					cust.setPlan(Service_Plan.NONE);
					System.out.println("Unsubscribed");
					break;
				case 8:
					System.out.println("Enter admin credentials");
					System.out.println("Enter username:");
					name=sc.next();
					System.out.println("Enter password:");
					password=sc.next();
					if(name.equals(Admin.getUserName())&&password.equals(Admin.getPassword()))
					{
						System.out.println("Logged in as admin");
	                } else {
					throw new InvalidCredentials("Authentication failed!");
					}
					System.out.println("Enter email");
					cust=CustRepo.findByemail(sc.next(), Customers);
					Customers.remove(cust);
					System.out.println("Deleted customer");
					break;
				case 9:
					System.out.println("Qutting...");
					break;
				default:
					System.out.println("Invalid option!");
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (choice != 9);
		sc.close();
	}

}