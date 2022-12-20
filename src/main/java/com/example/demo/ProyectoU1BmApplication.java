
package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.modelo.CuentaBancaria;
import com.example.demo.banco.modelo.Transferencia;
import com.example.demo.banco.service.ICuentaBancariaService;
import com.example.demo.banco.service.ITransferenciaService;
import com.example.demo.ejercicio1.modelo.Propietario;
import com.example.demo.ejercicio1.modelo.Vehiculo;
import com.example.demo.ejercicio1.service.IMatriculaNuevaService;
import com.example.demo.ejercicio1.service.IMatriculaService;
import com.example.demo.ejercicio1.service.IVehiculoService;
import com.example.demo.ejercicio1.service.IpropietarioService;
import com.example.demo.herencia.CitaMedicaH;
import com.example.demo.spring.boot.CitaMedicaSB;
import com.example.demo.spring.boot.MedicoSB;
import com.example.demo.spring.boot.PacienteCancerSB;
import com.example.demo.spring.boot.PacienteTerceraEdadSB;

@SpringBootApplication
public class ProyectoU1BmApplication implements CommandLineRunner {

	@Autowired
	private IVehiculoService vehiculoService;
	@Autowired
	private IpropietarioService ipropietarioService;
	@Autowired
	@Qualifier("pesado")
	private IMatriculaNuevaService matriculaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU1BmApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		// Matricula

		// Opcion1
		Vehiculo vehi = new Vehiculo();
		vehi.setMarca("Tocyota");
		vehi.setPlaca("PSGD2312");
		vehi.setPrecio(new BigDecimal(20000));
		vehi.setTipo("P");
		this.vehiculoService.crear(vehi);
		vehi.setMarca("Toyota");
		vehi.setPrecio(new BigDecimal(15000));
		this.vehiculoService.modificar(vehi);

		// Opcion2
		Propietario propietario = new Propietario();
		propietario.setApellido("Andrango");
		propietario.setNombre("Alex");
		propietario.setCedula("1727193847");
		propietario.setFechaNaciemiento(LocalDateTime.of(1999, 12, 12, 12, 12));
		ipropietarioService.guardar(propietario);

		// Opcion 3
		this.matriculaService.matricular("1241587458", "PSGD2312");
		
		

	}

}
