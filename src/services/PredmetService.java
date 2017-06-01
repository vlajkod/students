package services;

import models.Predmet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

/**
 * Created by vlajko on 6/1/17.
 */
public class PredmetService {

    public static void readPredmet() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<Predmet> predmeti = session.createQuery("from Predmet").list();
            for(Predmet p: predmeti) {
                System.out.println(p.getNaziv() + " " + p.getBodovi());
            }
            transaction.commit();
        } catch (Exception e) {
            System.err.println("transaction predmet error");
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
