import org.hibernate.*;

public class AccountOpening {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int id;
		double balance;
		String name, phone;
		id = KeyboardUtil.getInt("Enter the Id : ");
		name = KeyboardUtil.getString("Enter your name : ");
		phone = KeyboardUtil.getString("Enter your phone number : ");
		System.out.println("For account opening you have deposit the minimum balance i.e >= 1000");
		balance = KeyboardUtil.getDouble("Enter the amount to deposit : ");
		while(balance < 1000) {
			System.out.println("please deposit >= 1000");
			balance = KeyboardUtil.getDouble("Enter the amount to deposit : ");
		}
		
		Customer customer = new Customer(id, name, phone, balance);
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(customer);
			tx.commit();
			System.out.println("Account created successfulyy");
			System.out.println("data saved to db");
		}catch(HibernateException e) {
			tx.rollback();
			System.out.println("There was an error while creating account");
			System.out.println(e.getMessage());
		}
		session.close();
	}

}
