package com.github.dhslrl321.step1;

import com.github.dhslrl321.support.fixture.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HibernateTest {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    EntityManager entityManager;

    @BeforeEach
    void setUp() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Test
    @DisplayName("entity 생명주기")
    void name() {
        // new/transit
        Member member = new Member("A", "jang");

        entityManager.persist(member); // managed
        Member a = entityManager.find(Member.class, "A");
        System.out.println("a = " + a);

        entityManager.detach(member); // detached
    }

    @Test
    void name2() {
        Member a = entityManager.find(Member.class, "A");
        System.out.println("a = " + a);
    }
}

