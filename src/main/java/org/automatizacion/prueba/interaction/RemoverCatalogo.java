package org.automatizacion.prueba.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static org.automatizacion.prueba.userinterfaces.ProductsPage.BUTTON_ADD_CART;

public class RemoverCatalogo implements Task {

    private String precio;

    public RemoverCatalogo(String precio) {
        this.precio = precio;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BUTTON_ADD_CART.of(precio)));
    }

    public static RemoverCatalogo removerCatalogo(String price){
        return Tasks.instrumented(RemoverCatalogo.class,price);
    }

}
