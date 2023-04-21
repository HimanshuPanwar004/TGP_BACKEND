package com.nagarro.camunda.service;

import com.nagarro.camunda.model.GstnResponse;
import com.nagarro.camunda.model.PanResponse;

public interface ThirdPartyIntegrationService {
    PanResponse getPanDetails(String input);

    GstnResponse getGstnDetails(String input);
}
