package com.springbootbasic.aggregation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PaymentRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PaymentRepository paymentRepository;

    @BeforeEach
    public void setUp(){
        entityManager.createNativeQuery("INSERT INTO machine (id, name) VALUES (1, 'M1')").executeUpdate();
        entityManager.createNativeQuery("INSERT INTO machine (id, name) VALUES (2, 'M2')").executeUpdate();
        entityManager.createNativeQuery("INSERT INTO payment (id, name, register_year, approval_year, machine_id) " +
                "VALUES (1, 'Payment 1', 2019, 2020, 1)").executeUpdate();
        entityManager.createNativeQuery("INSERT INTO payment (id, name, register_year, approval_year, machine_id) " +
                "VALUES (2, 'Payment 2', 2020, 2020, 2)").executeUpdate();
        entityManager.createNativeQuery("INSERT INTO payment (id, name, register_year, approval_year, machine_id) " +
                "VALUES (3, 'Payment 3', 2022, 2022, 2)").executeUpdate();
        entityManager.createNativeQuery("INSERT INTO payment (id, name, register_year, approval_year, machine_id) " +
                "VALUES (4, 'Payment 4', 2023, 2023, 1)").executeUpdate();
        entityManager.createNativeQuery("INSERT INTO payment (id, name, register_year, approval_year, machine_id) " +
                "VALUES (5, 'Payment 5', 2020, 2022, 2)").executeUpdate();
    }
    @Test
    public void testCountTotalPaymentsByRegisterYearInterface(){
        List<PaymentCount> paymentCounts = paymentRepository.countTotalPaymentsByRegisterYearInterface();

        assertEquals(4, paymentCounts.size());
    }
}
