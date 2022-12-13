package com.example.demo.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.tienda.modelo.Detalle;
import com.example.demo.tienda.repository.IDetalleRepository;
@Repository
public class DetalleServiceImpl implements IDetalleService{
	
	private IDetalleRepository detalleRepository;
	

	@Override
	public void insetar(Detalle detalle) {
		// TODO Auto-generated method stub
		this.detalleRepository.insertar(detalle);
		
	}

}
