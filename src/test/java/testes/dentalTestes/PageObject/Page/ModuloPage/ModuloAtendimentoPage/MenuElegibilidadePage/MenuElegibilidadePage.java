package testes.dentalTestes.PageObject.Page.ModuloPage.ModuloAtendimentoPage.MenuElegibilidadePage;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloAtendimentoPage.ModuloAtendimentoPage;

import java.awt.*;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.time.temporal.WeekFields;

public class MenuElegibilidadePage extends ModuloAtendimentoPage {
    public MenuElegibilidadePage(WebDriver navegador) {
        super(navegador);
    }
    public MenuElegibilidadePage insereCodigoCartaoBeneficiario(String codigoCartao){
        WebElement campoCodigoCartao = this.navegador.findElement(By.id("codigo"));
        campoCodigoCartao.sendKeys(codigoCartao);
        WebElement clicaElementoParaDesfocar = this.navegador.findElement(By.cssSelector("#dir > fieldset > form > fieldset > h1"));
        clicaElementoParaDesfocar.click();
        WebElement campoNome = this.navegador.findElement(By.id("associado.nome"));

        return this;
    }
    public MenuElegibilidadePage insereCPFBeneficiario(String cpf){
        WebElement campoCPFBeneficiario = this.navegador.findElement(By.name("associado.cpf"));
        campoCPFBeneficiario.sendKeys(cpf);
        WebElement clicaElementoParaDesfocar = this.navegador.findElement(By.cssSelector("#dir > fieldset > form > fieldset > h1"));
        clicaElementoParaDesfocar.click();
        return this;
    }
    public MenuElegibilidadePage fechaPopupAlertaBeneficiario()  {
        try {
            WebDriverWait webWait = new WebDriverWait(this.navegador, 8);
            webWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"popup_container\"]")));
            WebElement popupAlerta = this.navegador.findElement(By.xpath("//*[@id=\"popup_ok\"]"));
            popupAlerta.click();
        }catch (NoSuchElementException popupNaoEncontrada){
            popupNaoEncontrada.printStackTrace();
        }
        return this;
    }
}
