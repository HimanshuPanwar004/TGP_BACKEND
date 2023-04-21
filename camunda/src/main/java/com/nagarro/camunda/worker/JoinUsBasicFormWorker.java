package com.nagarro.camunda.worker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.camunda.model.FunderBasicDetails;
import com.nagarro.camunda.repository.dao.Funder;
import com.nagarro.camunda.service.FunderService;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JoinUsBasicFormWorker {

    private static final Logger log = LoggerFactory.getLogger(JoinUsBasicFormWorker.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FunderService funderService;

    @ZeebeWorker(type = "saveFunder")
    public void handleJob(final JobClient client, final ActivatedJob job) {
        log.info("save funder flow string : {}", job.toString());
        Map<String, Object> variablesAsMap = job.getVariablesAsMap();
        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        FunderBasicDetails funderBasicDetails = mapper.convertValue(variablesAsMap, FunderBasicDetails.class);
        Funder funder = convertToFunder(funderBasicDetails);
        funderService.saveFunder(funder);
        log.info("funder : {}", funderBasicDetails);
        client.newCompleteCommand(job.getKey())
                .send().exceptionally((throwable) -> {
                    throw new RuntimeException("Could not complete job " + job, throwable);
                });
    }

    @ZeebeWorker(type = "sendNotification")
    public void sendNotificationJob(final JobClient client, final ActivatedJob job) {
        log.info("send foreign not supported notification flow  : {}", job);
        client.newCompleteCommand(job.getKey())
                .send().exceptionally((throwable) -> {
                    throw new RuntimeException("Could not complete job " + job, throwable);
                });
    }

    @ZeebeWorker(type = "sectorImplementation")
    public void sectorImplementation(final JobClient client, final ActivatedJob job) {
        log.info("Sector Implementation flow  : {}", job);
        client.newCompleteCommand(job.getKey())
                .send().exceptionally((throwable) -> {
                    throw new RuntimeException("Could not complete job " + job, throwable);
                });
    }

    private Funder convertToFunder(FunderBasicDetails details){
        log.info("JoinUsBasicFormWorker::convertToFunder");
        return modelMapper.map(details, Funder.class);
    }
}
