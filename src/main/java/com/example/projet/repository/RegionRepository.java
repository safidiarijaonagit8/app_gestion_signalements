package com.example.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.projet.model.Region;
import com.example.projet.model.SignalementDetail;

public interface RegionRepository extends JpaRepository <Region, Long>{

	@Query(value = " select * from region where id_region != 0 ", nativeQuery = true)
	List<Region> getListeRegion();
	
	
	
}
