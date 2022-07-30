package org.automatizacion.prueba.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static org.automatizacion.prueba.userinterfaces.FacturaPage.*;
import static org.automatizacion.prueba.utils.Constantes.PRICE_TOTAL;

public class ValidarFactura implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        float total = Float.parseFloat(actor.recall(PRICE_TOTAL.trim())) + Float.parseFloat(Mensaje.isTo(TAX).answeredBy(actor).trim());
        boolean precioTotal = actor.recall(PRICE_TOTAL.trim()).equals(Mensaje.isTo(ITEM_TOTAL).answeredBy(actor).trim());
        boolean Total = String.valueOf(total).equals(Mensaje.isTo(TOTAL).answeredBy(actor).trim());
        return precioTotal && Total;
    }

    public static ValidarFactura validarFactura(){
        return new ValidarFactura();
    }

}
