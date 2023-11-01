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

public class MenuGuiaExameFormPage extends ModuloAtendimentoPage {

    public MenuGuiaExameFormPage(WebDriver navegador) {
        super(navegador);
    }

    public MenuGuiaExameFormPage insereDentistaSolicitante(String cro) throws InterruptedException {
        WebElement achaCampocroSolicitante = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset/label[1]/input"));
        Thread.sleep(1000);
        achaCampocroSolicitante.sendKeys(cro);
        WebElement elementClicaPraDesfocar = this.navegador.findElement(By.cssSelector("#dir > fieldset > form > fieldset > h1"));
        elementClicaPraDesfocar.click();
        Thread.sleep(2000);
        return this;
    }

    public MenuGuiaExameFormPage selecionaClinicaExecutante(String clinicaExecutante) throws InterruptedException {
        WebElement elementoCombo = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset[2]/div[2]/label[1]/div/span/a/span[1]"));
        elementoCombo.click();
        Thread.sleep(3000);
        WebElement elementoSelecionaClinica = this.navegador.findElement(By.xpath(clinicaExecutante));
        elementoSelecionaClinica.click();
        return this;
    }

    public MenuGuiaExameFormPage informaBeneficiario(String codigoCartao) throws InterruptedException {
        WebElement campoCodCartaoBenef = this.navegador.findElement(By.name("associado.codigo"));
        campoCodCartaoBenef.sendKeys(codigoCartao);
        this.navegador.findElement(By.cssSelector("#dir > fieldset > form > fieldset:nth-child(10) > h1")).click();
        Thread.sleep(3000);
        return this;
    }

    public MenuGuiaExameFormPage clicaBtnConfirmaCriacaoGuia() throws InterruptedException {
        Actions acaoMouse = new Actions(navegador);
        WebDriverWait esperaFicarVisivel = new WebDriverWait(navegador, 30);
        esperaFicarVisivel.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fieldset_sa\"]/fieldset/div[5]")));
        WebElement botaoConfirmar = this.navegador.findElement(By.xpath("//*[@id=\"fieldset_sa\"]/fieldset/div[5]"));
        acaoMouse.moveToElement(botaoConfirmar.findElement(By.linkText("Confirmar")))
                .click(botaoConfirmar.findElement(By.linkText("Confirmar")))
                .release()
                .build()
                .perform();
        Thread.sleep(2000);
        return this;
    }

    public MenuGuiaExameFormPage confirmaPerfilPeriodontal() throws InterruptedException {
        try {
            this.navegador.switchTo().frame(0);
            WebElement framePerfilPeriodontal = this.navegador.findElement(By.xpath("/html/body/form/fieldset"));
            framePerfilPeriodontal.findElement(By.xpath("/html/body/form/fieldset/a")).click();
            this.navegador.switchTo().parentFrame();
            Thread.sleep(2000);
        }catch (TimeoutException timeOut){
            System.out.println("Erro de time out no método: confirmaPerfilPeriodontal()");
            timeOut.getMessage();
            timeOut.getStackTrace();
        }
        return this;
    }

    public MenuGuiaExameFormPage insereAtoAplicacaoArcadaNaGuia(String codigoAto) throws InterruptedException {
        Actions acaoMouse = new Actions(navegador);
        acaoMouse.moveToElement(this.navegador.findElement(By.tagName("INPUT")));
        WebElement campoCodigoAto = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset[4]/div[2]/label[1]/input"));
        campoCodigoAto.sendKeys(codigoAto);
        WebElement clicaParaDesfocar = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset[4]/h1"));
        clicaParaDesfocar.click();
        WebElement selecionaArcada = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset[4]/div[4]/label[1]/table/tbody/tr[1]/td/a/img"));
        selecionaArcada.click();
        Thread.sleep(3000);
        return this;
    }

    public MenuGuiaExameFormPage clicaAdicionarAtoNaGuia() throws InterruptedException {
        try {
            WebElement btnAdicionarAto = this.navegador.findElement(By.cssSelector("#btnIncluir > a"));
            btnAdicionarAto.click();
            Thread.sleep(2000);
        } catch (TimeoutException timeOut){
            System.out.println("Erro de time out no método: clicaAdicionarAtoNaGuia()");
            timeOut.getMessage();
            timeOut.getStackTrace();
        }
        return this;
    }

    public MenuGuiaExameFormPage clicaBotaoValidarAtos(){
        try {
            WebElement btnValidarAtosDaGuia = this.navegador.findElement(By.id("btn_validar_atos"));
            btnValidarAtosDaGuia.click();
        }catch (TimeoutException timeoutException){
            System.out.println("Erro de time out no método: clicaBotaoValidarAtos()");
            timeoutException.getMessage();
            timeoutException.getStackTrace();
        }
        return this;
    }

    public String validaStatusGuia(){
        WebElement elementoMensagemStatusGuia = this.navegador.findElement(By.xpath("//*[@id=\"popup_message\"]"));
        String mensagemPopupStatusGuia = elementoMensagemStatusGuia.getText();
        try {
            Assert.assertEquals("Guia validada!", mensagemPopupStatusGuia);
        }catch (AssertionError erroNoAssert){
            System.out.println("mensagem de status da guia NÃO caiu como VALIDADA: ");
            System.out.println(mensagemPopupStatusGuia);
        }
        return mensagemPopupStatusGuia;

    }
}
