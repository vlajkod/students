package services;

import models.Ispit;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

/**
 * Created by vlajko on 5/31/17.
 */
public class IspitService {

    public static void readAllIspit() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<Ispit> ispiti = session.createQuery("from Ispit").list();
            for(Ispit i: ispiti) {
                System.out.println(i.getBodovi() + " " + i.getOznaka_roka());
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("ispit error transaction");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
