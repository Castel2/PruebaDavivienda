package org.automatizacion.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.automatizacion.prueba.models.Cuenta;

import static org.automatizacion.prueba.userinterfaces.LoginPage.*;

public class LogIn implements Task {

    private Cuenta cuenta;

    public LogIn(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(cuenta.getUsername()).into(INPUT_USERNAME),
                Enter.theValue(cuenta.getPassword()).into(INPUT_PASSWORD),
                Click.on(BUTTON_LOGIN));
    }

    public static LogIn whit(Cuenta cuenta){
        return Tasks.instrumented(LogIn.class, cuenta);
    }
}
