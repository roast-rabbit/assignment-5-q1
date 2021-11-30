package defaut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCustomerDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().
				                 configure("hibernate.cfg.xml").
				                 addAnnotatedClass(Professor.class).
				                 addAnnotatedClass(Customer.class).
				                 buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			
			session.beginTransaction();
			
			int theId = 4;
			Customer tempCustomer = session.get(Customer.class, theId);
			
			// print the customer
			System.out.println("tempCustomer:" + tempCustomer);
			
			// print the associated professor
			System.out.println("the associated professor: " + tempCustomer.getProfessor());
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			session.close();
			
			factory.close();
		}		
		
		
	}

}