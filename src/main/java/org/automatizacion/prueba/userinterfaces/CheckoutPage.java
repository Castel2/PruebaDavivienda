package org.automatizacion.prueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {
    public static final Target BUTTON_CHECK = Target.the("check").located(By.id("checkout"));
    public static final Target INPUT_NOMBRE = Target.the("nombre").located(By.id("first-name"));
    public static final Target INPUT_APELLIDO = Target.the("last name").located(By.id("last-name"));
    public static final Target INPUT_CODIGO_POSTAL = Target.the("postal code").located(By.id("postal-code"));
    public static final Target INPUT_CONTINUAR = Target.the("continuar").located(By.id("continue"));
    public static final Target MENSAJE_NOMBRE = Target.the("error nombre").locatedBy("//h3[contains(text(),'First Name is required')]");
    public static final Target MENSAJE_APELLIDO = Target.the("error apellido").locatedBy("//h3[contains(text(),'Last Name is required')]");
    public static final Target MENSAJE_CODIGO = Target.the("error codigo").locatedBy("//h3[contains(text(),'Postal Code is required')]");

}
