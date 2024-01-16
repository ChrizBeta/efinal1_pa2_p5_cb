package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICuentaBancariaRepo;
import com.example.demo.repository.modelo.CuentaBancaria;

@Service

public class CuentaBancariaServiceImpl implements ICuentaBancariaService{
	
	
	@Autowired 
	private ICuentaBancariaRepo bancariaRepo;

	@Override
	public void guardar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepo.insertar(cuentaBancaria);
		
	}

	@Override
	public CuentaBancaria buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.bancariaRepo.seleccionar(id);
	}

	@Override
	public void modificar(CuentaBancaria cuentaBancaria) {
		
		this.bancariaRepo.actualizar(cuentaBancaria);
		
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.bancariaRepo.eliminar(id);
		
	}

	@Override
	public CuentaBancaria buscarPorNumeroCuenta(String cta) {
		// TODO Auto-generated method stub
		return this.bancariaRepo.seleccionarPorNumeroCuenta(cta);
	}
	
	
	

}
