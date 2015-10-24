package org.arc.dao;

import javax.persistence.EntityManager;
import javax.inject.Inject;

public class EntityManagerDAO<T> implements DAO<T>{

	private final EntityManager manager;

	@Inject
	public EntityManagerDAO(EntityManager manager){
		this.manager = manager;
	}

}