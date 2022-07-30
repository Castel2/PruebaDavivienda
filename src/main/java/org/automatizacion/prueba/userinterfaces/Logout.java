package org.automatizacion.prueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Logout {

    public static final Target FINALIZAR = Target.the("username").located(By.id("finish"));
    public static final Target MENU = Target.the("menu").located(By.id("react-burger-menu-btn"));
    public static final Target LOGOUT = Target.the("login").located(By.id("logout_sidebar_link"));


}
