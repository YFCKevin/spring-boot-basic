package com.springbootbasic.repository;

import com.springbootbasic.entity.MemberPO;

import java.util.List;

public interface MemberRepositoryCustom {

    List<MemberPO> searchMembers(String name, Integer age, String sex);
}
