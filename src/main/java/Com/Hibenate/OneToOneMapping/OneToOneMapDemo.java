package Com.Hibenate.OneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		Question q1 = new Question();
		q1.setQusteion("What is Java");
		
		Answer ans1 = new Answer();
		ans1.setAnswerId(0);
		ans1.setAnswer("Java is programming lenguage");
		q1.setAnswer(ans1);
		
		session.save(ans1);
		session.save(q1);
		
		Question q2 = new Question();
		q2.setQusteion("What is Hibernate");
		
		Answer ans2 = new Answer();
		ans2.setAnswerId(1);
		ans2.setAnswer("Hibernate is ORM Framwork");
		q2.setAnswer(ans2);
		session.save(ans2);
		session.save(q2);
		
		
		tx.commit();
		
		session.close();
		
	}

}
