package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name= "cuenta_bancaria")
public class CuentaBancaria {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_cuenta_bancaria")
	@SequenceGenerator(name = "seq_cuenta_bancaria",sequenceName = "seq_cuenta_bancaria",allocationSize = 1)
	@Column(name = "cta_id")
	private Integer id;
	@Column(name = "cta_numero")
	private String numero;
	@Column(name = "cta_tipo")
	private String tipo;
	@Column(name = "cta_saldo")
	private BigDecimal saldo;
	
	@OneToOne(mappedBy = "cta_id_pro",cascade = CascadeType.ALL)
	
	private Propietario propietario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", saldo=" + saldo + "]";
	}
	
	
	
}
