
import com.worknest.pruebahibernate.entity.Person;
import com.worknest.pruebahibernate.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class GetAddAllData {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        
        CriteriaQuery criteriaQuery = session.getCriteriaBuilder().createQuery(Person.class);
        criteriaQuery.from(Person.class);
        List<Person> personList = session.createQuery(criteriaQuery).getResultList();
        
        for (Person persona : personList) {
                System.out.println("ID: " + persona.getId());
		System.out.println("Name: " + persona.getFname());
                System.out.println("Name: " + persona.getLname());
        }
        
        
        transaction.commit();
	System.out.println("Data printed");
	sessionFactory.close();
    }
}
