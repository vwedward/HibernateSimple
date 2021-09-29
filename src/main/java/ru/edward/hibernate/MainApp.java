package ru.edward.hibernate;

import org.hibernate.Session;

public class MainApp {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Check database version
//        String sql = "select version()";
        String sql = "select book_title from books where book_id = 1";
//        String sql = "SELECT table_name FROM information_schema.tables LIMIT 1";


        String result = (String) session.createNativeQuery(sql).getSingleResult();
        System.out.println("result=" + result);

        session.getTransaction().commit();
        session.close();


        HibernateUtil.shutdown();
    }
}