package com.nagarro.camunda.service.impl;

import com.nagarro.camunda.repository.FunderRepository;
import com.nagarro.camunda.repository.dao.Funder;
import com.nagarro.camunda.service.FunderService;
import com.nagarro.camunda.worker.JoinUsBasicFormWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FunderServiceImpl implements FunderService {

    private static final Logger log = LoggerFactory.getLogger(JoinUsBasicFormWorker.class);

    @Autowired
    private FunderRepository repository;

    @Override
    public void saveFunder(Funder funder) {
        log.info("FunderServiceImpl::saveFunder : {}",funder);
        repository.save(funder);
    }
}
