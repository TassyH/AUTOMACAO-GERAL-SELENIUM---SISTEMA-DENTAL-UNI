package testes.dentalTestes.PageObject.Page.ModuloPage.ModuloAtendimentoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ModuloAtendimentoPage {
    protected WebDriver navegador;

    public ModuloAtendimentoPage(WebDriver navegador){
        this.navegador = navegador;
    }
    public void acessaMenuGuia(){
        Actions acaoMouse = new Actions(navegador);
        WebElement menuGuiaNormal = this.navegador.findElement(By.cssSelector("#view > div > div.zpMenu.zpMenu-lines-t > div:nth-child(3) > table > tbody > tr > td.zpMenu-label > a"));
        acaoMouse.moveToElement(menuGuiaNormal).perform();
    }
    public void acessaMenuGuiaNormal(){
        Actions acaoMouse = new Actions(navegador);
        WebElement menuGuiaNormal = this.navegador.findElement(By.cssSelector("#view > div > div.zpMenu.zpMenu-lines-t > div:nth-child(3) > table > tbody > tr > td.zpMenu-label > a"));
        acaoMouse.moveToElement(menuGuiaNormal).perform();
        WebElement subMenuGuiaNormal = this.navegador.findElement(By.cssSelector("#view > div > div.zpMenu.zpMenu-lines-t > div:nth-child(3)"));
        subMenuGuiaNormal.click();
    }
    public void acessaMenuGuiaSolicitaExame() throws InterruptedException {
        Actions acaoMouse = new Actions(navegador);
        WebElement menuGuiaNormal = this.navegador.findElement(By.cssSelector("#view > div > div.zpMenu.zpMenu-lines-t > div:nth-child(3) > table > tbody > tr > td.zpMenu-label > a"));
        acaoMouse.moveToElement(menuGuiaNormal).perform();
        Thread.sleep(3000);
        WebElement menuGuiaSolicitaExame = this.navegador.findElement(By.cssSelector("#view > div > div:nth-child(2) > div > div.zpMenu-item.zpMenu-level-2.zpMenu-item-even.zpMenu-lines-c > table > tbody > tr > td.zpMenu-label > a"));
        menuGuiaSolicitaExame.click();
    }
    public void acessaMenuElegibilidade(){
        WebElement elementoMenuElegibilidade = this.navegador.findElement(By.xpath("//*[@id=\"view\"]/div/div[1]/div[2]/table/tbody/tr/td[2]/a"));
        elementoMenuElegibilidade.click();
    }


}
