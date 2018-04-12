package com.negocio.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.stereotype.Service;

import com.negocio.dto.CargaElementos;
import com.negocio.dto.DiaTrabajo;
import com.negocio.dto.GestionSemanal;
import com.negocio.excepcion.BussinnesExcepcion;
import com.negocio.util.Cantidades;
import com.negocio.util.Textos;

@Service
public class TranformarListasImpl {
	
	public GestionSemanal modelarElementos(CargaElementos elementos) throws BussinnesExcepcion {
		GestionSemanal data = identificaDiasTrabajoEmpleado(elementos.getLista());
		return identificarElementosSemanales(elementos.getLista(), data);
	}
	

	private GestionSemanal identificarElementosSemanales(Queue<Integer> lista, GestionSemanal dtoGestion) throws BussinnesExcepcion {
		dtoGestion.setListaDias(new ArrayList<DiaTrabajo>());
		for (int i = 0; i < dtoGestion.getDiasLaborados(); i++) {
			DiaTrabajo data = identificarEventodiario(lista);
			dtoGestion.getListaDias().add(data);
		}
		return dtoGestion;
	}

	private DiaTrabajo identificarEventodiario(Queue<Integer> queue) throws BussinnesExcepcion {
		Integer elementos = queue.poll();
		validarValorCantidadDias(elementos);
		validarCantidadElementosVSCantidadEnlalista(elementos,queue);
		DiaTrabajo diaTrabajo = new DiaTrabajo();
		diaTrabajo.setCantidad(elementos);

		List<Integer> listaEnteros = new LinkedList<>();

		for (int i = 0; i < elementos; i++) {
			Integer entero = queue.poll();
			validarCantidadPeso(entero);
			listaEnteros.add(entero);
		}
		Collections.sort(listaEnteros);
		diaTrabajo.setLista(listaEnteros);

		return diaTrabajo;

	}


	private void validarCantidadElementosVSCantidadEnlalista(Integer elementos, Queue<Integer> queue) throws BussinnesExcepcion {
		if(elementos > queue.size()){
			throw new BussinnesExcepcion(Textos.CANTIDAD_ELEMENTOS.getTexto()+elementos+Textos.CANTIDAD_LISTA.getTexto()+queue.size());
		}			
	}


	private void validarCantidadPeso(Integer entero) throws BussinnesExcepcion {
		if(entero<=Cantidades.LIMITE_0.getCantidad() ||entero>Cantidades.LIMITE_100.getCantidad()){
			throw new BussinnesExcepcion(Textos.RESTRICCION_100_CAJA.getTexto()+entero);
		}		
	}


	private void validarValorCantidadDias(Integer elementos) throws BussinnesExcepcion {
		if(elementos<=Cantidades.LIMITE_0.getCantidad() || elementos>Cantidades.LIMITE_100.getCantidad()){
			throw new BussinnesExcepcion(Textos.RESTRICCION_100_CANTIDAD_DIA.getTexto()+elementos);
		}
	}

	private GestionSemanal identificaDiasTrabajoEmpleado(Queue<Integer> queue) throws BussinnesExcepcion {
		GestionSemanal gestionSemanal = new GestionSemanal();
		gestionSemanal.setDiasLaborados(queue.poll());
		if(gestionSemanal.getDiasLaborados()<=Cantidades.LIMITE_0.getCantidad() || gestionSemanal.getDiasLaborados()>Cantidades.LIMITE_500.getCantidad()){
			throw new BussinnesExcepcion(Textos.RESTRICCION_500.getTexto()+gestionSemanal.getDiasLaborados());
		}
		return gestionSemanal;

	}

}
