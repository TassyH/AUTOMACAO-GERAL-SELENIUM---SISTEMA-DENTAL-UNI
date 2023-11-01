package testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.MenuContratoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.text.WrappedPlainView;

public class CadastroDependenteFormPage extends CadastroBeneficiarioFormPage{
    public CadastroDependenteFormPage(WebDriver navegador) {
        super(navegador);
    }
    public CadastroDependenteFormPage abrirCadastroTitularAtivo(){
        WebElement btnBuscaBenef = this.navegador.findElement(By.cssSelector("label:nth-child(10) > .btnBuscar"));
        btnBuscaBenef.click();
        WebElement btnOkPopUpCarregaBenefAtivos = this.navegador.findElement(By.id("popup_ok"));
        btnOkPopUpCarregaBenefAtivos.click();
        return this;
    }
    public CadastroDependenteFormPage clicaLupaCarregaTitutlar(){
        WebElement lupa = this.navegador.findElement(By.className("btnBuscar"));
        lupa.click();
        return this;
    }
    public CadastroDependenteFormPage selecionaTitularAtivo(String numeroCartaoTitular){
        WebElement btnOkPopUpCarregaBenefAtivos = this.navegador.findElement(By.id("popup_ok"));
        btnOkPopUpCarregaBenefAtivos.click();
        this.navegador.switchTo().frame(0);
        WebElement iframaTitulares = this.navegador.findElement(By.name("usuario.titularListagem"));
        String titulares = iframaTitulares.getText();
            WebElement linkNumCartaobenef = this.navegador.findElement(By.linkText(numeroCartaoTitular));
            linkNumCartaobenef.click();
        return this;
    }
}
