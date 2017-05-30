import models.Smer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

/**
 * Created by vlajko on 5/30/17.
 */
public class App {

    public static void main(String args[]) {
        System.out.println("Start App Here");

        readSmer();

        HibernateUtil.getSessionFactory().close();
        System.out.println("Kraj");


    }

    public static void readSmer() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Transaction transaction = session.beginTransaction();

        try {
            List<Smer> smerovi = session.createQuery("from Smer").list();
            for(Smer smer: smerovi) {
                System.out.println(smer.getId_smera() + " " + smer.getNaziv());
            }
            transaction.commit();
        } catch (Exception e) {
            System.err.println("error transaction");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
