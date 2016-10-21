package com.cesed.jatic.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO {

	private String PERSISTENCE_UNIT = "myPU";

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	protected EntityManager em = factory.createEntityManager();
}
