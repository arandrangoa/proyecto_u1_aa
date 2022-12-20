package com.example.demo.ejercicio1.repository;

import com.example.demo.ejercicio1.modelo.Vehiculo;

public interface IVehiculoRepository {

	// CRUD
	public void insertar(Vehiculo vehiculo);

	public void actualizar(Vehiculo vehiculo);

	public Vehiculo buscar(String placa);

	public void borrar(String placa);

}
