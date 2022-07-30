package org.automatizacion.prueba.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.automatizacion.prueba.utils.Utils;

import java.util.List;

import static org.automatizacion.prueba.userinterfaces.CartPage.TXT_PRICE;
import static org.automatizacion.prueba.utils.Constantes.PRICES;
import static org.automatizacion.prueba.utils.Constantes.PRICE_TOTAL;

public class ValidarCarrito implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean bandera = false;
        List<String> precios = actor.recall(PRICES);
        actor.remember(PRICE_TOTAL, String.valueOf(Utils.CompraTotal(precios)));
        for (int i = 0 ; i< precios.size(); i++){
            if(Text.of(TXT_PRICE.of(precios.get(i))).viewedBy(actor).asString().contains(precios.get(i))){
                bandera = true;
            }
        }
        return bandera;
    }

    public static ValidarCarrito estaCorrecto(){
        return new ValidarCarrito();
    }
}
