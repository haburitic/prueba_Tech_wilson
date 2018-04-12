package com.negocio.util;

public enum Cantidades {
    LIMITE_0(0),    
    LIMITE_50(50),    
    LIMITE_500(500),
    LIMITE_100(100);


    private int cantidad;

    Cantidades(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }
}