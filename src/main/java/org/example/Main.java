package org.example;

import org.example.entityH.Address;
import org.example.entityH.Laptop;
import org.example.entityH.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;
import java.util.Objects;


public class Main {
    public static void main(String[] args) {
        try {
            Main main = new Main();
            /*Session session = GetSessionFactory.getSession().openSession();
            if (session.isOpen()) {
                Transaction transaction = session.beginTransaction();
                Student student = new Student();
                student.setsName("Harshang03");

                Laptop laptop = new Laptop();
                laptop.setLaptopName("Dell");

                laptop.setStudent(student);
                student.setLaptop(laptop);

                Address address1 = new Address();
                address1.setAddress("rajkot");
                address1.setStudent(student);

                Address address2 = new Address();
                address2.setAddress("amd");
                address2.setStudent(student);

                student.setAddresses(List.of(address1, address2));

                session.persist(student);
                transaction.commit();
            } else {
                System.out.println("Session is not opened!");
            }
            session.close();*/
            main.displayData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void displayData() {
        Session session = GetSessionFactory.getSession().openSession();
        if (session.isOpen()) {

            /*Criteria criteria = session.createCriteria(Laptop.class);
            criteria.add(Restrictions.eq("id","1"));
            List<Laptop> list = criteria.list();
            for (Laptop laptop : list){
                System.out.println(laptop.getLaptopName());
            }*/

            System.out.println("using parameterized HQLQuery:-  ");
            List<Student> students = session.createQuery("from Student where sId=:sID", Student.class).setParameter("sID", 1).getResultList();
            for (Student student : students) {
                System.out.println("id: " + student.getsId() + " name: " + student.getsName());
            }
            //first level cach
            Student s = session.get(Student.class, 7);
            System.out.println("From first level cache:" + " id: " + s.getsId() + " name: ");

            //fetch type eager
            System.out.println("Fetch type eager:" + " id: " + s.getsId() + " name: " + s.getsName() + " Laptop name: " + s.getLaptop().getLaptopName());
            //named query
            s = (Student) session.getNamedQuery("display2").setParameter(1, 2).getResultList().get(0);
            System.out.println("Using named query: " + " id: " + s.getsId() + " name: " + s.getsName() + " Laptop name: " + s.getLaptop().getLaptopName());

            //native query
            /*SqlQuery sqlQuery = session.createQuery("select sName from Student where sId=2");
            List<Object[]> row = sqlQuery.list();
            System.out.println("native query: name:"+row.get(0));*/
        } else {
            System.out.println("Session is not opened!");
        }
        session.close();
    }
}