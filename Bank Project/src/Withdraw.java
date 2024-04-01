import org.hibernate.*; 

public class Withdraw {
	public static void withdraw(int id, double amount) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, id);
		if(customer == null) {
			System.out.println("Data not found for the Id : " + id);
		}else {
			if(amount > customer.getBalance()) {
				System.out.println("Insufficient balance");
			}
			customer.setBalance(customer.getBalance() - amount);
			session.getTransaction().commit();
			System.out.println("Withdraw successful");
			System.out.println("Your current balance is : " + customer.getBalance());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int id;
		double withdrawAmount;
		
		id = KeyboardUtil.getInt("Enter your Id : ");
		withdrawAmount = KeyboardUtil.getDouble("Enter the amount you want to withdraw : ");
		
		withdraw(id, withdrawAmount);
	}

}
