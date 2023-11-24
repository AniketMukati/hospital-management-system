package com.springSecurity.repositary;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springSecurity.entity.Doctor;
import com.springSecurity.entity.Patient;

import jakarta.persistence.PersistenceContext;


//@PersistenceContext
public interface UserRepositary extends JpaRepository<Patient, Integer>  {
	
	
// 	void updateById(int id);
	
//	public List<Patient> findByNameStartingWith(String likePattern);
	
//	@Query(value="UPDATE students SET last_name = 'Williams' WHERE student_id = 384:n",  nativeQuery =  true)
//	public List<Patient> getAllUser(@Param("n") String name);	

	 	
	
//	 @Query("UPDATE Patient p SET p.address = :address , p.name = :name ,p.disease = :disease ,p.address = :address , WHERE p.id = :id")
//	 int updateAddress(@Param("companyId") int companyId, @Param("address") String address);

	 
//	//@Transactional
//	 @Query(value = "UPDATE Patient p SET p.address = :address , p.name = :name ,p.disease = :disease ,p.addmitted_Date = :addmitted_Date"
//	 		+ " ,p.email = :email WHERE p.id = :id" , nativeQuery = true)
//	Patient setPatientInfoById(int id, String address, String disease, Doctor doctor, String email,
//			String name, Date addmitted_Date);	
	
	
//	
//	@Query("update Patient p set p.firstname = ?1, p.lastname = ?2 where u.id = ?3")
//	void setUserInfoById(String firstname, String lastname, Integer userId);
}
