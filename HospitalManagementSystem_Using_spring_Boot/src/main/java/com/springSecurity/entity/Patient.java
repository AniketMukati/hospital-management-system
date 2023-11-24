package com.springSecurity.entity;

 import java.sql.Date;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "patients_detail")
public class Patient {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int Id;
	
	public String name;
	
	public String email;
	
	public String disease;
	
	public Date addmitted_Date;
	
	public String address;
	
	public long number;
	
	@OneToOne( orphanRemoval = true ,  cascade = CascadeType.REFRESH , fetch = FetchType.LAZY)
//    @Cascade(mapped value = { CascadeType.DELETE })
	@JoinColumn(name = "doctor_Id" , updatable = true)
	public Doctor doctor;


	private String isActive;
	
	
	
	

}
