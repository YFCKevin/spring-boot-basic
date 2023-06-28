package com.springbootbasic.api;

import com.springbootbasic.api.dto.CourseDTO;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {

    private final RestTemplate restTemplate;

    public ResponseEntity<List<CourseDTO>> queryAllCourses(){
        ParameterizedTypeReference<List<CourseDTO>> responseType = new ParameterizedTypeReference<>() {};

        return restTemplate.exchange("http://localhost:8081/getAllCourses", HttpMethod.GET, null, responseType);

    }
}
