package com.example.springdatajpa2;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository repository;
    private static final Logger log = LoggerFactory.getLogger(CustomerRepository.class);

    @Test
    void save() {
        Customer customer = new Customer("zi", "zi@naver.com");
        repository.save(customer);

        Assertions.assertThat(repository.findById(11L).get().getName()).isEqualTo("zi");
    }

    @Test
    void delete() {
        repository.deleteById(10L);
        Assertions.assertThat(repository.findById(10L)).isNotPresent();
    }

    @Test
    void findByName(){
        List<Customer> customers = repository.findByName("홍길동");
        assertThat(customers.size()).isEqualTo(1);
    }

    @Test
    void findByEmail(){
        List<Customer> customers = repository.findByEmail("hong@example.com");
        assertThat(customers.size()).isEqualTo(1);
    }



}
