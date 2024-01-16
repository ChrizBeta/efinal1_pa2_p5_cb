package com.example.demo.repository;

import com.example.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepo {
	
	public void insertar (CuentaBancaria cuentaBancaria);
	public CuentaBancaria seleccionar (Integer id);
	public void actualizar (CuentaBancaria cuentaBancaria);
	public void eliminar (Integer id);
	
	public CuentaBancaria seleccionarPorNumeroCuenta(String cta);


	
}
