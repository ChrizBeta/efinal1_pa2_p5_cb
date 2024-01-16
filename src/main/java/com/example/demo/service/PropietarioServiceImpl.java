package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IPropietarioRepo;
import com.example.demo.repository.modelo.Propietario;

@Service
public class PropietarioServiceImpl implements IPropietarioService{
	
	@Autowired
	private IPropietarioRepo iPropietarioRepo;

	@Override
	public void guardar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.iPropietarioRepo.insertar(propietario);
		
		
	}

	@Override
	public Propietario buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iPropietarioRepo.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iPropietarioRepo.eliminar(id);
		
	}

	@Override
	public void modificar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.iPropietarioRepo.actulizar(propietario);
		
	}
	
	

}
