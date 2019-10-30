package hibernate;

import hibernate.entity.Figure;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateApp {
    private SessionFactory factory;

    public HibernateApp() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Figure.class)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        HibernateApp hibernateApp = new HibernateApp();

        try {
            hibernateApp.listAllFigures();
        }
        finally {
            hibernateApp.close();
        }
    }

    private void close() {
        factory.close();
    }

    private void listAllFigures() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        List<Figure> figures = session.createQuery("from hibernate.entity.Figure").getResultList();

        if (figures.isEmpty()) {
            System.out.println("No sections found");
        }
        else {
            for (Figure figure: figures) {
                System.out.println(figure);
            }
        }

        session.getTransaction().commit();
    }
}
