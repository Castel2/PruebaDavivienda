package org.automatizacion.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.EnsureFieldVisible;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.automatizacion.prueba.interaction.RemoverCatalogo;
import org.automatizacion.prueba.interaction.RemoverProductoCarrito;
import org.automatizacion.prueba.question.Mensaje;
import org.automatizacion.prueba.utils.Constantes;
import org.automatizacion.prueba.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static org.automatizacion.prueba.userinterfaces.LoginPage.USUARIO_BLOQUEADO;
import static org.automatizacion.prueba.userinterfaces.ProductsPage.BUTTON_ADD_CART;
import static org.automatizacion.prueba.userinterfaces.ProductsPage.BUTTON_CART;
import static org.automatizacion.prueba.utils.Constantes.*;

public class AgregarCarrito implements Task {

    private String cantidad;

    public AgregarCarrito(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> pricesFinal = null;
        if (!actor.recall(TIPO_USUARIO).toString().trim().equals(USER_BLOQUEADO.trim()) || !actor.recall(TIPO_USUARIO).toString().trim().equals(USER_PROBLEMA.trim())) {
            List<String> prices = Utils.prices();
            System.out.println(prices.size());
            pricesFinal = new ArrayList<>();
            int cant = Integer.parseInt(cantidad);
            for (int i = 0; i < cant; i++) {
                actor.attemptsTo(Click.on(BUTTON_ADD_CART.of(prices.get(i))));
                pricesFinal.add(prices.get(i));
                Utils.Eliminarprices(prices, prices.get(i));
            }
            if (cant > 1) {
                actor.attemptsTo(RemoverCatalogo.removerCatalogo(pricesFinal.get(0)));
                Utils.Eliminarprices(pricesFinal,pricesFinal.get(0));
                actor.attemptsTo(Click.on(BUTTON_CART));
                if(pricesFinal.size() > 1){
                    actor.attemptsTo(RemoverProductoCarrito.removerProductoCarrito(pricesFinal.get(0)));
                    Utils.Eliminarprices(pricesFinal,pricesFinal.get(0));
                }
            }
        } else if (actor.recall(TIPO_USUARIO).toString().trim().equals(USER_BLOQUEADO.trim())) {
            WaitUntil.the(USUARIO_BLOQUEADO, WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds();
        }
        actor.remember(PRICES, pricesFinal);
    }

    public static AgregarCarrito with(String cantidad) {
        return Tasks.instrumented(AgregarCarrito.class, cantidad);
    }
}
