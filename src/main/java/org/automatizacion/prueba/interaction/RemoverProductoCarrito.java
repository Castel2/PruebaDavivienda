package org.automatizacion.prueba.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static org.automatizacion.prueba.userinterfaces.ProductsPage.ELIMINAR_PRODUCTO_CART;

public class RemoverProductoCarrito implements Task {
    private String precio;

    public RemoverProductoCarrito(String precio) {
        this.precio = precio;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ELIMINAR_PRODUCTO_CART.of(precio)));
    }

    public static RemoverProductoCarrito removerProductoCarrito(String price){
        return Tasks.instrumented(RemoverProductoCarrito.class,price);
    }
}
