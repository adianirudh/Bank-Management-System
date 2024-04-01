import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	int id;
	String name;
	String phone;
	double balance;

	public Customer() {
		
	}

	public Customer(int id, String name, String phone, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.balance = balance;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", balance=" + balance + "]";
	}
}
