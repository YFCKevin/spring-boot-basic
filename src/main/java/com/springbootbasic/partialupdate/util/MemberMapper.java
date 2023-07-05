package com.springbootbasic.partialupdate.util;

import com.springbootbasic.entity.MemberDTO;
import com.springbootbasic.entity.MemberPO;
import org.mapstruct.*;

/*
* componentModel = "spring"，表示使用 Spring 框架作為 MapStruct 的組件模型。
*nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE: 代表mapping時，忽略MemberDTO中的空值屬性，僅更新非空值的屬性到Member中
* */
@Mapper(componentModel = "spring")
public interface MemberMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateMemberFromDto(MemberDTO memberDTO, @MappingTarget MemberPO memberPO);
}
