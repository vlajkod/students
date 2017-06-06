package services;

import models.Ispit;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.Iterator;
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

    public static List<Ispit> readOne(int godina) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Ispit> ispiti = null;
        try {
            Query q = session.createQuery("FROM Ispit WHERE godina_roka = :qGodina AND oznaka_roka = :qOznaka");
            q.setInteger("qGodina", godina);
            q.setString("qOznaka",  "okt");
            ispiti = q.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("error readOne");
            e.printStackTrace();
        }
        return ispiti;
    }
}
