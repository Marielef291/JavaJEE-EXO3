package Repository;

import entity.Chien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.SessionFactorySingleton;

import java.util.List;

public class ChienRepository {
    private SessionFactory sessionFactory;
    private Session session;
    
    public ChienRepository() {
        this.sessionFactory = SessionFactorySingleton.getSessionFactory();

    }

    public Chien save(Chien chien) {
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(chien);
            session.getTransaction().commit();
            return chien;
        }catch (Exception ex){
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }
    }

    public boolean delete(Chien chien) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(chien);
            session.getTransaction().commit();
            return true;
        }catch (Exception ex){
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
    }

    public List<Chien> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select c from Chien as c", Chien.class).list();
        }
    }

    public Chien findById(int id) {
        session = sessionFactory.openSession();
        Chien chien = session.get(Chien.class,id);
        session.close();
        return chien;
    }

}
