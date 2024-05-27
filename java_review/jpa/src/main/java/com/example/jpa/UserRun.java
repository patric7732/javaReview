package com.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserRun {
    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserPU");
//        EntityManager entityManager = emf.createEntityManager();


        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        // 유저 엔티티가 생성이 됨, 아직은 영속성 컨텍스트가 관리하지 않는 상태임
        User user = new User();
//        user.setId(1L);
        user.setName("Jeon");
        user.setEmail("jeon@exam.com");

        // 여기까지도 영속성 컨텍스트가 관리하지는 않음.
        entityManager.getTransaction().begin();

        // 영속성 컨텍스트에 관리를 맡김
        entityManager.persist(user);
        System.out.println("userId::::::::::::::" + user.getId());

        //이때 DB에 저장함
        entityManager.getTransaction().commit();
    }
}
