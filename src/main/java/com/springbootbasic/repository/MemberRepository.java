package com.springbootbasic.repository;

import com.springbootbasic.entity.MemberPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 預設bean生成出來只有1個
@Scope("singleton")
@Repository
public interface MemberRepository extends JpaRepository<MemberPO, Integer>, JpaSpecificationExecutor<MemberPO>, MemberRepositoryCustom {
    @Transactional
    @Modifying
    @Query("UPDATE MemberPO m SET m.age = :age WHERE m.name = :name")
    int updateMemberSetAgeForName(@Param("age") Integer age, @Param("name") String name);

    @Query("SELECT m FROM MemberPO m WHERE m.sex = 'MALE'")
//    @Query("SELECT m FROM MemberPO m WHERE m.sex = ?1")
//    @Query("SELECT m FROM MemberPO m WHERE m.sex = :sex")
    List<MemberPO> findAllMembersWhenSexIsMale(String sex);
}
