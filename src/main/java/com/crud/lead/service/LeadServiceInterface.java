package com.crud.lead.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.lead.model.LeadModel;

@Service
public interface LeadServiceInterface {

	public LeadModel addLead(LeadModel leadModel);

	public List<LeadModel> findall();

	public List<LeadModel> findallByMobileNumber(Long mobileNumber);

}
