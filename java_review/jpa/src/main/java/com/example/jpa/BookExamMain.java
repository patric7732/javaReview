package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookExamMain {
    public static void main(String[] args) {
//        find();
//        create();
//        update();
        delete();

    }

    private static void find(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Author author = em.find(Author.class, 1L);
            log.info("지은이 이름 : "+author.getName());

            for (Book book : author.getBooks()) {
                log.info("책제목: "+book.getTitle());
            }

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    private static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Author author = new Author("존나세");

            Book book = new Book("모두의 자바",author);

            author.getBooks().add(book);

            em.persist(author);

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    private static void update(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Author author = em.find(Author.class, 3L);
            author.setName("patric");
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    private static void delete(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
//            Author author = em.find(Author.class, 3L);
//            em.remove(author);

            Book book = em.find(Book.class,4L);
            em.remove(book);

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
}