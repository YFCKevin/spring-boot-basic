package com.springbootbasic.config;

import com.springbootbasic.controller.MemberController;
import com.springbootbasic.repository.MemberRepository;
import com.springbootbasic.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

//    @Bean
//    public MemberService memberService(MemberRepository memberRepository){
//        return new MemberService(memberRepository);
//    }
//
//    @Bean
//    public MemberController memberController(MemberService memberService){
//        return new MemberController(memberService);
//    }
}
