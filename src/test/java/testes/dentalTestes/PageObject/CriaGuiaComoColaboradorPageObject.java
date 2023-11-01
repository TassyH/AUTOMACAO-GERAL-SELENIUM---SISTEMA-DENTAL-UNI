package testes.dentalTestes.PageObject;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import testes.dentalTestes.PageObject.Page.LoginPage.LoginFormPage;
import testes.dentalTestes.PageObject.Page.LoginPage.LoginPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloAtendimentoPage.MenuGuiaPage.MenuGuiaExameFormPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloAtendimentoPage.MenuGuiaPage.MenuGuiaNormalFormPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloAtendimentoPage.ModuloAtendimentoPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloPage;
import testes.dentalTestes.SUPORTE.WebNavegador;

public class CriaGuiaComoColaboradorPageObject {
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
    public void criaGuiaNormalComoColaborador() throws InterruptedException {

        ModuloPage moduloPage = new ModuloPage(navegador);
        moduloPage.selecionaMenuAtendimento();

        ModuloAtendimentoPage modAtendimento = new ModuloAtendimentoPage(navegador);
        modAtendimento.acessaMenuGuia();
        modAtendimento.acessaMenuGuiaNormal();
        MenuGuiaNormalFormPage formGuia = new MenuGuiaNormalFormPage(navegador);
        formGuia.insereDentista("142");
        formGuia.insereBeneficiario("00202544431600005901");
        formGuia.clicaBtnConfirmarCriacaoGuia();
        //formGuia.confirmaPerfilPeriodontal();
        formGuia.insereAtoAplicacaoSegmento("2468");
        formGuia.clicaAdicionarAtoNaGuia();
        formGuia.clicaBotaoValidarAtos();
        formGuia.validaStatusGuia();
    }
    @Test
    public void criaGuiaDeExameComoColaborador() throws InterruptedException {
        ModuloPage moduloPage = new ModuloPage(navegador);
        ModuloAtendimentoPage moduloAtendimentoPage = new ModuloAtendimentoPage(navegador);
        MenuGuiaExameFormPage menuGuiaExameFormPage = new MenuGuiaExameFormPage(navegador);

        moduloPage
                .selecionaMenuAtendimento();
        moduloAtendimentoPage
                .acessaMenuGuiaSolicitaExame();
        menuGuiaExameFormPage
                .insereDentistaSolicitante("2015")
                .selecionaClinicaExecutante("//a[contains(text(),'PR - STUDIO SORRISOS - AURELIO CARNEIRO,100-CENTRO - ARAPOTI')]")
                .informaBeneficiario("00202544436500000101")
                .clicaBtnConfirmaCriacaoGuia()
                .insereAtoAplicacaoArcadaNaGuia("20202020")
                .clicaAdicionarAtoNaGuia()
                .clicaBotaoValidarAtos()
                .validaStatusGuia();
    }
}
