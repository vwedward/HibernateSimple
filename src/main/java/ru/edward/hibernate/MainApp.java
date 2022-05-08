package ru.edward.hibernate;

import org.hibernate.Session;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ru.edward.hibernate.entity.Movie;

public class MainApp {

    public static void main(String[] args) {
        //Доступ к БД через EntityManager
        //Используется META-INF/persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ru.edward.movie_catalog");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        String sql = "select book_title from books where book_id = 1";
        String result = (String) entityManager.createNativeQuery(sql).getSingleResult();
        System.out.println(result);

        /*Movie movie = new Movie();
        movie.setId(1L);
        movie.setMovieName("The Godfather");
        movie.setReleaseYear(1972);
        movie.setLanguage("English");

        entityManager.persist(movie);*/
        entityManager.getTransaction().commit();
    }

    /*public static void main(String[] args) {
        //Доступ к БД через Session
        //Используется hibernate.cfg.xml
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Check database version
        //String sql = "select version()";
        String sql = "select book_title from books where book_id = 1";
        //String sql = "SELECT table_name FROM information_schema.tables LIMIT 1";

        String result = (String) session.createNativeQuery(sql).getSingleResult();
        System.out.println("result=" + result);

        session.getTransaction().commit();
        session.close();

        HibernateUtil.shutdown();
    }*/
}