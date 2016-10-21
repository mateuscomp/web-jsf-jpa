package com.cesed.jatic.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO {

	private String PERSISTENCE_UNIT = "myPU";

	protected EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
}
