package com.example.demo.ejercicio1.service;

import com.example.demo.ejercicio1.modelo.Propietario;

public interface IpropietarioService {
	public void guardar(Propietario propietario);

	public void eliminar(String cedula);
}
