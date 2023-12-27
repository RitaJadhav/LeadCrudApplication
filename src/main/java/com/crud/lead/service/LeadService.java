package com.crud.lead.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.crud.lead.model.LeadModel;
import com.crud.lead.repos.LeadRepo;

@Service
public class LeadService implements LeadServiceInterface{

	@Autowired
	private LeadRepo leadRepo;
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public LeadModel addLead(LeadModel leadModel) {
		LeadModel lead = leadRepo.save(leadModel);
		return lead;
	}
	@Override
	public List<LeadModel> findall() {
		// TODO Auto-generated method stub
		return leadRepo.findAll();
	}
	@Override
	public List<LeadModel> findallByMobileNumber(Long mobileNumber) {
		// TODO Auto-generated method stub
		Map<String,Object> hmap = new HashMap<>();
		hmap.put("MobileNumber", mobileNumber);
		SqlRowSet row = jdbcTemplate.queryForRowSet("select * from lead where mobile_number =:MobileNumber", hmap);
		List<LeadModel> leadModels = new ArrayList<>(); 
		while(row.next()){
			LeadModel lead = new LeadModel();
			lead.setEmail(row.getString("email"));
			lead.setFirstName(row.getString("first_Name"));
			lead.setLastName(row.getString("last_Name"));
			lead.setMiddleName(row.getString("middle_Name"));
			lead.setGender(row.getString("gender"));
			lead.setLeadId(row.getInt("lead_id"));
			lead.setMobileNumber(Long.parseLong(row.getString("mobile_Number")));
			leadModels.add(lead);
		}
		return 	leadModels;
	}

}
