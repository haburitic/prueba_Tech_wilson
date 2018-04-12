package com.negocio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.negocio.dto.EmpleadoDto;
import com.negocio.excepcion.BussinnesExcepcion;
import com.negocio.impl.GestionEmpleadoImpl;


@RestController
@Validated
@RequestMapping("/api")
public class GestionEmpleadoController {
	@Autowired
	private GestionEmpleadoImpl gestionEmpleadoImpl;
	
	@CrossOrigin
    @GetMapping(value = "/consultar/empleados")
	public ResponseEntity<Object>  consultarEmpleados() {
		try {
				return ResponseEntity.status(HttpStatus.OK).body(gestionEmpleadoImpl.consultarEmpleados());
		}  catch (BussinnesExcepcion e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
		} catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
    
	@CrossOrigin
	@PostMapping(value = "/guardar/empleado")
	public ResponseEntity<Object>  guardarEmpleado(final @Valid @RequestBody EmpleadoDto empleadoDto) {
		try {
				return ResponseEntity.status(HttpStatus.OK).body(gestionEmpleadoImpl.guardar(empleadoDto));
		}  catch (BussinnesExcepcion e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
		} catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
          
 }
