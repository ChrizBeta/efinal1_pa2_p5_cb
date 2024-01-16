package com.example.demo.service;

import com.example.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	
	public void guardar (CuentaBancaria cuentaBancaria);
	public CuentaBancaria buscar (Integer id);
	public void modificar (CuentaBancaria cuentaBancaria);
	public void borrar (Integer id);

	public CuentaBancaria buscarPorNumeroCuenta(String cta);
	
}
