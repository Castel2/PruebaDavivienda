package org.automatizacion.prueba.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.automatizacion.prueba.exceptions.ErrorValidacionCarrito;
import org.automatizacion.prueba.interaction.AbrirPagina;
import org.automatizacion.prueba.models.Cuenta;
import org.automatizacion.prueba.question.ValidarCarrito;
import org.automatizacion.prueba.tasks.AgregarCarrito;
import org.automatizacion.prueba.tasks.Checkout;
import org.automatizacion.prueba.tasks.LogIn;
import org.automatizacion.prueba.utils.Constantes;
import org.openqa.selenium.WebDriver;


public class CompraStepDefinitions {

    @Managed
    private WebDriver driver;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Davivienda");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(driver));
    }

    @Given("^el usurio ingresa sus credenciales (.*), (.*) con el tipo de logueo (.*)$")
    public void elUsurioIngresaSusCredencialesConElTipoDeLogueo(String username, String password, String tipo) {
        Cuenta cuenta = new Cuenta(username, password);
        OnStage.theActorInTheSpotlight().remember(Constantes.TIPO_USUARIO, tipo);
        OnStage.theActorInTheSpotlight().wasAbleTo(AbrirPagina.site(), LogIn.whit(cuenta));
    }

    @When("^Seleccionar los productos con una cantidad total de (.*)$")
    public void selectProductFrom(String cantidad) {
        OnStage.theActorInTheSpotlight().attemptsTo(AgregarCarrito.with(cantidad));
    }

    @And("^Se observan los productos en el carrido de compras$")
    public void seObservanLosProductosEnElCarritoDeCompras() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarCarrito.estaCorrecto()).orComplainWith(Error.class, ErrorValidacionCarrito.MENSAJE_ERROR));
    }

    @And("^Se realiza el checkout con los siguientes datos (.*), (.*), (.*)$")
    public void reslizaElCheckOur(String nombre, String apellido, String codigo) {
        OnStage.theActorInTheSpotlight().attemptsTo(Checkout.checkout(nombre,apellido,codigo));
    }

    @Then("^Se valida el total de la compra$")
    public void validarCompra() {
        OnStage.theActorInTheSpotlight().attemptsTo();
    }

    @And("^Se cierra la sesion$")
    public void cerrarSesion() {
        OnStage.theActorInTheSpotlight().attemptsTo();
    }

}
