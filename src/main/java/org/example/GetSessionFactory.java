package org.example;

import org.example.entityH.Address;
import org.example.entityH.Laptop;
import org.example.entityH.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;

public class GetSessionFactory {
    private GetSessionFactory() {
    }

    public static SessionFactory getSession() {
        Map<String, Object> settings = new HashMap<>();
        settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
        settings.put("dialect", "org.hibernate.dialect.MySQL5Dialect");
        settings.put("hibernate.connection.url", "jdbc:mysql://localhost/HibernatePractice");
        settings.put("hibernate.connection.username", "root");
        settings.put("hibernate.connection.password", "12345678");
        settings.put("hibernate.current_session_context_class", "thread");
        settings.put("hibernate.show_sql", "true");
        settings.put("hibernate.hbm2ddl.auto", "update");
        //settings.put("hibernate.format_sql", "true");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(Student.class);
        metadataSources.addAnnotatedClass(Laptop.class);
        metadataSources.addAnnotatedClass(Address.class);
        Metadata metadata = metadataSources.buildMetadata();
        return metadata.getSessionFactoryBuilder().build();
    }
}