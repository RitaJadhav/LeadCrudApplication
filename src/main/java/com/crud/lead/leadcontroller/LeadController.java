package com.crud.lead.leadcontroller;

import java.awt.desktop.UserSessionEvent.Reason;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crud.lead.exception.LeadExceptionHandler;
import com.crud.lead.model.LeadModel;
import com.crud.lead.service.LeadServiceInterface;

import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/Publisher/lead/V1")
public class LeadController {

	
	@org.springframework.beans.factory.annotation.Autowired(required =true)	
	LeadServiceInterface leadServiceInterface;
	
	@GetMapping("/Leads-all")
	public ResponseEntity<List<LeadModel>> getLeadList(){
		List<LeadModel> lead = leadServiceInterface.findall();
		return new ResponseEntity<List<LeadModel>>(lead,HttpStatus.OK);
	}
	
	@PostMapping("/save-lead")
	@ApiResponse(code=200 , message="Leads Created Successfully",response =LeadModel.class)
	public ResponseEntity<LeadModel> insertlead(@Valid @RequestBody LeadModel leadModel) {
		LeadModel lead = leadServiceInterface.addLead(leadModel);
		return new ResponseEntity<LeadModel>(HttpStatus.CREATED);
	}
	

    @GetMapping("/find/lead/{mobileNumber}")
    public ResponseEntity<List<LeadModel>> getLeadByMobileNumber(@PathVariable(value = "mobileNumber") Long mobileNumber) throws LeadExceptionHandler {
    	List<LeadModel> lead = leadServiceInterface.findallByMobileNumber(mobileNumber);
		return new ResponseEntity<List<LeadModel>>(lead,HttpStatus.OK);
    }

	
}
