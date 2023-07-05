package com.springbootbasic.repository;

import com.springbootbasic.entity.MemberPO;

import java.util.List;

public interface MemberRepositoryCustom {

    // 查詢會員藉由名稱、性別，以及age小於某個數字的所有會員資料
    List<MemberPO> searchMembers(String name, Integer age, String sex);
}
