package org.automatizacion.prueba.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class EscribirInput implements Task {

    private Target target;
    private String dato;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(dato).into(target));
    }

    public static EscribirInput escribirInput(Target target, String dato){
        return Tasks.instrumented(EscribirInput.class,target,dato);
    }
}
