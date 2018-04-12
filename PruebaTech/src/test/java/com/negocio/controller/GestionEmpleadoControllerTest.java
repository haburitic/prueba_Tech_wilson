package com.negocio.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.negocio.dto.EmpleadoDto;
import com.negocio.entity.Empleado;
import com.negocio.impl.GestionEmpleadoImpl;
import com.negocio.repository.EmpleadoDao;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GestionEmpleadoControllerTest {
	

	
	GestionEmpleadoController controller= new GestionEmpleadoController();
	@InjectMocks private GestionEmpleadoImpl gestionEmpleadoImpl= new GestionEmpleadoImpl();
    @Mock private EmpleadoDao empleadoDao;
    
	@Before()
	public void beafor(){
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(controller, "gestionEmpleadoImpl", gestionEmpleadoImpl);
		ReflectionTestUtils.setField(gestionEmpleadoImpl, "empleadoDao", empleadoDao);

	}   
	
	@Test
	public void guardarempleado() {
		
		EmpleadoDto empleadoDto=new EmpleadoDto();
		empleadoDto.setIdentificacion("id");
		empleadoDto.setNombre("Martin");
		Empleado arg0 = new Empleado();
		arg0.setIdentificacion("id");
		arg0.setNombre("Martin");
		arg0.setId(1l);
		Mockito.when(empleadoDao.save(Mockito.any())).thenReturn(arg0);
		ResponseEntity<Object> resp = controller.guardarEmpleado(empleadoDto);
		assertEquals("id", ((EmpleadoDto) resp.getBody()).getIdentificacion());
		assertEquals("Martin", ((EmpleadoDto) resp.getBody()).getNombre());
	
 }
	
	@Test
	public void guardarempleadonULL() {
		
		Empleado arg0 = new Empleado();
		arg0.setIdentificacion("Corredor");
		arg0.setNombre("Martin");
		arg0.setId(1l);
		Mockito.when(empleadoDao.save(Mockito.any())).thenReturn(arg0);
		ResponseEntity<Object> resp = controller.guardarEmpleado(null);
		assertEquals("Elemento NULO", ((String) resp.getBody()));
 }
	@Test
	public void guardarempleadonULLPointer() {
		EmpleadoDto empleadoDto=new EmpleadoDto();

		empleadoDto.setIdentificacion("Corredor");
		empleadoDto.setNombre("Martin");
		Empleado arg0 = new Empleado();
		arg0.setIdentificacion("Corredor");
		arg0.setNombre("Martin");
		arg0.setId(1l);
		Mockito.when(empleadoDao.save(Mockito.any())).thenThrow(new NullPointerException());
		ResponseEntity<Object> resp = controller.guardarEmpleado(empleadoDto);
		assertEquals("500", resp.getStatusCode().toString());
 }
	
	@Test
	public void consultaempleadonullPointer() {
		
		Mockito.when(empleadoDao.findAll()).thenThrow(new NullPointerException());
		ResponseEntity<Object> resp = controller.consultarEmpleados();
		assertEquals("500", resp.getStatusCode().toString());
 }
	
	
	@Test
	public void consultaempleadoSinRegistros() {
		
		Mockito.when(empleadoDao.findAll()).thenReturn(null);
		ResponseEntity<Object> resp = controller.consultarEmpleados();
		assertEquals("500", resp.getStatusCode().toString());
 }
	
	@SuppressWarnings("unchecked")
	@Test
	public void consultaempleadoconegistros() {
		
		List<Empleado> data = new ArrayList<>();
		Empleado arg0= new Empleado();
		arg0.setNombre("Nombre");
		arg0.setIdentificacion("Cargo");
		data.add(arg0);
		Mockito.when(empleadoDao.findAll()).thenReturn(data);
		ResponseEntity<Object> resp = controller.consultarEmpleados();
		assertEquals("Cargo", ((List<EmpleadoDto>) resp.getBody()).get(0).getIdentificacion());
		assertEquals("Nombre", ((List<EmpleadoDto>) resp.getBody()).get(0).getNombre());

 }
	
}
