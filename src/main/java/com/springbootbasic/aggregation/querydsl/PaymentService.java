package com.springbootbasic.aggregation.querydsl;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springbootbasic.aggregation.Payment;
import com.springbootbasic.aggregation.QMachine;
import com.springbootbasic.aggregation.QPayment;
import com.springbootbasic.aggregation.querydsl.MachinePaymentCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;


    QPayment payment = QPayment.payment;
    QMachine machine = QMachine.machine;

    public List<Payment> getPaymentListBetween2019To2020() {
        return this.jpaQueryFactory.select(payment)
                .from(payment)
                .where(payment.registerYear.between(2019, 2020))
                .orderBy(payment.registerYear.asc())
                .fetch();
    }

    /*
    * nativeQuery =
    * SELECT m.name, COUNT(*) as paymentCount
    * FROM payment p
    *   LEFT JOIN machine m
    *       ON m.id = p.machine_id
    * GROUP BY m.name;
    * */
    public List<MachinePaymentCount> getMachinePaymentCounts(){
        List<Tuple> tuples = jpaQueryFactory.select(machine.name, payment.count())
                .from(machine)
                .leftJoin(machine.payments, payment)
                .groupBy(machine.name)
                .fetch();
        return tuples.stream().map(t -> {
            MachinePaymentCount count = new MachinePaymentCount();
            count.setMachineName(t.get(machine.name));
            count.setPaymentCount(t.get(payment.count()));
            return count;
        }).toList();
    }
}
