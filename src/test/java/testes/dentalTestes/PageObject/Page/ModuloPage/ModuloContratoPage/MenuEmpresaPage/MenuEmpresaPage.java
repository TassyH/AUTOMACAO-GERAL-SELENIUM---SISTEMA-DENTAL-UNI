package testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.MenuEmpresaPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenuEmpresaPage {
    protected WebDriver navegador;

    public MenuEmpresaPage(WebDriver navegador){
        this.navegador = navegador;
    }
    public void criaNovaEmpresa(){
        Actions acaoMouse = new Actions(navegador);
        WebElement botaoNovaEmpresa = this.navegador.findElement(By.className("btn_novo"));
        acaoMouse.moveToElement(botaoNovaEmpresa).perform();
        WebElement clicaBotaoNovo = this.navegador.findElement(By.xpath("//*[@id=\"botoescadastro_novo_texto\"]"));
        clicaBotaoNovo.click();
    }
    public void listaEmpresas(){
        WebElement botaoListaEmpresa = this.navegador.findElement(By.id("botoescadastro_listar_texto"));
        botaoListaEmpresa.click();
    }
    public void cadastraEmpresa(){
        Actions acaoMouse = new Actions(navegador);
        WebElement botaoSalvarEmpresa = this.navegador.findElement(By.className("btn_salvar"));
        acaoMouse.moveToElement(botaoSalvarEmpresa).perform();
        WebElement clicaLinkBotaoSalvarEmpresa = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/table/tbody/tr/td/div/table/tbody/tr/td[2]/a"));
        clicaLinkBotaoSalvarEmpresa.click();
        WebElement popupEmpresaCadastrada = this.navegador.findElement(By.xpath("//*[@id=\"popup_container\"]"));
        WebElement textoPopupEmpresaCadastrada = this.navegador.findElement(By.xpath("//*[@id=\"popup_message\"]"));
        String textoPopup = textoPopupEmpresaCadastrada.getText();
        String palavraChaveDaPopup = "código";
        System.out.println(textoPopup);
        boolean mensagemSucessoPopup = true;

        if(textoPopup.toLowerCase().contains(palavraChaveDaPopup.toLowerCase())){
            Assert.assertTrue(mensagemSucessoPopup);
        }else{
            Assert.assertFalse(mensagemSucessoPopup);
        }
    }

}
