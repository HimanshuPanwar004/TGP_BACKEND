package com.nagarro.camunda.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PanResponse {
    private boolean error;
    private ResponseData responseData;
}
