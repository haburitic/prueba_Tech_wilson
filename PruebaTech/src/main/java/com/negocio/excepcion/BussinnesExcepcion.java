package com.negocio.excepcion;

/**
 * El objetivo de esta clase, es para errores de negocio
 * @author HABUR
 *
 */
public class BussinnesExcepcion  extends Exception {

	private static final long serialVersionUID = 1L;

	
	/**
	 * @param msg, mensaje del error que se esta levantando
	 */
	public BussinnesExcepcion(String msg) {
	        super(msg);
	    }
}