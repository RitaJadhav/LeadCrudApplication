package com.crud.lead.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.lead.model.LeadModel;

@Repository
public interface LeadRepo extends JpaRepository<LeadModel, Long>{

	Optional<LeadModel> findByMobileNumber(Long mobileNumber);

}
