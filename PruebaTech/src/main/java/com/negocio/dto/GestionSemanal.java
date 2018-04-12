package com.negocio.dto;

import java.util.List;

public class GestionSemanal {
	private Integer diasLaborados;
	private List<DiaTrabajo> listaDias;

	public Integer getDiasLaborados() {
		return diasLaborados;
	}

	public void setDiasLaborados(Integer diasLaborados) {
		this.diasLaborados = diasLaborados;
	}

	public List<DiaTrabajo> getListaDias() {
		return listaDias;
	}

	public void setListaDias(List<DiaTrabajo> listaDias) {
		this.listaDias = listaDias;
	}

}
