package Com.Hibenate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Com.Hibenate.Entity.Address;
import Com.Hibenate.Entity.Person;

public class FetchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Address add = (Address)session.get(Address.class,1); //egerLoading
		System.out.println(add.toString());
		
		Person p = (Person)session.load(Person.class, 101); //lazyLoading
		System.out.println(p.getName());
		session.close();
		factory.close();
	}

}
