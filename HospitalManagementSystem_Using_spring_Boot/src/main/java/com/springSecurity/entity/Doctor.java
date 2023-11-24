package com.springSecurity.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor_details")
public class Doctor {

	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public String Id;
	
	public String name;
	
	public String email;
	
	public String specialist;
	
	public Date working_from;
	
	public String address;


	
	
}


