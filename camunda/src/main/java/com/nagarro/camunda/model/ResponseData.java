package com.nagarro.camunda.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ResponseData {
    private StatusDetails status;
    private PanResponseData response;
}
