package com.nagarro.camunda.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PanResponseData {
    private String number;
    private String name;
    private String typeOfHolder;
    private String isIndividual;
    private String isValid;
    private String firstName;
    private String middleName;
    private String lastName;
    private String title;
    private String panStatusCode;
    private String panStatus;
    private String aadhaarSeedingStatus;
    private String aadhaarSeedingStatusCode;
    private String lastUpdatedOn;
}
