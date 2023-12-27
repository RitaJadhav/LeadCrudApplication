package com.crud.lead.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import io.swagger.annotations.ApiModelProperty;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="lead")
public class LeadModel {
	
	@Id
	@NotBlank(message = "Lead Id should not be Blank")
	private long leadId;
	
	@Pattern(regexp = "/^[a-zA-Z]*$/" ,message = "firstName should strictly contain Alphabets, no spaces")
	@ApiModelProperty(required = true)
	@NotBlank(message = "firstName should not be Blank")
	private String firstName;
	
	@Pattern(regexp = "/^[a-zA-Z]*$/",message="middleName should strictly contain Alphabets, no spaces")
	@ApiModelProperty(required = false)
	private String middleName;
	
	@Pattern(regexp = "/^[a-zA-Z]*$/",message="lastName should strictly contain Alphabets, no spaces")
	@ApiModelProperty(required = true)
	private String lastName;
	
	@Pattern(regexp = "/^[a-zA-Z]*$/")
	@ApiModelProperty(required = true)
	private long mobileNumber;
	
	@Pattern(regexp = "/^[a-zA-Z]*$/",message="Gender Male/Female/Others, no spaces")
	@ApiModelProperty(required = true)
	private String Gender;
	
	@ApiModelProperty(required = true)
	@JsonFormat(pattern="dd/MM/yyyy")
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate DOB;
	
	@Email
	@Pattern(regexp=".+@.+\\.[a-z]+")
	@ApiModelProperty(required = true)
	private String email;

	public long getLeadId() {
		return leadId;
	}

	public void setLeadId(long leadId) {
		this.leadId = leadId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
