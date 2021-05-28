package Controller;

import javafx.scene.control.ComboBox;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class userControl {

    // Constructor
    public userControl(){
    }

    public void addingUser(String fName, String middle, String lName, String id, String number, String email){

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        Person person = new Person(new Name(fName, middle, lName), number, email, Integer.parseInt(id));

        entitymanager.persist(person);
        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
    }

    public void closeContact(ComboBox person1, ComboBox person2, LocalDate date, String time){
        String combo1;
        String combo2;

        combo1 = (String) person1.getSelectionModel().getSelectedItem();
        combo2 = (String) person2.getSelectionModel().getSelectedItem();

        String combo1ID = combo1.split(" ")[1];

        String combo2ID = combo2.split(" ")[1];

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        Contact contact = new Contact(Integer.parseInt(combo1ID), Integer.parseInt(combo2ID), date, time);

        entitymanager.persist(contact);
        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
    }

    public String findAll(){
        String users = "";

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emfactory.createEntityManager();

        Query query = entityManager.createNativeQuery("Select * FROM Person");
        List<Object[]> people = query.getResultList();

        for (Object[] p : people){
            users += "ID: "+ p[0] + " Name: " + p[3] + " " + p[5] + " " + p[4] + " Email: " + p[1] + " Phone: " + p[2] + "\n";
        }
        return users;
    }

    public String findContact(){
        String users = "";

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA"); // Creates a persistence unit using the one we made in persistence.xml
        EntityManager entityManager = emfactory.createEntityManager(); // Creates a transaction

        Query query = entityManager.createNativeQuery("Select * from contact"); // We run enter the SQL Query
        List<Object[]> people = query.getResultList(); // We store the result of the query in a List object

        for (Object[] p : people){ // For each loop here to go through all of the people we got in the list
            users += "User: " + p[2] + " had a close contact with " + p[0] + " on " + p[1] + " at " + p[3] + "\n"; // Format the output so it looks nicely
        }
        return users; // Return the users we got which we can then print
    }

    public void removeUserClose(int id){
        // Remove person from database
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emfactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createNativeQuery("DELETE FROM contact WHERE ID1 = ?");
        query.setParameter(1, id);

        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public void removeUser(int id){
         //Remove person from close contact database
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    public String searchUserName(String name){
        String names = "";

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emfactory.createEntityManager();

        Query query = entityManager.createNativeQuery("Select * FROM Person n WHERE n.FIRSTNAME = ?");
        query.setParameter(1, name);
        List<Object[]> person = query.getResultList();

        for (Object[] p : person){
            names = "ID: "+ p[0] + " Name: " + p[3] + " " + p[5] + " " + p[4] + " Email: " + p[1] + " Phone: " + p[2];
        }

        return names;
    }

    public String searchUserId(int id){
        String names = "";

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emfactory.createEntityManager();

        Query query = entityManager.createNativeQuery("Select * FROM Person WHERE ID = ?");
        query.setParameter(1, id);
        List<Object[]> person = query.getResultList();

        for (Object[] p : person){
            names = "ID: "+ p[0] + " Name: " + p[3] + " " + p[5] + " " + p[4] + " Email: " + p[1] + " Phone: " + p[2];
        }
        return names;
    }

    public String orderDate(int id, LocalDate date2) {
        String date1String = "";

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emfactory.createEntityManager(); // Creates a transaction

        Query query = entityManager.createNativeQuery("Select * from contact where ID1 = ?");
        query.setParameter(1, id);

        List<Object[]> people = query.getResultList();

        for (Object[] p : people){
            date1String +=  p[1];
        }

        LocalDate date1 = LocalDate.parse(date1String); // Convert the date from String to LocalDate

        int result = date1.compareTo(date2);
        if (0 == result){
            result = date1.compareTo(date2);
            result = ((-1) * result);
        }

        return "";
    }

}
