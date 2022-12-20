package com.example.demo.ejercicio1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.ejercicio1.modelo.Vehiculo;

@Service
public class GestorMatriculaServiceImpl implements IGestorMatriculaService{
	@Qualifier("pesado")
	@Autowired
	private IMatriculaNuevaService iMatriculaNuevapesado;
	
	@Qualifier("liviano")
	@Autowired
	private IMatriculaNuevaService iMatriculaNuevaliviano;
	
	@Override
	public void matricular(String cedula, String placa) {
        // TODO Auto-generated method stub
        Vehiculo vehi = null;
        if(vehi.getTipo()=="P") {
           // this.matriculaService.matricular("1241587458", "PSGD2312");
        }else {
           // this.matriculaServiceLiviano.matricular("1241587458", "PSGD2312");
        }
    }

}
