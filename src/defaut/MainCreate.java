package defaut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreate {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().
				                 configure("hibernate.cfg.xml").
				                 addAnnotatedClass(Professor.class).
				                 addAnnotatedClass(Customer.class).
				                 buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Professor professor = new Professor("002", "Math");
			
			Customer customer = new Customer("Joe", "Los Angeles");
			
			professor.setCustomer(customer);
			
			session.beginTransaction();
			
			System.out.println("Saving professor: " + professor);
			session.save(professor);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			factory.close();
		}		
		
		
	}

}