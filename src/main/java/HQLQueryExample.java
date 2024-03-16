import java.util.Arrays;
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
		//Query q = session.createQuery("from Projects where projectId=1"); //direct Query like HQL
		//example of writing HQl with parameter passing
		Query q = session.createQuery("from Projects where projectId = :x ");
		q.setParameter("x", 1);
		List<Projects> list = q.list();
		for(Projects p : list) {
			System.out.println(p.getPrjectName()+" "+p.getEmpl().get(1).getEmployeeName());
		}
		
		Query q1 = session.createQuery("select e.empId,e.employeeName,p.projectId,p.prjectName from Employee e Inner Join e.project as p where p.prjectName not like 'SCM-VesselTracking'");
		List<Object[]> joinList = q1.list();
		for(Object[] res : joinList) {
			System.out.println(Arrays.toString(res));
		}
	}

}
