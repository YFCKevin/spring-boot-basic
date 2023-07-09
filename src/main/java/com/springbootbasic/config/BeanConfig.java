package com.springbootbasic.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springbootbasic.controller.MemberController;
import com.springbootbasic.repository.MemberRepository;
import com.springbootbasic.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public JPAQueryFactory jpaQueryFactory(@Autowired EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }
}
