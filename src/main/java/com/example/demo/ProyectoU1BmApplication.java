package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.herencia.CitaMedicaH;
import com.example.demo.spring.boot.CitaMedicaSB;
import com.example.demo.spring.boot.MedicoSB;
import com.example.demo.spring.boot.PacienteCancerSB;
import com.example.demo.spring.boot.PacienteTerceraEdadSB;

@SpringBootApplication
public class ProyectoU1BmApplication implements CommandLineRunner {

@Autowired
	private PacienteTerceraEdadSB pacienteTE;
@Autowired	
private CitaMedicaSB citaMedicaSB;
@Autowired
private MedicoSB medicoSB;
public static void main(String[] args) {
		SpringApplication.run(ProyectoU1BmApplication.class, args);
         
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Spring Boot");
		
		this.pacienteTE.setCodigoIESS("asdfghjkl");
		this.pacienteTE.setNombre("Alex");
		this.pacienteTE.setTipo("");
		this.pacienteTE.setCedula("1727193847");
		
		System.out.println(pacienteTE);
		
		
		citaMedicaSB.agendar("123123", LocalDateTime.of(2022, 12, 2,  8, 30), pacienteTE, medicoSB);
	}

}
