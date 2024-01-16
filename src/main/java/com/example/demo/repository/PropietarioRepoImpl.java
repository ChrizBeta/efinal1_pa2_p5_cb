package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PropietarioRepoImpl implements IPropietarioRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(propietario);
		
	}

	@Override
	public Propietario seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Propietario.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Propietario pro = this.seleccionar(id);
		this.entityManager.remove(pro);
	}

	@Override
	public void actulizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(propietario);
		
	}
	
	
	

	
	
}
