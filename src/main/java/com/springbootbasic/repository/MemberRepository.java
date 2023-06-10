package com.springbootbasic.repository;

import com.springbootbasic.entity.MemberPO;
import com.springbootbasic.entity.Sex;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

// 預設bean生成出來只有1個
@Scope("singleton")
@Repository
public interface MemberRepository extends JpaRepository<MemberPO, Integer>, JpaSpecificationExecutor<MemberPO> {

    List<MemberPO> findAllByName(String name);

    List<MemberPO> findAllByNameAndSexOrderByAgeDesc(String name, Sex sex, Pageable pageable);

    MemberPO findByNameAndAge(String name);
}
