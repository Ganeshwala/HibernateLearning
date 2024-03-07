package Com.Hibenate.OneToManyMapping;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	private String username;
	
	private String password;
	
	private int age;
	
	@OneToMany(mappedBy = "user")
	private List<BankAccounts> accounts;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int userId,String username,  String password, int age, List<BankAccounts> accounts) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.age = age;
		this.accounts = accounts;
	}

	public List<BankAccounts> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccounts> accounts) {
		this.accounts = accounts;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return username;
	}
	
	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	
	
}
