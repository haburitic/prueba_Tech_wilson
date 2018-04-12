package com.negocio.util;

public enum Textos {
    CANTIDAD_ELEMENTOS("la cantidad de elementos: "),
    CANTIDAD_LISTA(" debe ser igual a la cantidad de la lista "),
    RESTRICCION_100_CAJA("Restricción: la caja debe estar entre 1 y 100, valor: "),
    RESTRICCION_100_CANTIDAD_DIA("Restrcción: la cantidad elementos por día debe estar entre 1 y 100, valor: "),
    RESTRICCION_500("Restricción: la cantidad de dias debe estar entre 1 y 500, valor: "),
    NO_GUARDO("Error No guardo, contacte al administrador"),
    NO_HAY_EMPLEADOS("No hay Empleados"),
    OBJETO_NULL("Elemento NULO");
	
    private String url;

    Textos(String url) {
        this.url = url;
    }

    public String getTexto() {
        return url;
    }
}