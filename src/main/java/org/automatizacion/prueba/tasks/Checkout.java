package org.automatizacion.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.automatizacion.prueba.interaction.EscribirInput;
import org.automatizacion.prueba.question.Mensaje;

import static org.automatizacion.prueba.userinterfaces.CheckoutPage.*;
import static org.automatizacion.prueba.utils.Constantes.*;

public class Checkout implements Task {

    private String nombre;
    private String apellido;
    private String codigo_postal;

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!actor.recall(TIPO_USUARIO).toString().trim().equals(USER_BLOQUEADO.trim()) || !actor.recall(TIPO_USUARIO).toString().trim().equals(USER_PROBLEMA.trim())) {
            actor.attemptsTo(Click.on(BUTTON_CHECK), Click.on(INPUT_CONTINUAR));
            if (Mensaje.isTo(MENSAJE_NOMBRE).answeredBy(actor).trim().equals(ERROR_NOMBRE)) {
                actor.attemptsTo(EscribirInput.escribirInput(INPUT_NOMBRE, nombre));
                actor.attemptsTo(Click.on(INPUT_CONTINUAR));
                if (Mensaje.isTo(MENSAJE_APELLIDO).answeredBy(actor).trim().equals(ERROR_APELLIDO)) {
                    actor.attemptsTo(EscribirInput.escribirInput(INPUT_APELLIDO, apellido));
                    actor.attemptsTo(Click.on(INPUT_CONTINUAR));
                    if (Mensaje.isTo(MENSAJE_CODIGO).answeredBy(actor).trim().equals(ERROR_CODIGO_POSTAL)) {
                        actor.attemptsTo(EscribirInput.escribirInput(INPUT_CODIGO_POSTAL, codigo_postal));
                        actor.attemptsTo(Click.on(INPUT_CONTINUAR));
                    }
                }
            }
        }
    }

    public static Checkout checkout(String nombre, String apellido, String codigo_postal) {
        return Tasks.instrumented(Checkout.class, nombre, apellido, codigo_postal);
    }
}
