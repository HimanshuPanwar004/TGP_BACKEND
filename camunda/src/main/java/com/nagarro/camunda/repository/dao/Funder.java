package com.nagarro.camunda.repository.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
@Getter
@Setter
@ToString
@Entity
@Table(name = "Funder")
public class Funder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "field_org_name")
    private String fieldOrganisationName;
    @Column(name = "field_org_country")
    private String fieldOrganisationCountry;
    @Column(name = "field_org_start_date")
    private String  fieldOrgStartDate;
    @Column(name = "field_identification_type")
    private String fieldIdentificationType;
    @Column(name = "field_identification_number")
    private String fieldIdentificationNumber;
    @Column(name = "field_org_address")
    private String fieldOrganisationAddress;
    @Column(name = "field_org_email")
    private String fieldOrganisationEmail;
    @Column(name = "field_org_fax")
    private String fieldOrganisationFax;
    @Column(name = "field_org_phone")
    private String fieldOrganisationPhone;
    @Column(name = "field_org_mobile")
    private String fieldOrganisationMobile;
    @Column(name = "field_budget")
    private String fieldBudget;
    @Column(name = "field_sector")
    private List<String> fieldSector;
    @Column(name = "field_geography")
    private List<String> fieldGeography;
    @Column(name = "field_self_implementation")
    private boolean fieldSelfImplementation;
    @JsonProperty("field_org_pan")
    private String fieldOrganisationPan;
    @JsonProperty("field_consent")
    private boolean fieldConsent;

}
