package com.example.projet.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.projet.model.Affectation;

@Repository
public class AffectionInsertRepository {
	 @PersistenceContext
	    private EntityManager entityManager;
	 
	 @Transactional
	 public void insertWithQuery(Affectation a) {
	     entityManager.createNativeQuery("INSERT INTO affectation (idsignalement, idstatussignalement,dateaffectation, heureaffectation) VALUES (?,?,?,?)")
	       .setParameter(1, a.getIdSignalement())
	       .setParameter(2, a.getIdStatusSignalement())
	       .setParameter(3, a.getDateAffectation())
	       .setParameter(4, a.getHeureAffectation())
	       .executeUpdate();
	 }
	 

}
