package com.springbootbasic.api.dto;

import com.springbootbasic.entity.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseListDTO {

    private List<CourseDTO> courseListDTO;
}
