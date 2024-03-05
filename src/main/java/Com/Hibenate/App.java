package Com.Hibenate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Com.Hibenate.Entity.Address;
import Com.Hibenate.Entity.Person;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");

		// SessionFactory factory = new
		// Configuration().configure().buildSessionFactory();

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println(factory);

	/*	Person person = new Person();
		person.setPersonId(101);
		person.setName("Chintan Ganeshwala");
		person.setAge(28);*/

		//reading image
		FileInputStream file = new FileInputStream("src/main/java/images/HP9_7965.JPG");
		byte[] imageData = new byte[file.available()];
		file.read(imageData);
		
		Address address = new Address();
		address.setStreet("6 Lienau Place");
		address.setCity("Jersey City");
		address.setMegaCity(true);
		address.setPopulation(1000000);
		address.setDate(new Date());
		address.setImages(imageData);
		
		Session session = factory.getCurrentSession(); // factory.openSession();
		// session.beginTransaction();
		Transaction tx = session.beginTransaction();
		session.save(address);

		tx.commit();

		session.close();
		factory.close();

	}
}
