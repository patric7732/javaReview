package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonExamMain {

    //CRUD
    private static void find() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Passport passport = em.find(Passport.class, 1L);
            log.info("passport number: {}", passport.getPassportNumber());
            log.info("person name: {}", passport.getPerson().getName());

            Person person = em.find(Person.class, 2L);
            log.info("passport number: {}", person.getPassport().getPassportNumber());
            log.info("person name: {}", person.getName());

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    private static void create() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Person person = new Person();
            person.setName("전준영");
            Passport passport = new Passport();
            passport.setPassportNumber("P123456");

            person.setPassport(passport);
            passport.setPerson(person);


        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }

    }

        public static void main (String[]args){
            find();
        }
    }
