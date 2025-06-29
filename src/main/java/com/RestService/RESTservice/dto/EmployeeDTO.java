package com.RestService.RESTservice.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {

    private Long id;

    private String name;

    @JsonProperty("isActive")
    private Boolean isActive ;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfJoining ;

}
