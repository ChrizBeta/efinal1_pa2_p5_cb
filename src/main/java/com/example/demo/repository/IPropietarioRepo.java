package com.example.demo.repository;

import com.example.demo.repository.modelo.Propietario;

public interface IPropietarioRepo {

	public void insertar(Propietario propietario);

	public Propietario seleccionar(Integer id);

	public void eliminar(Integer id);

	public void actulizar(Propietario propietario);

}
