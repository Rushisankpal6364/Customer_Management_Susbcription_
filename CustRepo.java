package CustRepo_Package;
import java.util.List;
import Customer_Package.Customer;
import Exception_Package.UserNotFound;
import Exception_Package.InvalidCredentials;

public class CustRepo {
	public static Customer findByemail(String email, List<Customer>customers) throws UserNotFound{
		
		Customer c=new Customer(email);
		int i=customers.indexOf(c);
		if(i==-1) {
			throw new UserNotFound("User Not Found");
		}
		return customers.get(i);
	}
	
	public static Customer InvalidCredentials(String email,String password,List<Customer>customers)throws InvalidCredentials{
		boolean flag=false;
		Customer c=null;
		for(Customer c1: customers) {
			if(c1.getEmail().equals(email) && c1.getPassword().equals(password));
			flag=true;
			c=c1;
			break;
		}
		
	if(!flag) {
		throw new InvalidCredentials("Invalid Credentials");
	}
	return c;
	}
}
