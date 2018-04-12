
package com.negocio.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.negocio.dto.CargaElementos;
import com.negocio.dto.EmpleadoDto;
import com.negocio.entity.DatosCarga;
import com.negocio.impl.CalcularCargaMudanzaImpl;
import com.negocio.impl.TranformarListasImpl;
import com.negocio.repository.RegistroEjecucionDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GestionCargaControllerTest {
	
	GestionCargaController gestionCargaController= new GestionCargaController();
	@InjectMocks private CalcularCargaMudanzaImpl calcularCargaMudanzaImpl = new CalcularCargaMudanzaImpl();
	@InjectMocks private TranformarListasImpl tranformarListasImpl= new TranformarListasImpl();
	@Mock RegistroEjecucionDao registroEjecucionDao;

	@Before()
	public void beafor(){
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(gestionCargaController, "calcularCargaMudanzaImpl", calcularCargaMudanzaImpl);
		ReflectionTestUtils.setField(calcularCargaMudanzaImpl, "tranformarListasImpl", tranformarListasImpl);
		ReflectionTestUtils.setField(calcularCargaMudanzaImpl, "registroEjecucionDao", registroEjecucionDao);


	}

	@SuppressWarnings("unchecked")
	@Test
	public void procesarDatosDePersonasCaso1() {
		CargaElementos elementos= new CargaElementos();
		EmpleadoDto empleado = new EmpleadoDto(1l,"Wilson","Data");
		elementos.setEmpleado(empleado);
		Queue<Integer> list= new ArrayDeque<>();
				list.add(1);
				list.add(4);
				list.add(30);
				list.add(30);
				list.add(1);
				list.add(1);
		elementos.setLista(list);
		ResponseEntity<Object> data = gestionCargaController.procesarDatosDePersonas(elementos);
		assertEquals(((List<DatosCarga>) data.getBody()).get(0).getCantidadViajes(),"Case # 0 2");
	}
         
	

	@SuppressWarnings("unchecked")
	@Test
	public void procesarDatosDePersonasCaso2() {
		 CargaElementos elementos= new CargaElementos();
		EmpleadoDto empleado = new EmpleadoDto(1l,"Wilson","Data");
		elementos.setEmpleado(empleado);
		Queue<Integer> list= new ArrayDeque<>();
				list.add(1);
				list.add(3);
				list.add(20);
				list.add(20);
				list.add(20);
		elementos.setLista(list);
		ResponseEntity<Object> data = gestionCargaController.procesarDatosDePersonas(elementos);
		assertEquals(((List<DatosCarga>) data.getBody()).get(0).getCantidadViajes(),"Case # 0 1");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void procesarDatosDePersonasCaso3() {
		CargaElementos elementos= new CargaElementos();
		EmpleadoDto empleado = new EmpleadoDto(1l,"Wilson","Data");
		elementos.setEmpleado(empleado);
		Queue<Integer> list= new ArrayDeque<>();
				list.add(1);
				list.add(11);
				list.add(1);
				list.add(2);
				list.add(3);
				list.add(4);
				list.add(5);
				list.add(6);
				list.add(7);
				list.add(8);
				list.add(9);
				list.add(10);
				list.add(11);

		elementos.setLista(list);
		ResponseEntity<Object> data = gestionCargaController.procesarDatosDePersonas(elementos);
		assertEquals(((List<DatosCarga>) data.getBody()).get(0).getCantidadViajes(),"Case # 0 2");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void procesarDatosDePersonasCaso4() {
		 CargaElementos elementos= new CargaElementos();
		EmpleadoDto empleado = new EmpleadoDto(1l,"Wilson","Data");
		elementos.setEmpleado(empleado);
		Queue<Integer> list= new ArrayDeque<>();
				list.add(1);
				list.add(6);
				list.add(9);
				list.add(19);
				list.add(29);
				list.add(39);
				list.add(49);
				list.add(59);

		elementos.setLista(list);
		ResponseEntity<Object> data = gestionCargaController.procesarDatosDePersonas(elementos);
		assertEquals(((List<DatosCarga>) data.getBody()).get(0).getCantidadViajes(),"Case # 0 3");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void procesarDatosDePersonasCaso5() {
		CargaElementos elementos= new CargaElementos();
		EmpleadoDto empleado = new EmpleadoDto(1l,"Wilson","Data");
		elementos.setEmpleado(empleado);
		Queue<Integer> list= new ArrayDeque<>();
				list.add(1);
				list.add(10);
				list.add(32);
				list.add(56);
				list.add(76);
				list.add(8);
				list.add(44);
				list.add(60);
				list.add(47);
				list.add(85);
				list.add(71);
				list.add(91);


		elementos.setLista(list);
		ResponseEntity<Object> data = gestionCargaController.procesarDatosDePersonas(elementos);
		assertEquals(((List<DatosCarga>) data.getBody()).get(0).getCantidadViajes(),"Case # 0 8");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void procesarDatosDePersonasCasoTodos() {
		CargaElementos elementos= new CargaElementos();
		EmpleadoDto empleado = new EmpleadoDto(1l,"Wilson","Data");
		elementos.setEmpleado(empleado);
		Queue<Integer> list= new ArrayDeque<>();
		list.add(5);
		list.add(4);
		list.add(30);
		list.add(30);
		list.add(1);
		list.add(1);
		list.add(3);
		list.add(20);
		list.add(20);
		list.add(20);
		list.add(11);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(6);
		list.add(9);
		list.add(19);
		list.add(29);
		list.add(39);
		list.add(49);
		list.add(59);
		list.add(10);
		list.add(32);
		list.add(56);
		list.add(76);
		list.add(8);
		list.add(44);
		list.add(60);
		list.add(47);
		list.add(85);
		list.add(71);
		list.add(91);
		elementos.setLista(list);
		ResponseEntity<Object> data = gestionCargaController.procesarDatosDePersonas(elementos);
		assertEquals(((List<DatosCarga>) data.getBody()).get(0).getCantidadViajes(),"Case # 0 2");
		assertEquals(((List<DatosCarga>) data.getBody()).get(1).getCantidadViajes(),"Case # 1 1");
		assertEquals(((List<DatosCarga>) data.getBody()).get(2).getCantidadViajes(),"Case # 2 2");
		assertEquals(((List<DatosCarga>) data.getBody()).get(3).getCantidadViajes(),"Case # 3 3");
		assertEquals(((List<DatosCarga>) data.getBody()).get(4).getCantidadViajes(),"Case # 4 8");
	}
	
	
	@Test
	public void procesarDatosDePersonasCaso1ValidaCantidadDiasBajoRestriccion() {
		CargaElementos elementos= new CargaElementos();
		EmpleadoDto empleado = new EmpleadoDto(1l,"Wilson","Data");
		elementos.setEmpleado(empleado);
		Queue<Integer> list= new ArrayDeque<>();
				list.add(0);
				list.add(4);
				list.add(30);
				list.add(30);
				list.add(1);
				list.add(1);
		elementos.setLista(list);
		ResponseEntity<Object> data = gestionCargaController.procesarDatosDePersonas(elementos);
		assertEquals((String) data.getBody(),"Restricción: la cantidad de dias debe estar entre 1 y 500, valor: 0");
	}
	
	@Test
	public void procesarDatosDePersonasCaso1ValidaCantidadDiasMayorRestriccion() {
		CargaElementos elementos= new CargaElementos();
		EmpleadoDto empleado = new EmpleadoDto(1l,"Wilson","Data");
		elementos.setEmpleado(empleado);
		Queue<Integer> list= new ArrayDeque<>();
				list.add(501);
				list.add(4);
				list.add(30);
				list.add(30);
				list.add(1);
				list.add(1);
		elementos.setLista(list);
		ResponseEntity<Object> data = gestionCargaController.procesarDatosDePersonas(elementos);
		assertEquals((String) data.getBody(),"Restricción: la cantidad de dias debe estar entre 1 y 500, valor: 501");
	}
	
	@Test
	public void procesarDatosDePersonasCaso1ValidaCantidadPorDiaMenorRestriccion() {
		CargaElementos elementos= new CargaElementos();
		EmpleadoDto empleado = new EmpleadoDto(1l,"Wilson","Data");
		elementos.setEmpleado(empleado);
		Queue<Integer> list= new ArrayDeque<>();
				list.add(1);
				list.add(0);
				list.add(30);
				list.add(30);
				list.add(1);
				list.add(1);
		elementos.setLista(list);
		ResponseEntity<Object> data = gestionCargaController.procesarDatosDePersonas(elementos);
		assertEquals((String) data.getBody(),"Restrcción: la cantidad elementos por día debe estar entre 1 y 100, valor: 0");
	}
	
	@Test
	public void procesarDatosDePersonasCaso1ValidaCantidadPorDiaMayorRestriccion() {
		CargaElementos elementos= new CargaElementos();
		EmpleadoDto empleado = new EmpleadoDto(1l,"Wilson","Data");
		elementos.setEmpleado(empleado);
		Queue<Integer> list= new ArrayDeque<>();
				list.add(1);
				list.add(101);
				list.add(30);
				list.add(30);
				list.add(1);
				list.add(1);
		elementos.setLista(list);
		ResponseEntity<Object> data = gestionCargaController.procesarDatosDePersonas(elementos);
		assertEquals((String) data.getBody(),"Restrcción: la cantidad elementos por día debe estar entre 1 y 100, valor: 101");
	}
	
	@Test
	public void procesarDatosDePersonasCaso1ValidaCantidadPesoMenorRestriccion() {
		CargaElementos elementos= new CargaElementos();
		EmpleadoDto empleado = new EmpleadoDto(1l,"Wilson","Data");
		elementos.setEmpleado(empleado);
		Queue<Integer> list= new ArrayDeque<>();
				list.add(1);
				list.add(4);
				list.add(0);
				list.add(30);
				list.add(1);
				list.add(1);
		elementos.setLista(list);
		ResponseEntity<Object> data = gestionCargaController.procesarDatosDePersonas(elementos);
		assertEquals((String) data.getBody(),"Restricción: la caja debe estar entre 1 y 100, valor: 0");
	}
	
	@Test
	public void procesarDatosDePersonasCaso1ValidaCantidadPesoMayorRestriccion() {
		CargaElementos elementos= new CargaElementos();
		EmpleadoDto empleado = new EmpleadoDto(1l,"Wilson","Data");
		elementos.setEmpleado(empleado);
		Queue<Integer> list= new ArrayDeque<>();
				list.add(1);
				list.add(4);
				list.add(101);
				list.add(30);
				list.add(1);
				list.add(1);
		elementos.setLista(list);
		ResponseEntity<Object> data = gestionCargaController.procesarDatosDePersonas(elementos);
		assertEquals((String) data.getBody(),"Restricción: la caja debe estar entre 1 y 100, valor: 101");
	}
	
	@Test
	public void procesarDatosDePersonasCaso1ValidaDiasTrabajoNull() {
		CargaElementos elementos= new CargaElementos();
		EmpleadoDto empleado = new EmpleadoDto(1l,"Wilson","Data");
		elementos.setEmpleado(empleado);
		Queue<Integer> list= new ArrayDeque<>();
				list.add(-1);
				list.add(4);
				list.add(101);
				list.add(30);
				list.add(1);
				list.add(1);
		elementos.setLista(list);
		ResponseEntity<Object> data = gestionCargaController.procesarDatosDePersonas(elementos);
		assertEquals((String) data.getBody(),"Restricción: la cantidad de dias debe estar entre 1 y 500, valor: -1");
	}
	
	@Test
	public void procesarDatosDePersonasCaso1ValidarCantidadElementosNegativoTrabajoNull() {
		CargaElementos elementos= new CargaElementos();
		EmpleadoDto empleado = new EmpleadoDto(1l,"Wilson","Data");
		elementos.setEmpleado(empleado);
		Queue<Integer> list= new ArrayDeque<>();
				list.add(1);
				list.add(-4);
				list.add(101);
				list.add(30);
				list.add(1);
				list.add(1);
		elementos.setLista(list);
		ResponseEntity<Object> data = gestionCargaController.procesarDatosDePersonas(elementos);
		assertEquals((String) data.getBody(),"Restrcción: la cantidad elementos por día debe estar entre 1 y 100, valor: -4");
	}
	
	@Test
	public void procesarDatosDePersonasCaso1ValidarElementosNegativoTrabajoNull() {
		CargaElementos elementos= new CargaElementos();
		EmpleadoDto empleado = new EmpleadoDto(1l,"Wilson","Data");
		elementos.setEmpleado(empleado);
		Queue<Integer> list= new ArrayDeque<>();
				list.add(1);
				list.add(4);
				list.add(-1);
				list.add(30);
				list.add(1);
				list.add(1);
		elementos.setLista(list);
		ResponseEntity<Object> data = gestionCargaController.procesarDatosDePersonas(elementos);
		assertEquals((String) data.getBody(),"Restricción: la caja debe estar entre 1 y 100, valor: -1");
	}
	
	@Test
	public void procesarDatosDePersonasCaso1ValidarErrorCantidadFaltante() {
		CargaElementos elementos= new CargaElementos();
		EmpleadoDto empleado = new EmpleadoDto(1l,"Wilson","Data");
		elementos.setEmpleado(empleado);
		Queue<Integer> list= new ArrayDeque<>();
				list.add(1);
				list.add(4);
				list.add(1);
				list.add(30);
		elementos.setLista(list);
		ResponseEntity<Object> data = gestionCargaController.procesarDatosDePersonas(elementos);
		assertEquals((String) data.getBody(),"la cantidad de elementos: 4 debe ser igual a la cantidad de la lista 2");
	}
 }
