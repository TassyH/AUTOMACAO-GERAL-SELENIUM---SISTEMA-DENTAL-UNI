package testes.dentalTestes.PageObject.Page.ModuloPage.ModuloAtendimentoPage.MenuGuiaPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloAtendimentoPage.ModuloAtendimentoPage;

import java.time.Duration;

public class MenuGuiaNormalFormPage extends ModuloAtendimentoPage {
    public MenuGuiaNormalFormPage(WebDriver navegador) {
        super(navegador);
    }
    public MenuGuiaNormalFormPage insereDentista(String cro) throws InterruptedException {
        WebElement dadosDentistadaGuia = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset[1]"));
        dadosDentistadaGuia.findElement(By.name("cooperado.cro")).sendKeys(cro);
        dadosDentistadaGuia.click();
        Thread.sleep(2000);
        return this;
    }

    public MenuGuiaNormalFormPage insereBeneficiario(String codigoCartao) throws InterruptedException {
        WebElement codCartaoBeneficiariodaGuia = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset[2]"));
        codCartaoBeneficiariodaGuia.findElement(By.name("associado.codigo")).sendKeys(codigoCartao);
        codCartaoBeneficiariodaGuia.click();
        Thread.sleep(2000);
        return this;
    }

    public MenuGuiaNormalFormPage clicaBtnConfirmarCriacaoGuia() throws InterruptedException {
        Actions acaoMouse = new Actions(navegador);
        WebDriverWait esperaFicarVisivel = new WebDriverWait(navegador, 30);
        esperaFicarVisivel.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fieldset_sa\"]/fieldset/div[4]")));
        WebElement botaoConfirmar = this.navegador.findElement(By.xpath("//*[@id=\"fieldset_sa\"]/fieldset/div[4]"));
        acaoMouse.moveToElement(botaoConfirmar.findElement(By.linkText("Confirmar")))
                .click(botaoConfirmar.findElement(By.linkText("Confirmar")))
                .release()
                .build()
                .perform();
        Thread.sleep(2000);
       return this;
    }

    public MenuGuiaNormalFormPage confirmaPerfilPeriodontal(){
        try{
            this.navegador.switchTo().frame(0);
            WebElement framePerfilPeriodontal = this.navegador.findElement(By.xpath("/html/body/form/fieldset"));
            framePerfilPeriodontal.findElement(By.xpath("/html/body/form/fieldset/a")).click();
            this.navegador.switchTo().parentFrame();
        }catch (TimeoutException timeOut){
            System.out.println("Erro de time out no método: confirmaPerfilPeriodontal()");
            timeOut.getMessage();
            timeOut.getStackTrace();
        }

        return this;
    }

    public MenuGuiaNormalFormPage insereAtoAplicacaoSegmento(String codAto) throws InterruptedException {
        WebElement inputCodAtos = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset[3]"));
        inputCodAtos.findElement(By.name("ato.codigo")).sendKeys(codAto);
        inputCodAtos.findElement(By.cssSelector("#dir > fieldset > form > fieldset:nth-child(19) > div:nth-child(25)")).click();
        Thread.sleep(3000);
        return this;
    }

    public MenuGuiaNormalFormPage clicaAdicionarAtoNaGuia() throws InterruptedException {
        WebElement tabelaAtoAplicacao = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset[3]/div[4]/label[1]/table"));
        tabelaAtoAplicacao
                .findElement(By.cssSelector("#dir > fieldset > form > fieldset:nth-child(19) > div:nth-child(27) > label:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(3) > a > img"))
                .click();
        WebElement btnAdicionarAto = this.navegador.findElement(By.xpath("//*[@id=\"btnIncluir\"]/a"));
        btnAdicionarAto.click();
        Thread.sleep(2000);
        return this;
    }

    public MenuGuiaNormalFormPage clicaBotaoValidarAtos(){
        try {
            WebElement btnValidarAtosDaGuia = this.navegador.findElement(By.id("btn_validar_atos"));
            btnValidarAtosDaGuia.click();
        }catch (TimeoutException timeOut){
            System.out.println("Erro de time out no método: clicaBotaoValidarAtos()");
            timeOut.getMessage();
            timeOut.getStackTrace();
        }
        return this;
    }

    public String validaStatusGuia() throws InterruptedException {
//        this.navegador.findElement(By.id("popup_container"));
        Thread.sleep(2000);
        WebElement elementoMensagemStatusGuia = this.navegador.findElement(By.xpath("//*[@id=\"popup_message\"]"));
        String mensagemPopupStatusGuia = elementoMensagemStatusGuia.getText();
        Assert.assertEquals("Guia validada!", mensagemPopupStatusGuia);
        try {
            Assert.assertEquals("Guia validada!", mensagemPopupStatusGuia);
        }catch (AssertionError erroNoAssert){
            System.out.println("mensagem de status da guia NÃO caiu como VALIDADA: ");
            System.out.println(mensagemPopupStatusGuia);
        }
        return mensagemPopupStatusGuia;

    }
}
