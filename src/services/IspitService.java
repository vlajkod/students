package services;

import models.Dosije;
import models.Ispit;
import models.Predmet;
import org.hibernate.Query;
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
            for (Ispit i : ispiti) {
                System.out.println(i.getBodovi() + " " + i.getOznakaRoka());
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
            q.setString("qOznaka", "okt");
            ispiti = q.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("error readOne");
            e.printStackTrace();
        }
        return ispiti;
    }

    public static List<Predmet> readPredmeti(int godina) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Predmet> predmeti = null;

        try {
            Query q = session.getNamedQuery("Ispit.byPredmet");
            q.setInteger("godina", godina);
            q.setString("oznaka", "okt");
            predmeti = q.list();
            transaction.commit();
        } catch (Exception e) {
            System.err.println("transaction predmet error");
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return predmeti;
    }

    public static List<Dosije> readDosije(int idPredmeta) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Dosije> dosije = null;

        try {
            Query q = session.getNamedQuery("Ispit.byDosije");
            q.setInteger("idPredmeta", idPredmeta);
            dosije = q.list();
            transaction.commit();
        } catch (Exception e) {
            System.err.println("transaction predmet error");
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return dosije;
    }
}
