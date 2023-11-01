package testes.dentalTestes.PageObject.Page.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver navegador;
    public LoginPage(WebDriver navegador){
        this.navegador = navegador;
    }
    public void telaClickDivLogin() throws InterruptedException {
        Thread.sleep(2000);
        this.navegador.switchTo().frame(1);
        WebElement divTelaLogin = this.navegador.findElement(By.xpath("/html/body/form/div/div/div[1]"));
        divTelaLogin.findElement(By.xpath("/html/body/form/div/div/div[1]")).submit();
        WebElement popupLoginMensagem = this.navegador.findElement(By.id("popup_container"));
        popupLoginMensagem.findElement(By.id("popup_ok")).click();
    }
    public void telaLoginClickBtnLogin(){
        WebElement btnAcessar = this.navegador.findElement(By.xpath("/html/body/form/div/div/div[4]/a"));
        btnAcessar.findElement(By.xpath("/html/body/form/div/div/div[4]/a")).click();
        navegador.navigate().refresh();
    }
}
