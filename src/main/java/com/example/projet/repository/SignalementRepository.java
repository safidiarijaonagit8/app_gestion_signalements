package com.example.projet.repository;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projet.model.*;

public interface SignalementRepository extends JpaRepository <Signalement, Long>{
	
	@Query(value = "SELECT * FROM signalement", nativeQuery = true)
     	List<Signalement> findAllSignal();
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update signalement set id_region = :id_region where id_signalement = :id_signalement", nativeQuery = true)
 	void updateSignalementAffectation(@Param("id_signalement") int id_signalement,@Param("id_region") int id_region);

	@Query(value = "delete from signalement where id_signalement = :id_signalement", nativeQuery = true)
 	void deleteSignalementAffectation(@Param("id_signalement") int id_signalement);
	
	
	
}