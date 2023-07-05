package com.springbootbasic.repository;

import com.springbootbasic.entity.MemberDTO;
import com.springbootbasic.entity.MemberPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 預設bean生成出來只有1個
@Scope("singleton")
@Repository
public interface MemberRepository extends JpaRepository<MemberPO, Integer>, JpaSpecificationExecutor<MemberPO>, MemberRepositoryCustom {
    @Transactional(propagation = Propagation.REQUIRED)
    @Modifying
    @Query("UPDATE MemberPO m SET m.age = :age WHERE m.name = :name")
    int updateMemberSetAgeForName(@Param("age") Integer age, @Param("name") String name);

    @Query("SELECT m FROM MemberPO m WHERE m.sex = 'MALE'")
//    @Query("SELECT m FROM MemberPO m WHERE m.sex = ?1")
//    @Query("SELECT m FROM MemberPO m WHERE m.sex = :sex")
    List<MemberPO> findAllMembersWhenSexIsMale(String sex);

    // @Query和deleteBy: 兩種刪除方式的區別在於是否先加載實體對像到內存中以及是否觸發實體的生命週期方法。
    // 使用註解執行刪除查詢時，執行一條單獨的刪除語句，不加載實體對像也不觸發生命週期@Query方法；
    // 而使用基於名稱的查詢方法deleteBy時，先加載實體對象並逐個刪除，觸發相應的生命週期方法。
    List<MemberPO> deleteByAge(Double age);
}
