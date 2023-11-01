package testes.dentalTestes.PageObject.Page.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginFormPage {

    private WebDriver navegador;


    public LoginFormPage(WebDriver navegador){
        this.navegador = navegador;
    }
    public LoginFormPage tipoLogin(String tipoLogin){
        WebElement comboTipoUsuario = this.navegador.findElement(By.name("usuario.tipoPerfil"));
        new Select(comboTipoUsuario).selectByVisibleText(tipoLogin);
        return this;
    }
    public LoginFormPage dadoCampoLogin(String login){
        WebElement divLoginColaborador = this.navegador.findElement(By.xpath("/html/body/form/div/div/div[2]"));
        divLoginColaborador.findElement(By.name("usuario.login")).click();
        divLoginColaborador.findElement(By.name("usuario.login")).sendKeys(login);
        return this;
    }
    public LoginFormPage dadoCampoSenha(String senha){
        WebElement divSenhaColaborador = this.navegador.findElement(By.xpath("/html/body/form/div/div/div[3]"));
        divSenhaColaborador.findElement(By.name("usuario.senha")).sendKeys(senha);
        divSenhaColaborador.click();
        return this;
    }

}
