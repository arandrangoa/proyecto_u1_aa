package com.example.demo.ejercicio1.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;



@Service("liviano")
public class MatriculaNuevaLivianoServiceImpl implements IMatriculaNuevaService{
	


	@Override
	public BigDecimal matricular(String cedula, BigDecimal precio) {
		// TODO Auto-generated method stub
		
		System.out.println("Matriculado liviano");
		BigDecimal valor = precio.multiply(new BigDecimal(0.10));
		return valor;
	}

}
