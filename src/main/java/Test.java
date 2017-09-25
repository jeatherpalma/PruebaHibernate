import com.worknest.pruebahibernate.entity.Person;
import com.worknest.pruebahibernate.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Test {
    public static void main(String[] args) {
        
        
        SessionFactory sessFact = HibernateUtil.getSessionFactory();
	Session session = sessFact.getCurrentSession();
	org.hibernate.Transaction tr = session.beginTransaction();
        
        String name = "charro";
        String apellido = "ramirez";
        Person person = new Person(apellido, name);
        session.save(person);
	tr.commit();
	System.out.println("Successfully inserted");
	sessFact.close();
    }
}
