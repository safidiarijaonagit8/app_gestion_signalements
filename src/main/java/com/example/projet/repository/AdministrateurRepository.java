package com.example.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projet.model.*;

@Repository
public interface AdministrateurRepository extends JpaRepository <Administrateur, Long>{

	
	//stat
	@Query(value = "SELECT count(id_signalement) FROM signalement where id_region = :id_region" ,nativeQuery = true)
	public Double nbrSignalParRegion(@Param("id_region") int id_region);
	
	
	
	
}
