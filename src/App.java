import models.Smer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import services.IspitService;
import services.SmerService;
import utils.HibernateUtil;

import java.util.List;


/**
 * Created by vlajko on 5/30/17.
 */
public class App {

    public static void main(String args[]) {
        System.out.println("Start App Here");

//        SmerService.readSmer();
        IspitService.readAllIspit();
        HibernateUtil.getSessionFactory().close();
        System.out.println("Kraj");


    }

}
