package testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ModuloContratoPage {
    protected WebDriver navegador;

    public ModuloContratoPage(WebDriver navegador){
        this.navegador = navegador;
    }
    public void acessaMenuEmpresa(){
        Actions acaoMouse = new Actions(this.navegador);
        WebElement menuEmpresa = this.navegador.findElement(By.xpath("//*[@id=\"view\"]/div/div[1]/div[3]/table/tbody/tr/td[3]/a"));
        acaoMouse.moveToElement(menuEmpresa).perform();
    }
    public void acessaTelaEmpresa(){
        WebElement telaEmpresa = this.navegador.findElement(By.xpath("//*[@id=\"view\"]/div/div[3]/div/div[1]/table/tbody/tr/td[2]"));
        telaEmpresa.click();
    }
    public void acessaMenuContrato(){
        Actions acaoMouse = new Actions(this.navegador);
        WebElement menuContrato = this.navegador.findElement(By.xpath("//*[@id=\"view\"]/div/div[1]/div[2]/table/tbody/tr/td[3]/a"));
        acaoMouse.moveToElement(menuContrato).perform();
    }

}
