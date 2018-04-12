package com.negocio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.negocio.dto.CargaElementos;
import com.negocio.dto.GestionSemanal;
import com.negocio.entity.DatosCarga;
import com.negocio.entity.RegistroEjecucion;
import com.negocio.excepcion.BussinnesExcepcion;
import com.negocio.repository.RegistroEjecucionDao;
import com.negocio.util.Cantidades;

@Service
public class CalcularCargaMudanzaImpl {

	@Autowired
	private TranformarListasImpl tranformarListasImpl;
	
	@Autowired RegistroEjecucionDao registroEjecucionDao;

	public List<DatosCarga> procesarDatos(CargaElementos elementos) throws BussinnesExcepcion {
		return cantidadViajesDiarios(tranformarListasImpl.modelarElementos(elementos),elementos);

	}

	private List<DatosCarga> cantidadViajesDiarios(GestionSemanal gestionSemanal, CargaElementos elementos) {
		List<DatosCarga> lista = new ArrayList<>();
		for (int i = 0; i < gestionSemanal.getListaDias().size(); i++) {
			DatosCarga datos = contarViajes(gestionSemanal.getListaDias().get(i).getLista());
			datos.setCantidadViajes("Case # " + i + " " + datos.getCantidadViajes());
			lista.add(datos);
		}
		
		guardarRegistroEjecucion(elementos);
		return lista;

	}

	private void guardarRegistroEjecucion(CargaElementos elementos) {
		RegistroEjecucion arg0= new RegistroEjecucion();
		arg0.setCedula(elementos.getEmpleado().getIdentificacion());
		arg0.setEmpleado(elementos.getEmpleado().getNombre());
		arg0.setFechaEjecucion(new Date());
		registroEjecucionDao.save(arg0);
	}

	private DatosCarga contarViajes(List<Integer> list) {
		int cantidadViajes = 0;

		while (!list.isEmpty()) {
			cantidadViajes += cantidadViajes(list);
		}

		DatosCarga datosCarga = new DatosCarga();
		datosCarga.setCantidadViajes(String.valueOf(cantidadViajes));
		return datosCarga;

	}

	
	private int cantidadViajes(List<Integer> listElementosPeso) {
		int cantidadElementosSaco = 1;
		int cantidadViajes = 0;

		Integer valor = listElementosPeso.get(listElementosPeso.size() - 1);
		listElementosPeso.remove(listElementosPeso.size() - 1);
		if (valor < Cantidades.LIMITE_50.getCantidad()) {
			do {
				listElementosPeso.remove(0);
				cantidadElementosSaco++;
				double pesoInflado = validarPesoQueFalta(listElementosPeso);
				if (!listElementosPeso.isEmpty() && pesoInflado < Cantidades.LIMITE_50.getCantidad() ) {
					listElementosPeso.clear();
				}

			} while (!listElementosPeso.isEmpty() && calculoEmpleadoVentaja(valor, cantidadElementosSaco) < Cantidades.LIMITE_50.getCantidad());
			cantidadViajes++;

		} else {
			cantidadViajes++;

		}

		return cantidadViajes;
	}

	private double validarPesoQueFalta(List<Integer> list) {
		return !list.isEmpty() ? calculoEmpleadoVentaja(list.get(list.size() - 1), list.size()) : Cantidades.LIMITE_0.getCantidad();
	}

	private double calculoEmpleadoVentaja(int pesoElemento, int cantidadElementos) {
		return Math.multiplyExact(pesoElemento, cantidadElementos);
	}

}
