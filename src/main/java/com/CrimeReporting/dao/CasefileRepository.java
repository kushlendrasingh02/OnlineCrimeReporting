package com.CrimeReporting.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.CrimeReporting.entities.Casefile;


public interface CasefileRepository extends JpaRepository<Casefile,Integer> {
	
	@Query("from Casefile as c")
	public Page<Casefile> findAllCasefiles(Pageable pageable);
}
