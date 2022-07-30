package org.automatizacion.prueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    public static final Target TXT_PRICE = Target.the("price").locatedBy("//div[@class='item_pricebar']/div[text()='{0}']");

}
