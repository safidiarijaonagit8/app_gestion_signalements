package com.example.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projet.model.*;

@Repository
public interface DetailSignalRepository extends JpaRepository <SignalementDetail, Integer>{
	
	@Query(value = "SELECT * FROM v_detailsignal where id_signalement = :id_signalement" ,nativeQuery = true)
	public List<SignalementDetail> getFicheSignal(@Param("id_signalement") int id_signalement);
 	
	
}
