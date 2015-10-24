package org.arc.dao;

import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Disposes;
import javax.ejb.Stateless;
import javax.swing.JOptionPane;



public class EntityManagerFactory{

	static int staticCounter = 0;
	private int dynamicCounter = 0;

	public EntityManagerFactory(){
		EntityManagerFactory.staticCounter++;
		dynamicCounter++;
		JOptionPane.showMessageDialog(
			null,
			String.format(
				"Static: %d, Dynamic: %d",EntityManagerFactory.staticCounter,dynamicCounter
			)
		);
	}

	@Produces
	public EntityManager getEntityManager(InjectionPoint injectionPoint){
		System.out.println(injectionPoint);
		return null;
	}

	public void close(@Disposes EntityManager manager){
		if(manager.isOpen()){
			manager.close();
		}
	}

	@Produces
	public DAO<String> getStringDAO(InjectionPoint injectionPoint){
		System.out.println(injectionPoint);
		return new DAO<String>(){
			@Override
			public String toString(){
				return "String DAO";
			}
		};
	}
}