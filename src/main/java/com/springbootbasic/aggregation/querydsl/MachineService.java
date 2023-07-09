package com.springbootbasic.aggregation.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springbootbasic.aggregation.Machine;
import com.springbootbasic.aggregation.QMachine;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {

    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    public MachineService(JPAQueryFactory jpaQueryFactory, EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    QMachine machine = QMachine.machine;

    public List<Machine> machineList(){
        return jpaQueryFactory.select(machine).from(machine).fetch();
    }
}
