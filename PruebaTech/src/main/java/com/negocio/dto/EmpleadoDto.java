package com.negocio.dto;

import javax.validation.constraints.NotNull;

public class EmpleadoDto {
	
	
	private Long id;
	@NotNull
	private String nombre;
	
	@NotNull
	private String identificacion;
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public EmpleadoDto() {
	}
	public EmpleadoDto(Long id,String nombre, String identificacion) {
		this.id=id;
		this.nombre=nombre;
		this.identificacion=identificacion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
}
