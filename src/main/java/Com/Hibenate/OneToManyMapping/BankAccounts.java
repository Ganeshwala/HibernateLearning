package Com.Hibenate.OneToManyMapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BankAccounts {

	@Id
	private int bankId;
	
	private String accountType;
	
	private int accountNumber;
	
	@ManyToOne
	private Users user;

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public BankAccounts(int bankId, String accountType, int accountNumber, Users user) {
		super();
		this.bankId = bankId;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.user = user;
	}

	public BankAccounts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
