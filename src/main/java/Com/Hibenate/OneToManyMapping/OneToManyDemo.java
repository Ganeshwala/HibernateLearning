package Com.Hibenate.OneToManyMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory =  cfg.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		// create user details
		Users u1 = new Users();
		u1.setUserName("Qwerty");
		u1.setPassword("12345vsd");
		u1.setAge(24);
		
		BankAccounts account = new BankAccounts();
		account.setBankId(1);
		account.setAccountType("Checking");
		account.setAccountNumber(1233123);
		account.setUser(u1);
		
		BankAccounts account2 = new BankAccounts();
		account2.setBankId(2);
		account2.setAccountType("Saving");
		account2.setAccountNumber(1233523);
		account2.setUser(u1);
		
		BankAccounts account3 = new BankAccounts();
		account3.setBankId(3);
		account3.setAccountType("Checking");
		account3.setAccountNumber(1233123);
		account3.setUser(u1);
		
		List<BankAccounts> bankAccount = new ArrayList<BankAccounts>();
		bankAccount.add(account);
		bankAccount.add(account2);
		bankAccount.add(account3);
		u1.setAccounts(bankAccount);
		
		session.save(account);
		session.save(account2);
		session.save(account3);
		session.save(u1);
		
		tx.commit();
		
		session.close();
		
	}

}
