import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Com.Hibenate.Entity.Person;
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
		// Join Query Example
		Query q1 = session.createQuery("select e.empId,e.employeeName,p.projectId,p.prjectName from Employee e Inner Join e.project as p where p.prjectName not like 'SCM-VesselTracking'");
		List<Object[]> joinList = q1.list();
		for(Object[] res : joinList) {
			System.out.println(Arrays.toString(res));
		}
		
		//Pagination Query Example 
		Query q2 = session.createQuery("from Person");
		q2.setFirstResult(0); // from where we can to fetch result in DB here i give 0 means it start fetching result from 0 index of DB table
		q2.setMaxResults(5); // upto how many result we want to fetch it from DB table
		
		List<Person> person = q2.getResultList(); // we can also use getResultList() it work same as list()
		for(Person p : person) {
			System.out.println(p.getName());
		}
		tx.commit();
		session.close();
	}

}
