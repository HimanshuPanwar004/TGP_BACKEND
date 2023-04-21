package com.nagarro.camunda;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.camunda.model.FunderBasicDetails;
import com.nagarro.camunda.worker.JoinUsBasicFormWorker;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.EnableZeebeClient;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import org.modelmapper.ModelMapper;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootApplication
@EnableZeebeClient
public class CamundaApplication {

	private static final Logger log = LoggerFactory.getLogger(CamundaApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(CamundaApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	private FunderBasicDetails parseToFunderDetails(Map<String, String> response) {
		FunderBasicDetails funderBasicDetails = new FunderBasicDetails();
		JSONObject jsonObject = null;
		JSONObject ioObject = null;

		try {
			jsonObject = new JSONObject(response);


		} catch (Exception e) {
			e.printStackTrace();
		}
		return funderBasicDetails;
	}
}
