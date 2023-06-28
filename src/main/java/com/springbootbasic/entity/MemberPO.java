package com.springbootbasic.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member")
public class MemberPO implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        private String name;

        private Integer age;

        private Float height;

        private Sex sex;

        public MemberDTO toDTO(){
                return MemberDTO.builder()
                        .id(id)
                        .name(name)
                        .age(age)
                        .height(height)
                        .sex(sex)
                        .build();
        }
}
