package ro.gov.ithub.stopcozi.dao;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ro.gov.ithub.stopcozi.model.repo.*;

/**
 * Created by NiBo on 11/13/2016.
 */
public class DAOTests {

    SessionFactory sessionFactory;
    public DAOTests() {
        Configuration config=new Configuration();
        config.setProperty("hibernate.connection.url","jdbc:h2:~/test");
        config.setProperty("hibernate.connection.username","sa");
        config.setProperty("hibernate.connection.driver_class","org.h2.Driver");
        config.setProperty("hibernate.current_session_context_class", "thread");
        config.setProperty("hibernate.show_sql", "true");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        config.addAnnotatedClass(Agency.class);
        config.addAnnotatedClass(Category.class);
        config.addAnnotatedClass(Service.class);
        config.addAnnotatedClass(ServiceSchedule.class);
        config.addAnnotatedClass(Desk.class);
        config.addAnnotatedClass(Ticket.class);
        sessionFactory=config.buildSessionFactory();
    }

    public Session getSession() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (SessionException se) {
            session = sessionFactory.openSession();
        }
        return session;
    }
}