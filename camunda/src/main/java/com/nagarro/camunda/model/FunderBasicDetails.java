package com.nagarro.camunda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class FunderBasicDetails implements Serializable {
    @JsonIgnore
    private Object body;
    @JsonIgnore
    private Integer status;
    @JsonIgnore
    private Object headers;
    @JsonIgnore
    private Object countryResponse;
    @JsonIgnore
    private Object response;
    @JsonProperty("field_org_name")
    private String fieldOrganisationName;
    @JsonProperty("field_org_country")
    private String fieldOrganisationCountry;
    @JsonProperty("field_org_pan")
    private String fieldOrganisationPan;
    @JsonProperty("field_org_start_date")
    private String  fieldOrgStartDate;
    @JsonProperty("field_identification_type")
    private String fieldIdentificationType;
    @JsonProperty("field_identification_number")
    private String fieldIdentificationNumber;
    @JsonProperty("field_org_address")
    private String fieldOrganisationAddress;
    @JsonProperty("field_org_email")
    private String fieldOrganisationEmail;
    @JsonProperty("field_org_fax")
    private String fieldOrganisationFax;
    @JsonProperty("field_org_phone")
    private String fieldOrganisationPhone;
    @JsonProperty("field_org_mobile")
    private String fieldOrganisationMobile;
    @JsonProperty("field_budget")
    private String fieldBudget;
    @JsonProperty("field_sector")
    private List<String> fieldSector;
    @JsonProperty("field_geography")
    private List<String> fieldGeography;
    @JsonProperty("field_self_implementation")
    private boolean fieldSelfImplementation;
    @JsonProperty("field_consent")
    private boolean fieldConsent;


}
