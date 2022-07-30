package org.automatizacion.prueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsPage {

    public static final Target BUTTON_ADD_CART = Target.the("add cart").
            locatedBy("//div[@class='pricebar']/div[text()='{0}']/following-sibling::button");

    public static final Target BUTTON_CART = Target.the("cart").located(By.id("shopping_cart_container"));


    public static final Target ELIMINAR_PRODUCTO_CART = Target.the("add cart").
            locatedBy("//div[@class='item_pricebar']/div[text()='{0}']/following-sibling::button");



}

