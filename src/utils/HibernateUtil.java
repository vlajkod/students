package utils;

import models.Dosije;
import models.Ispit;
import models.IspitniRok;
import models.Predmet;
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
                    .addAnnotatedClass(Ispit.class)
                    .addAnnotatedClass(Predmet.class)
                    .addAnnotatedClass(Dosije.class)
                    .addAnnotatedClass(IspitniRok.class);

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
