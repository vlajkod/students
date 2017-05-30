package utils;

import models.Smer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by vlajko on 5/30/17.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    static {
        try {
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Smer.class);

            sessionFactory = config.buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("SessionFactory error");
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
