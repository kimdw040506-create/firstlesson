package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {

    private static final String URL =
            "jdbc:mysql://localhost:3306/test_db?useSSL=false&serverTimezone=UTC";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();

            configuration.setProperty(
                    "hibernate.connection.url",
                    URL);

            configuration.setProperty(
                    "hibernate.connection.username",
                    USERNAME);

            configuration.setProperty(
                    "hibernate.connection.password",
                    PASSWORD);

            configuration.setProperty(
                    "hibernate.connection.driver_class",
                    "com.mysql.cj.jdbc.Driver");

            configuration.setProperty(
                    "hibernate.dialect",
                    "org.hibernate.dialect.MySQL8Dialect");

            configuration.setProperty(
                    "hibernate.show_sql",
                    "true");

            configuration.addAnnotatedClass(User.class);

            sessionFactory =
                    configuration.buildSessionFactory();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}