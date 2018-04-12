package com.negocio.dto;

import java.io.Serializable;
import java.util.Queue;

public class CargaElementos  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private EmpleadoDto empleado;
	private Queue<Integer> lista;
	public EmpleadoDto getEmpleado() {
		return empleado;
	}
	public void setEmpleado(EmpleadoDto empleado) {
		this.empleado = empleado;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Queue<Integer> getLista() {
		return lista;
	}
	public void setLista(Queue<Integer> lista) {
		this.lista = lista;
	}

}
