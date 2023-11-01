package testes.dentalTestes.PageObject;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import testes.dentalTestes.PageObject.Page.LoginPage.LoginFormPage;
import testes.dentalTestes.PageObject.Page.LoginPage.LoginPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloAtendimentoPage.MenuElegibilidadePage.MenuElegibilidadePage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloAtendimentoPage.ModuloAtendimentoPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloPage;
import testes.dentalTestes.SUPORTE.WebNavegador;

import java.awt.*;

public class ValidaElegibilidadeTestePageObject {

    private WebDriver navegador;

    @Before
    public void abreNevegadorELoga() throws InterruptedException {
        this.navegador = WebNavegador.abreChrome();
        LoginPage loginPage = new LoginPage(navegador);
        loginPage.telaClickDivLogin();
        new LoginFormPage(navegador)
                .dadoCampoLogin("11901")
                .dadoCampoSenha("1234")
                .tipoLogin("COLABORADOR");
        loginPage.telaLoginClickBtnLogin();
    }
    @Test
    public void validaElegibilidadeComCartao() {
        ModuloPage moduloPage = new ModuloPage(this.navegador);
        moduloPage
                .selecionaMenuAtendimento();
        ModuloAtendimentoPage moduloAtendimentoPage = new ModuloAtendimentoPage(this.navegador);
        moduloAtendimentoPage
                .acessaMenuElegibilidade();
        MenuElegibilidadePage menuElegibilidadePage = new MenuElegibilidadePage(this.navegador);
        menuElegibilidadePage
                .insereCodigoCartaoBeneficiario("00202544431600000101")
                .fechaPopupAlertaBeneficiario();
    }
    @Test
    public void validaElegibilidadePorCPF(){
        ModuloPage moduloPage = new ModuloPage(this.navegador);
        moduloPage
                .selecionaMenuAtendimento();
        ModuloAtendimentoPage moduloAtendimentoPage = new ModuloAtendimentoPage(this.navegador);
        moduloAtendimentoPage
                .acessaMenuElegibilidade();
        MenuElegibilidadePage menuElegibilidadePage = new MenuElegibilidadePage(this.navegador);
        menuElegibilidadePage
                .insereCPFBeneficiario("34363965088")
                .fechaPopupAlertaBeneficiario();
    }
}
