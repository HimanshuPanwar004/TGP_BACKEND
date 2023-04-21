package com.nagarro.camunda.repository;

import com.nagarro.camunda.repository.dao.Funder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FunderRepository extends JpaRepository<Funder, Long> {
}
