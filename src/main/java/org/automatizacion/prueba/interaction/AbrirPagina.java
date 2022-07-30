package org.automatizacion.prueba.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import org.automatizacion.prueba.utils.Constantes;


public class AbrirPagina implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(Constantes.URL_BASE));
    }

    public static AbrirPagina site(){
        return Tasks.instrumented(AbrirPagina.class);
    }

}
