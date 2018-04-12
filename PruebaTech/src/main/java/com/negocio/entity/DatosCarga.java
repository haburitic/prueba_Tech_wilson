package com.negocio.entity;

import com.negocio.dto.EmpleadoDto;

public class DatosCarga {
	private EmpleadoDto empleado; 
	private String cantidadViajes;
	public EmpleadoDto getEmpleado() {
		return empleado;
	}
	public void setEmpleado(EmpleadoDto empleado) {
		this.empleado = empleado;
	}
	public String getCantidadViajes() {
		return cantidadViajes;
	}
	public void setCantidadViajes(String cantidadViajes) {
		this.cantidadViajes = cantidadViajes;
	}

}
