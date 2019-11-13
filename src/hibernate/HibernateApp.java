package hibernate;

import hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateApp {
    private SessionFactory factory;

    private HibernateApp() {
        factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Section.class).
                addAnnotatedClass(Figure.class).
                buildSessionFactory();
    }

    public static void main(String[] args) {
        var hibernateApp = new HibernateApp();

        try {
            hibernateApp.createFigure("Test3", "TestingInfo3");
            //hibernateApp.updateFigure(2, "TestUpdate", "TestingUpdate");
            //hibernateApp.deleteFigure(1);
            hibernateApp.listAllFigures();

            //hibernateApp.createSection(1, "TestHeader", "TestBody");
            //hibernateApp.deleteSection(1);
            //hibernateApp.listAllSections();
        }
        finally {
            hibernateApp.close();
        }
    }

    private void close() {
        factory.close();
    }

    private void createFigure(String name, String info) {
        var session = factory.getCurrentSession();

        session.beginTransaction();

        var figure = new Figure(name, info);
        session.save(figure);

        session.getTransaction().commit();
    }

    private void updateFigure(int id, String name, String info) {
        var session = factory.getCurrentSession();

        session.beginTransaction();

        var figure = session.get(Figure.class, id);

        if (figure == null) {
            System.out.println("Figure with id of " + id + " doesn't exist!");
        }
        else {
            figure.setName(name);
            figure.setInfo(info);
        }

        session.getTransaction().commit();
    }

    private  void deleteFigure(int id) {
        var session = factory.getCurrentSession();

        session.beginTransaction();

        var figure = session.get(Figure.class, id);

        if (figure == null) {
            System.out.println("Figure with id of " + id + " doesn't exist!");
        }
        else {
            figure.setSections(null);
            session.delete(figure);
        }

        session.getTransaction().commit();
    }

    private void listAllFigures() {
        var session = factory.getCurrentSession();

        session.beginTransaction();

        var figures = session.createQuery("from hibernate.entity.Figure").getResultList();

        if (figures.isEmpty()) {
            System.out.println("No figures found");
        }
        else {
            for (var figure: figures) {
                System.out.println(figure);
            }
        }

        session.getTransaction().commit();
    }

    private void createSection(int figureId, String header, String body) {
        var session = factory.getCurrentSession();

        session.beginTransaction();

        var figure = session.get(Figure.class, figureId);
        session.save(figure);
        Section section = new Section(header, body);
        figure.addSection(section);
        session.save(section);

        session.getTransaction().commit();
    }

    private void deleteSection(int id) {
        var session = factory.getCurrentSession();

        session.beginTransaction();

        var section = session.get(Section.class, id);

        if (section == null) {
            System.out.println("Section with id of " + id + " doesn't exist!");
        }
        else {
            session.delete(section);
        }

        session.getTransaction().commit();
    }

    private void listAllSections() {
        var session = factory.getCurrentSession();

        session.beginTransaction();

        var sections = session.createQuery("from hibernate.entity.Section").getResultList();

        if (sections.isEmpty()) {
            System.out.println("No sections found");
        }
        else {
            for (var section: sections) {
                System.out.println(section);
            }
        }

        session.getTransaction().commit();
    }
}
