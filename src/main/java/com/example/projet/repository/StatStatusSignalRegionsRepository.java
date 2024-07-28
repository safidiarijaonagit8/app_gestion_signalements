package com.example.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.projet.model.StatStatusSignalRegions;
import com.example.projet.model.StatTypeSignalRegions;

public interface StatStatusSignalRegionsRepository extends JpaRepository <StatStatusSignalRegions,Long> {

	@Query(value = "select * from v_statGlobalStatut" ,nativeQuery = true)
	public List<StatStatusSignalRegions> statTypeRegions();
	
}
