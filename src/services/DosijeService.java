package services;

import models.Dosije;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

/**
 * Created by vlajko on 6/1/17.
 */
public class DosijeService {

    public static void readDosije() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<Dosije> dosije = session.createQuery("from Dosije").list();
            for(Dosije d: dosije) {
                System.out.println(d.getIme() + " " + d.getPrezime() + " " + d.getIndeks());
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("dosije error transaction");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
