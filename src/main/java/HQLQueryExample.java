import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Com.Hibenate.ManyToManyMapping.Projects;

public class HQLQueryExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from Projects where projectId=1");
		List<Projects> list = q.list();
		for(Projects p : list) {
			System.out.println(p.getPrjectName()+" "+p.getEmpl().get(0).getEmployeeName());
		}
	}

}
