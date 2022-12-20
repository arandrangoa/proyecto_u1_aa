package com.example.demo.ejercicio1.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ejercicio1.modelo.Vehiculo;
import com.example.demo.ejercicio1.repository.IVehiculoRepository;

@Service
public class VehiculoServiceImpl implements IVehiculoService {
	@Autowired
	private IVehiculoRepository vehiculoRepository;

	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.buscar(placa);
	}

	@Override
	public void crear(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.vehiculoRepository.insertar(vehiculo);
	}

	@Override
	public void modificar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.vehiculoRepository.actualizar(vehiculo);
	}

	@Override
	public void quitar(String placa) {
		// TODO Auto-generated method stub
		this.vehiculoRepository.borrar(placa);
	}

	@Override
	public void modificar(String placa, BigDecimal precio, String marca) {
		// TODO Auto-generated method stub
		Vehiculo vehiculo = this.vehiculoRepository.buscar(placa);
		vehiculo.setMarca(marca);
		vehiculo.setPrecio(precio);

		this.vehiculoRepository.actualizar(vehiculo);

		;
	}

}
