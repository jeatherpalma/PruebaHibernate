
import com.worknest.pruebahibernate.entity.Person;
import com.worknest.pruebahibernate.util.HibernateUtil;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


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
        
        /*StoredProcedureQuery query = session.createNamedStoredProcedureQuery("insert_jeather");
        query.setParameter("fname", "Yair");
        query.setParameter("lname", "Herrera");
        query.execute();*/
        
        
        /*StoredProcedureQuery query = session.createNamedStoredProcedureQuery("todos_jeather");
        query.setParameter("id", (long)2);
        query.execute();
        
        String lname = (String)query.getOutputParameterValue("retorno");
        System.out.println("LNAME: " + lname);*/
	
        
        
        
        transaction.commit();
	System.out.println("Data printed");
	sessionFactory.close();
    }
}
