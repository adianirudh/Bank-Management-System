import org.hibernate.*;

public class TransferMoney {
//	public static void withdraw(double amount) {
//		
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		int senderId, receiverId;
		double amount;
		session.beginTransaction();
		senderId = KeyboardUtil.getInt("Enter sender's Id : ");
		receiverId = KeyboardUtil.getInt("Enter receiver's Id : ");
		
		Customer c1 = (Customer) session.get(Customer.class, senderId);
		Customer c2 = (Customer) session.get(Customer.class, receiverId);
		if(c1 == null || c2 == null) {
			System.out.println("Data not found");
		}else {
			amount = KeyboardUtil.getDouble("Enter the amount you want to transfer from " + c1.getName() + " to " + c2.getName());
			Withdraw.withdraw(senderId, amount);
			Deposit.deposit(receiverId, amount);
			session.getTransaction().commit();
		}
	}

}
