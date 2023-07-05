package com.springbootbasic.aggregation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT p.registerYear AS registerYearCount, COUNT(p.registerYear) AS totalCount FROM Payment AS p GROUP BY p.registerYear ORDER BY p.registerYear DESC")
//    @Query("SELECT new com.springbootbasic.aggregation.model.custom.PaymentCount(p.register_year, COUNT(p.register_year)) FROM Payment AS p GROUP BY p.register_year ORDER BY p.register_year DESC")
    List<PaymentCount> countTotalPaymentsByRegisterYearInterface();
}
