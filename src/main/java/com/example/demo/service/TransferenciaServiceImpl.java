package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ITransferenciaRepo;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{
	
	@Autowired
	private ITransferenciaRepo iTransferenciaRepo;
	
	@Autowired 
	private ICuentaBancariaService bancariaService;
	

	@Override
	public void guardar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepo.insertar(transferencia);
		
	}

	@Override
	public void realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		
		Transferencia trans = new Transferencia();
		trans.setCuentaDestino(cuentaDestino);
		trans.setComision(monto);
		trans.setCuentaOrigen(cuentaOrigen);
		trans.setFechaTransferencia(LocalDate.now());
		trans.setMonto(monto);
		
		CuentaBancaria ctaOrigen = this.bancariaService.buscarPorNumeroCuenta(cuentaOrigen);	
		
		BigDecimal valorComision = monto.multiply(new BigDecimal(0.1));
		BigDecimal saldomenosmonto = ctaOrigen.getSaldo().subtract(monto);
		BigDecimal valorTotalOrigen = saldomenosmonto.subtract(valorComision);		
		ctaOrigen.setSaldo(valorTotalOrigen);
		this.bancariaService.modificar(ctaOrigen);
		
		CuentaBancaria ctaDestino = this.bancariaService.buscarPorNumeroCuenta(cuentaDestino);
		BigDecimal valorNuevo = monto.add(monto);
		this.bancariaService.modificar(ctaDestino);
		
		this.guardar(trans);
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
