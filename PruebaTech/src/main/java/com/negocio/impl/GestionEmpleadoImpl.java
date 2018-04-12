package com.negocio.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.negocio.dto.EmpleadoDto;
import com.negocio.entity.Empleado;
import com.negocio.excepcion.BussinnesExcepcion;
import com.negocio.repository.EmpleadoDao;
import com.negocio.util.Textos;

@Service
public class GestionEmpleadoImpl {
	
	@Autowired private EmpleadoDao empleadoDao ;

	public List<EmpleadoDto> consultarEmpleados() throws BussinnesExcepcion{
		return mapeoEntidad(empleadoDao.findAll());
		
	}

	private List<EmpleadoDto> mapeoEntidad(List<Empleado> lista) throws BussinnesExcepcion {
		if(lista.isEmpty()){
			throw new BussinnesExcepcion(Textos.NO_HAY_EMPLEADOS.getTexto());
			
		}
		return lista.stream().map(temp->new EmpleadoDto(temp.getId(),temp.getNombre(),temp.getIdentificacion())).collect(Collectors.toList());
	}
	
	public EmpleadoDto guardar(final  EmpleadoDto empleadoDto) throws BussinnesExcepcion {
		validarDto(empleadoDto);
		EmpleadoDto respuestaEntidad = mapeoDto(empleadoDao.save(mapeoEntity(empleadoDto)));
		return respuestaEntidad;
	}
	
	private void validarDto(EmpleadoDto empleadoDto) throws BussinnesExcepcion {
		if(empleadoDto==null){
			throw new BussinnesExcepcion(Textos.OBJETO_NULL.getTexto());
		}
		
	}

	private Empleado mapeoEntity(final EmpleadoDto empleadoDto){
		Empleado empleado = new Empleado();
		empleado.setIdentificacion(empleadoDto.getIdentificacion());
		 empleado.setNombre(empleadoDto.getNombre());
		 return empleado;
	}
	
	private EmpleadoDto mapeoDto(final Empleado empleado){
		EmpleadoDto data = new EmpleadoDto();
		data.setIdentificacion(empleado.getIdentificacion());
		data.setNombre(empleado.getNombre());
		data.setId(empleado.getId());
		 return data;
	}
}
