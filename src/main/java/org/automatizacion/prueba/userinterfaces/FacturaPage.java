package org.automatizacion.prueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FacturaPage {

    public static final Target ITEM_TOTAL = Target.the("item total").locatedBy("//div[@class='summary_subtotal_label']");
    public static final Target TAX = Target.the("Tax").located(By.id("//div[@class='summary_tax_label']"));
    public static final Target TOTAL = Target.the("total").located(By.id("//div[@class='summary_total_label']"));



}
