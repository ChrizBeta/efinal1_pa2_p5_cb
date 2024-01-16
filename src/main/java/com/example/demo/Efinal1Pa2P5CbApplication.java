package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.ITransferenciaService;

@SpringBootApplication
public class Efinal1Pa2P5CbApplication implements CommandLineRunner{
	
	@Autowired
	private ICuentaBancariaService bancariaService;
	
	@Autowired
	private IPropietarioService iPropietarioService;
	
	@Autowired
	private ITransferenciaService iTransferenciaService;

	public static void main(String[] args) {
		SpringApplication.run(Efinal1Pa2P5CbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Propietario pro = new Propietario();
		pro.setApellido("Betancourt");
		pro.setCedula("1722781000");
		pro.setNombre("Christian");
		
		Propietario pro1 = new Propietario();
		pro1.setApellido("Alban");
		pro1.setCedula("123456789");
		pro1.setNombre("Alejandro");
		
		
		CuentaBancaria cta = new CuentaBancaria();
		cta.setNumero("12345");
		cta.setSaldo(new BigDecimal(2000));
		cta.setTipo("ahorros");
		cta.setPropietario(pro1);
		pro1.setCuentaBancaria(cta);
		
		
		CuentaBancaria cta1 = new CuentaBancaria();
		cta1.setNumero("54321");
		cta1.setSaldo(new BigDecimal(1000));
		cta1.setTipo("corriente");
		cta1.setPropietario(pro);
		pro.setCuentaBancaria(cta1);
		
		this.bancariaService.guardar(cta);
		this.bancariaService.guardar(cta1);
		
		this.iTransferenciaService.realizarTransferencia("12345", "54321", new BigDecimal(100));
		
	
		CuentaBancaria cta2 = this.bancariaService.buscarPorNumeroCuenta("12345");
		System.out.println(cta2.getSaldo());

		CuentaBancaria cta3 = this.bancariaService.buscarPorNumeroCuenta("54321");
		System.out.println(cta3.getSaldo());

		
		
		
		
		
	}

}
