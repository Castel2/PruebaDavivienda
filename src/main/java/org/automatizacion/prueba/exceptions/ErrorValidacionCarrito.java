package org.automatizacion.prueba.exceptions;


import org.yecht.Data;

public class ErrorValidacionCarrito extends Error{

    public static final String MENSAJE_ERROR = "No se encuentran los productos selecionados";

    public ErrorValidacionCarrito(String MENSAJE_ERROR, Throwable cause){
        super(MENSAJE_ERROR,cause);
    }

}
