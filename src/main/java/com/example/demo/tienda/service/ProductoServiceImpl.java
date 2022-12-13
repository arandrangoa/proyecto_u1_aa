package com.example.demo.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.tienda.modelo.Producto;
import com.example.demo.tienda.repository.IProductoRepository;
@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		
	}

}
