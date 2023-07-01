package com.springbootbasic.repository.impl;

import com.springbootbasic.entity.MemberPO;
import com.springbootbasic.enu.Sex;
import com.springbootbasic.repository.MemberRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<MemberPO> searchMembers(String name, Integer age, String sex) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<MemberPO> query = cb.createQuery(MemberPO.class);
        Root<MemberPO> member = query.from(MemberPO.class);

        // 建立一個 Predicate 列表，用於存放條件
        List<Predicate> predicates = new ArrayList<>();

        // 根據傳入的條件動態生成查詢條件
        if (name != null && !name.isEmpty()){
            predicates.add(cb.like(cb.lower(member.get("name")), "%" + name.toLowerCase() + "%"));
        }
        if(age != null){
            predicates.add(cb.lessThanOrEqualTo(member.get("age"), age));
        }
        if(sex != null){
            predicates.add(cb.equal(member.get("sex"), Sex.valueOf(sex)));
        }

        // 將條件列表轉換為陣列，並應用到查詢中
        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
