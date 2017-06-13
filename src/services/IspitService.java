package services;

import models.Dosije;
import models.DosijeView;
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


    public static List<Predmet> readPredmeti(int godina) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Predmet> predmeti = null;

        try {
            Query q = session.getNamedQuery("Ispit.byPredmet");
            q.setInteger("godina", godina);
            q.setString("tip", "X");
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

    public static List<DosijeView> readDosije(int idPredmeta, int godinaRoka) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<DosijeView> dosijeView = null;

        try {
            Query q = session.getNamedQuery("Ispit.byDosije");
            q.setInteger("idPredmeta", idPredmeta);
            q.setInteger("godinaRoka", godinaRoka);
            q.setString("tip", "X");
            dosijeView = q.list();
            transaction.commit();
        } catch (Exception e) {
            System.err.println("transaction predmet error");
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return dosijeView;
    }
}
