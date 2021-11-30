package defaut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCustomerDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Customer.class)
									 .buildSessionFactory();
					
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save java object
			System.out.println("Creating new customer object...");
			
			// create a customer object
			Customer tempCustomer = new Customer("mmm", "irvine");
			Customer tempCustomer1 = new Customer("666", "los angeles");
			// start a transaction
			session.beginTransaction();
			
			// save the customer object
			System.out.println("Saving the customer...");
			
			session.save(tempCustomer);
		
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
