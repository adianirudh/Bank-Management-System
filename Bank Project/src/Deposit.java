import org.hibernate.*;

public class Deposit {

	public static void deposit(int id, double amount) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, id);
		if(customer == null) {
			System.out.println("Data not found for the Id : " + id);
		}else {
			customer.setBalance(customer.getBalance() + amount);
			session.getTransaction().commit();
			System.out.println("Deposit successful");
			System.out.println("Your current balance is : " + customer.getBalance());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int id;
		double depositAmount;
		id = KeyboardUtil.getInt("Enter your Id : ");
		depositAmount = KeyboardUtil.getDouble("Enter the amount you want to deposit : ");
		deposit(id, depositAmount);
		
	}

}
