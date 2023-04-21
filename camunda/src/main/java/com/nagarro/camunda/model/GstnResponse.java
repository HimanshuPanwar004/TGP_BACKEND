package com.nagarro.camunda.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class GstnResponse {
    private boolean error;
    private GstnData data;
}
