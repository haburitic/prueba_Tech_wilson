package com.negocio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.negocio.dto.CargaElementos;
import com.negocio.excepcion.BussinnesExcepcion;
import com.negocio.impl.CalcularCargaMudanzaImpl;


@RestController
@Validated
@RequestMapping("/api")
@CrossOrigin
public class GestionCargaController {
	@Autowired
	private CalcularCargaMudanzaImpl calcularCargaMudanzaImpl;
	

    @RequestMapping(value = "/gestionCarga/procesar", method = RequestMethod.POST )
	public ResponseEntity<Object>  procesarDatosDePersonas(@Valid @RequestBody CargaElementos elementos) {
		try {
				return ResponseEntity.status(HttpStatus.OK).body(calcularCargaMudanzaImpl.procesarDatos(elementos));
		}  		
		 catch (BussinnesExcepcion e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
		} catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
          
 }
