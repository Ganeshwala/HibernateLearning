package Com.Hibenate.ManyToManyMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo {

	public static void main(String args[]) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		Projects pro = new Projects();
		pro.setProjectId(1);
		pro.setPrjectName("SCM-VesselTracking");
		pro.setProjectCost(35000);
		
		Projects pro1 = new Projects();
		pro1.setProjectId(2);
		pro1.setPrjectName("SCM-AirTracking");
		pro1.setProjectCost(55000);
		
		Projects pro2 = new Projects();
		pro2.setProjectId(3);
		pro2.setPrjectName("SCM-TruckTracking");
		pro2.setProjectCost(25000);
		
		Projects pro3 = new Projects();
		pro3.setProjectId(4);
		pro3.setPrjectName("SCM-TrackingReport");
		pro3.setProjectCost(25000);
		
		Projects pro4 = new Projects();
		pro4.setProjectId(5);
		pro4.setPrjectName("SCM-LiveVision");
		pro4.setProjectCost(65000);
		
		List<Projects> prolist = new ArrayList<Projects>();
		prolist.add(pro);
		prolist.add(pro3);
		
		List<Projects> prolist1 = new ArrayList<Projects>();
		prolist1.add(pro1);
		prolist1.add(pro2);
		
		List<Projects> prolist2 = new ArrayList<Projects>();
		prolist2.add(pro);
		prolist2.add(pro2);
		
		List<Projects> prolist3 = new ArrayList<Projects>();
		prolist3.add(pro);
		prolist3.add(pro1);
		prolist3.add(pro2);
		prolist3.add(pro3);
		prolist3.add(pro4);
		
		Employee emp = new Employee();
		emp.setEmployeeName("Chintan Ganeshwala");
		emp.setProject(prolist);
		
		
		Employee emp1 = new Employee();
		emp1.setEmployeeName("Darin Patel");
		emp1.setProject(prolist1);
		
		
		Employee emp2 = new Employee();
		emp2.setEmployeeName("Akasha Chorasiya");
		emp2.setProject(prolist2);
		
		Employee emp3 = new Employee();
		emp3.setEmployeeName("Venu Gopal");
		emp3.setProject(prolist3);
		
		List<Employee> empListP = new ArrayList<Employee>();
		empListP.add(emp);
		empListP.add(emp2);
		empListP.add(emp3);
		
		List<Employee> empListP1 = new ArrayList<Employee>();
		empListP1.add(emp);
		empListP1.add(emp3);
		
		List<Employee> empListP2 = new ArrayList<Employee>();
		empListP2.add(emp1);
		empListP2.add(emp2);
		empListP2.add(emp3);
		
		List<Employee> empListP3 = new ArrayList<Employee>();
		empListP3.add(emp);
		empListP3.add(emp3);
		
		List<Employee> empListP4 = new ArrayList<Employee>();
		empListP4.add(emp3);
		
		pro.setEmpl(empListP);
		pro1.setEmpl(empListP1);
		pro2.setEmpl(empListP2);
		pro3.setEmpl(empListP3);
		pro4.setEmpl(empListP4);
		
		Transaction tx = session.beginTransaction();
		
		session.save(emp);
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		
		session.save(pro);
		session.save(pro1);
		session.save(pro2);
		session.save(pro3);
		session.save(pro4);
		tx.commit();
		session.close();
		System.out.println("Done");
		
	}
}
