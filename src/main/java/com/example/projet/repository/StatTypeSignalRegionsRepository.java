package com.example.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projet.model.Region;
import com.example.projet.model.StatTypeSignalRegions;

public interface StatTypeSignalRegionsRepository extends JpaRepository <StatTypeSignalRegions,Long> {
	
	@Query(value = "select * from v_stattyperegion" ,nativeQuery = true)
	public List<StatTypeSignalRegions> statTypeRegions();
	
	
	
	

}
