package com.negocio.dto;

import java.util.List;

public class DiaTrabajo {
	private Integer dia;
	private Integer cantidad;
	private List<Integer> 	lista;
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public List<Integer> getLista() {
		return lista;
	}
	public void setLista(List<Integer> listaEnteros) {
		this.lista = listaEnteros;
	}


}
