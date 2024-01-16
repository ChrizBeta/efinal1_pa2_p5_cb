package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaBancariaRepoImpl implements ICuentaBancariaRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cuentaBancaria);
		
	}

	@Override
	public CuentaBancaria seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CuentaBancaria.class, id);
	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaBancaria);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		CuentaBancaria cta = this.seleccionar(id);
		this.entityManager.remove(cta);
		
	}

	@Override
	public CuentaBancaria seleccionarPorNumeroCuenta(String cta) {
		
		Query myQuery = this.entityManager.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero=:datoNumero");
		myQuery.setParameter("datoNumero", cta);
		return (CuentaBancaria)myQuery.getSingleResult();
		

	}

}
