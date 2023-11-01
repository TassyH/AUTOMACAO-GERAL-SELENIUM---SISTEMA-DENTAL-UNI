package testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.MenuContratoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.ModuloContratoPage;

public class MenuContratoPage extends ModuloContratoPage {
    static String codigoContrato;
    public MenuContratoPage(WebDriver navegador) {
        super(navegador);
    }
    public void acessaContratoTela() throws InterruptedException {
        Thread.sleep(2000);
        WebElement clicaContratoMenu = this.navegador.findElement(By.xpath("//div[@id='view']/div/div[2]/div/div/table/tbody/tr/td[2]/a"));
        clicaContratoMenu.click();
    }
    public void listaContratoTela(){
        WebElement botaoListarContrato = this.navegador.findElement(By.xpath("(//a[contains(text(),'Listar')])[3]"));
        botaoListarContrato.click();
    }
    public void novoContratoTela(){
        WebElement botaoNovoContrato = this.navegador.findElement(By.xpath("//a[contains(text(),'Novo')]"));
        botaoNovoContrato.click();
    }
    public MenuContratoPage consultaContratoExistentePelaTeladeListagem(String codContrato){
        WebElement campoCodContrato = this.navegador.findElement(By.name("view.codigoContratoString"));
        campoCodContrato.sendKeys(codContrato);
        return this;
    }
    public MenuContratoPage clicaBotaoConsultar(){
        WebElement buscaContrato = this.navegador.findElement(By.xpath("//*[@id=\"linkConsultar\"]"));
        buscaContrato.click();
        return this;
    }
    public MenuContratoPage clicaCodigoContratoRetornadoDaConsulta(){
        WebElement clicaNumContrato = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/table[2]/tbody/tr[2]/td[2]/a"));
        clicaNumContrato.click();
        return this;
    }
}
