package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.modelo.CuentaBancaria;
import com.example.demo.banco.modelo.Transferencia;
import com.example.demo.banco.repository.ITransferenciaRepository;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{

	private static List <Transferencia> baseTransferencias=new ArrayList<>();
	
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	@Autowired
	private ICuentaBancariaService bancariaService;
	
	@Override
	public List<Transferencia> buscarReporte() {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.buscarTodos();
	}

	@Override
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		//ORIGEN
		//1.Buscar la cuenta origen
		CuentaBancaria origen= this.bancariaService.bucarPorNumero(numeroOrigen);
		//2.Consultar el saldo de la cuenta origen
		BigDecimal saldoOrigen=origen.getSaldo();
		//3.Operacion resta en el origen
		//nuevo saldo= saldoOrigen - monto
		BigDecimal nuevoSaldo=saldoOrigen.subtract(monto);
		//4.Actualziacion cuenta origen
		origen.setSaldo(nuevoSaldo);
		this.bancariaService.actualizar(origen);
		
		//DESTINO
		//1.Buscar la cuenta destino
		CuentaBancaria destino=this.bancariaService.bucarPorNumero(numeroDestino);	
		//2.Consultar el saldo de la cuenta destino
		BigDecimal saldoDestino=destino.getSaldo();
		//3.Operacion resta en el destino
		BigDecimal nuevoSaldoDestino=saldoDestino.add(monto);
		//4.Actualziacion cuenta destino 
		destino.setSaldo(nuevoSaldoDestino);
		this.bancariaService.actualizar(destino); 
		
		Transferencia trans= new Transferencia();
		trans.setCuentaDestino(numeroDestino);
		trans.setCuentaOrigen(numeroOrigen);
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		trans.setNumero("12345");
		this.iTransferenciaRepository.insertar(trans);
	}

	@Override
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		System.out.println("Se creo una transferencia");
		this.iTransferenciaRepository.insertar(transferencia);
	}

	@Override
	public void borrar(Integer numTransferencia) {
		// TODO Auto-generated method stub
		System.out.println("Borrar la transferencia con numero: "+numTransferencia);
		this.iTransferenciaRepository.borrar(numTransferencia);
	}



}
