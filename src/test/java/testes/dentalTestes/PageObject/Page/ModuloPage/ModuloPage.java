package testes.dentalTestes.PageObject.Page.ModuloPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ModuloPage {
    private WebDriver navegador;

    public ModuloPage(WebDriver navegador){
        this.navegador = navegador;
    }
    public void selecionaMenuAtendimento(){
        Actions acaoMouse = new Actions(this.navegador);
        this.navegador.switchTo().frame("main");
        WebElement moduloAtendimento = this.navegador.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(2) > a > img"));
        acaoMouse.moveToElement(moduloAtendimento).build().perform();
        moduloAtendimento.click();
    }
    public void clicaModuloContrato(){
        Actions acaoMouse = new Actions(this.navegador);
        this.navegador.switchTo().frame("main");
        WebElement moduloContrato =  this.navegador.findElement(By.xpath("(//img[@alt='Contratos'])[2]"));
        acaoMouse.moveToElement(moduloContrato).build().perform();
        moduloContrato.click();
    }
}
