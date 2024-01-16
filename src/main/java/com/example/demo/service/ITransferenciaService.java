package com.example.demo.service;

import java.math.BigDecimal;

import com.example.demo.repository.modelo.Transferencia;

public interface ITransferenciaService {
	
	public void guardar (Transferencia transferencia);
	
	public void realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal monto);

}
