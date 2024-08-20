package application;

import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {

    public static void main(String[] args) {

        EntityManagerFactory eFactory = Persistence.createEntityManagerFactory("demo-jpa");
        EntityManager eManager = eFactory.createEntityManager();

        eManager.getTransaction().begin();
        Person p = eManager.find(Person.class , 3);
        eManager.remove(p);
        System.out.println(p);
        System.out.println("removed");
        eManager.getTransaction().commit();

        eManager.close();
        eFactory.close();
    }
}
