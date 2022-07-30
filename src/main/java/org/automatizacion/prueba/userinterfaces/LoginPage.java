package org.automatizacion.prueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target INPUT_USERNAME = Target.the("username").located(By.id("user-name"));
    public static final Target INPUT_PASSWORD = Target.the("password").located(By.id("password"));
    public static final Target BUTTON_LOGIN = Target.the("login").located(By.id("login-button"));

    public static final Target USUARIO_BLOQUEADO = Target.the("user bloqueado").locatedBy("//h3[contains(text(),'user has been locked')]");
}
