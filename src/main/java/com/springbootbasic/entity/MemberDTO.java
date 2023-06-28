package com.springbootbasic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {

    private Integer id;

    private String name;

    private Integer age;

    private Float height;

    private Sex sex;

    public MemberPO toPO(){
        return MemberPO.builder()
                .id(id)
                .name(name)
                .age(age)
                .height(height)
                .sex(sex)
                .build();
    }
}
