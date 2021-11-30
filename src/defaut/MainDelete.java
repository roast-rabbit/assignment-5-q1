package defaut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDelete {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().
				                 configure("hibernate.cfg.xml").
				                 addAnnotatedClass(Professor.class).
				                 addAnnotatedClass(Customer.class).
				                 buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			// get instructor by primary key /id
			int theId = 4;
			Professor tempProfessor = session.get(Professor.class, theId);
			
			System.out.println("Found instructor: " + tempProfessor);
			
			// delete instructors
			if (tempProfessor != null) {
				System.out.println("Deleting: " + tempProfessor);
				session.delete(tempProfessor);
			}
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			factory.close();
		}		
		
		
	}

}