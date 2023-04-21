package com.nagarro.camunda.worker;

import com.nagarro.camunda.model.GstnResponse;
import com.nagarro.camunda.model.PanResponse;
import com.nagarro.camunda.service.FunderService;
import com.nagarro.camunda.service.ThirdPartyIntegrationService;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class ValidationWorker {
    private static final Logger log = LoggerFactory.getLogger(ValidationWorker.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ThirdPartyIntegrationService integrationService;

    @Autowired
    private FunderService funderService;

    @ZeebeWorker(type = "verifyDetails")
    public void validateDetails(final JobClient client, final ActivatedJob job) {
        log.info("validate gstn and pan flow string : {}", job.toString());
        Map<String, Object> variablesAsMap = job.getVariablesAsMap();
//        GstnResponse gstnDetails = integrationService
//                .getGstnDetails((String) variablesAsMap.get("field_identification_number"));
        PanResponse panDetails = integrationService.getPanDetails((String) variablesAsMap.get("field_org_pan"));
        if(!panDetails.isError()) {
            client.newCompleteCommand(job.getKey())
                    .variables("{\"response\": { \"code\": \"0\" }}")
                    .send().exceptionally((throwable) -> {
                        throw new RuntimeException("Could not complete job " + job, throwable);
                    });
        }
    }
}
