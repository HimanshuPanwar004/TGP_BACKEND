package com.nagarro.camunda.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class StatusDetails {
    private Integer statusCode;
    private String statusMessage;
}
