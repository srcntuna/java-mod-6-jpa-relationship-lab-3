package org.example;

import org.example.models.Cat;
import org.example.models.Owner;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Main {
    public static void main(String[] args) {
        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();

        Owner owner1 = new Owner();
        owner1.setName("Sercan");

        Owner owner2 = new Owner();
        owner2.setName("James");

        Owner owner3 = new Owner();
        owner3.setName("Youngyo");

        Owner owner4 = new Owner();
        owner4.setName("Olivia");

        Cat cat1 = new Cat();
        cat1.setName("Tofiq");
        cat1.setAge(8);
        cat1.setBreed("british long hair");

        Cat cat2 = new Cat();
        cat2.setName("Pamuk");
        cat2.setAge(8);
        cat2.setBreed("siamese");

        Cat cat3 = new Cat();
        cat3.setName("Zeytin");
        cat3.setAge(5);
        cat3.setBreed("iranese");


        owner1.getCats().add(cat1);
        owner4.getCats().add(cat1);
        owner2.getCats().add(cat2);
        owner3.getCats().add(cat3);

        cat1.getOwners().add(owner1);
        cat1.getOwners().add(owner4);
        cat2.getOwners().add(owner2);
        cat3.getOwners().add(owner3);


        transaction.begin();

        entityManager.persist(owner1);
        entityManager.persist(owner2);
        entityManager.persist(owner3);
        entityManager.persist(owner4);

        entityManager.persist(cat1);
        entityManager.persist(cat2);
        entityManager.persist(cat3);




        transaction.commit();


        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}