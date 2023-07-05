package com.springbootbasic.repository;

import com.springbootbasic.entity.MemberDTO;
import com.springbootbasic.entity.MemberPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.test.util.AssertionErrors.assertEquals;


@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Transactional
    public void givenMembers_WhenDeletedByAge_ThenDeletedMembersShouldReturn() {
        List<MemberPO> memberPOList = memberRepository.deleteByAge(5D);

        assertEquals("number of members arnt matching", 2, memberPOList.size());
        memberPOList.forEach(member -> assertEquals("It's not a 5 years old", 5, member.getAge()));
    }
}
