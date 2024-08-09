package exam4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MemberDelete {
	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			Member4 user = em.find(Member4.class, "faker@skt.t1");
			
			if(user == null) {
				System.out.println("Is not Exist!!");
				return;
			}
			
			em.remove(user);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();			
		}
	}
}
