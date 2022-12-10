
package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.modelo.CuentaBancaria;
import com.example.demo.banco.modelo.Transferencia;
import com.example.demo.banco.service.ICuentaBancariaService;
import com.example.demo.banco.service.ITransferenciaService;
import com.example.demo.herencia.CitaMedicaH;
import com.example.demo.spring.boot.CitaMedicaSB;
import com.example.demo.spring.boot.MedicoSB;
import com.example.demo.spring.boot.PacienteCancerSB;
import com.example.demo.spring.boot.PacienteTerceraEdadSB;

@SpringBootApplication
public class ProyectoU1BmApplication implements CommandLineRunner {

	@Autowired
	private ICuentaBancariaService bancariaService;
	@Autowired
	private ITransferenciaService iTransferenciaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU1BmApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		CuentaBancaria cuenta1 = new CuentaBancaria();
		cuenta1.setNumero("0001");
		cuenta1.setTipo("A");
		cuenta1.setTitular("Alex Andrango");
		cuenta1.setSaldo(new BigDecimal(100));
		this.bancariaService.insertar(cuenta1);

		CuentaBancaria cuenta2 = new CuentaBancaria();
		cuenta2.setNumero("0002");
		cuenta2.setTipo("A");
		cuenta2.setTitular("Mashiel Andrango");
		cuenta2.setSaldo(new BigDecimal(200));
		this.bancariaService.insertar(cuenta2);

		System.out.println("Saldos actuales: ");
		CuentaBancaria cuentaActual1 = this.bancariaService.bucarPorNumero("0001");
		CuentaBancaria cuentaActual2 = this.bancariaService.bucarPorNumero("0002");
		System.out.println("Saldo actual: " + cuentaActual1.getSaldo());
		System.out.println("Saldo actua2: " + cuentaActual2.getSaldo());

		System.out.println("Reporte 1");
		for (Transferencia t : this.iTransferenciaService.buscarReporte()) {
			System.out.println(t);
		}

		this.iTransferenciaService.realizar("0001", "0002", new BigDecimal(10));

		System.out.println("Reporte 2");
		for (Transferencia t : this.iTransferenciaService.buscarReporte()) {
			System.out.println(t);
		}

		System.out.println("Saldos nuevos: ");
		CuentaBancaria cuentaConsultada1 = this.bancariaService.bucarPorNumero("0001");
		CuentaBancaria cuentaConsultada2 = this.bancariaService.bucarPorNumero("0002");
		System.out.println("Nuevo saldo: " + cuentaConsultada1.getSaldo());
		System.out.println("Nuevo saldo: " + cuentaConsultada2.getSaldo());
		
		

	}

}
