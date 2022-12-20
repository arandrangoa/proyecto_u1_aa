package com.example.demo.ejercicio1.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ejercicio1.modelo.Matricula;
import com.example.demo.ejercicio1.modelo.Vehiculo;
import com.example.demo.ejercicio1.repository.IMatriculaRepository;
import com.example.demo.ejercicio1.repository.IPropietarioRepository;

@Service
public class MatriculaServiceImpl implements IMatriculaService {
	@Autowired
	private IMatriculaRepository matriculaRepository;
	@Autowired
	private IPropietarioRepository propietarioRepository;
	@Autowired
	private IVehiculoService vehiculoService;

	@Override
	public void matricular(String cedula, String placa) {
		// TODO Auto-generated method stub
		Matricula matricula = new Matricula();
		matricula.setFecha(LocalDateTime.now());
		matricula.setPropietario(this.propietarioRepository.buscar(cedula));
		Vehiculo vehiculo = this.vehiculoService.buscar(placa);
		matricula.setVehiculo(vehiculo);

		BigDecimal valor = null;
		if (vehiculo.getTipo().equals("P")) {
			valor = vehiculo.getPrecio().multiply(new BigDecimal(0.15));
		} else {
			// liviano
			valor = vehiculo.getPrecio().multiply(new BigDecimal(0.10));
		}
		// -1 valor izquierda menor
		// 0 son iguales
		// 1 valor izquierda mayor
		if (valor.compareTo(new BigDecimal(2000)) > 1) {
			BigDecimal descuento = valor.multiply(new BigDecimal(0.07));

			valor = valor.subtract(descuento);
		}
		matricula.setValor(valor);
		this.matriculaRepository.insertar(matricula);
	}

}
