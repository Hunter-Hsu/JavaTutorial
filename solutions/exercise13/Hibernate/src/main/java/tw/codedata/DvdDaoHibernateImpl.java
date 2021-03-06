package tw.codedata;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DvdDaoHibernateImpl implements DvdDao {

    private SessionFactory sessionFactory;

    public DvdDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveDvd(Dvd dvd) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(dvd);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Dvd> allDvds() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
         List<Dvd> dvds = session.createQuery("from Dvd").list();
        
        session.getTransaction().commit();
        session.close();
        
        return dvds;
    }

}
