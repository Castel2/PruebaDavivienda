package org.automatizacion.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static org.automatizacion.prueba.userinterfaces.Logout.*;
import static org.automatizacion.prueba.utils.Constantes.*;

public class FinalizarCompra implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!actor.recall(TIPO_USUARIO).toString().trim().equals(USER_PROBLEMA.trim())) {
            actor.attemptsTo(Click.on(FINALIZAR),
                    Click.on(MENU),
                    Click.on(LOGOUT));
        }
    }

    public static FinalizarCompra finalizarCompra() {
        return Tasks.instrumented(FinalizarCompra.class);
    }
}
