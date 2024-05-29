package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchoolExamMain {
    public static void find() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            School school = em.find(School.class, 1L);
            log.info("School Name : {}", school.getName());

            for (Student student : school.getStudents()){
                log.info("Student Name : {}", student.getName());
            }
        }finally {
            em.close();
        }

        Student student = em.find(Student.class, 5L);
        log.info("Student Name : {}", student.getName());
        log.info("School Name : {}", student.getSchool().getName());
    }

    private static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            School school = new School("like School");

            Student student1 = new Student("전준영", school);
            Student student2 = new Student("전나세", school);
            Student student3 = new Student("존도", school);

            school.getStudents().add(student1);
            school.getStudents().add(student2);
            school.getStudents().add(student3);

            em.persist(school);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    private static void update(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            School school = em.find(School.class, 2L);
            school.setName("gyeongseong high school");

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    private static void delete(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            School school = em.find(School.class, 3L);
            em.remove(school);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    public static void main(String[] args) {
        // find();
//        create();
//        update();
        delete();
    }
}
