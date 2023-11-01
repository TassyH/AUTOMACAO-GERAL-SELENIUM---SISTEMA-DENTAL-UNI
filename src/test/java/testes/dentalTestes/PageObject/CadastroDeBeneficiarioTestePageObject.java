package testes.dentalTestes.PageObject;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testes.dentalTestes.PageObject.Page.LoginPage.LoginFormPage;
import testes.dentalTestes.PageObject.Page.LoginPage.LoginPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.MenuContratoPage.CadastroBeneficiarioFormPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.MenuContratoPage.CadastroDependenteFormPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.MenuContratoPage.CriaContratoFormPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.MenuContratoPage.MenuContratoPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.ModuloContratoPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloPage;
import testes.dentalTestes.SUPORTE.WebNavegador;

public class CadastroDeBeneficiarioTestePageObject {
    private WebDriver navegador;

    @Before
    public void abreNevegadorELoga() throws InterruptedException {
        this.navegador = WebNavegador.abreChrome();
        LoginPage loginPage = new LoginPage(this.navegador);
        loginPage.telaClickDivLogin();
        new LoginFormPage(this.navegador)
                .dadoCampoLogin("11901")
                .dadoCampoSenha("1234")
                .tipoLogin("COLABORADOR");
        loginPage.telaLoginClickBtnLogin();

        ModuloPage moduloPage = new ModuloPage(this.navegador);
        moduloPage
                .clicaModuloContrato();
        ModuloContratoPage moduloContratoPage = new ModuloContratoPage(this.navegador);
        moduloContratoPage
                .acessaMenuContrato();
        MenuContratoPage menuContratoPage = new MenuContratoPage(this.navegador);
        menuContratoPage
                .acessaContratoTela();
        menuContratoPage
                .listaContratoTela();
        menuContratoPage
                .consultaContratoExistentePelaTeladeListagem("443691")
                .clicaBotaoConsultar()
                .clicaCodigoContratoRetornadoDaConsulta();
    }

    @Test
    public void cadastraNovoBeneficiarioComDadosDaReceitaComSucesso() throws InterruptedException {
        CriaContratoFormPage criaContratoFormPage = new CriaContratoFormPage(this.navegador);
        criaContratoFormPage
                .acessaAbaBeneficiario();
        CadastroBeneficiarioFormPage cadastroBeneficiarioForm = new CadastroBeneficiarioFormPage(this.navegador);
        cadastroBeneficiarioForm
                .insereCPFBeneficiario("12401885013")
                .validaCPFExistente()
                .selecionaEstadoCivil("SOLTEIRO")
                .insereCNS("32432423423423")
                .selecionaFormaDePagamentoComDadosDaReceita("Boleto")
                .selecionaPlanoBeneficiarioDaReceita("//a[contains(text(),'72 - PARCERIA')]")
                .selecionaVendedorBeneficiarioDaReceita()
                .clicaSalvaCadastroBeneficiario()
                .validaBeneficiarioCadastradoComSucesso();
        //cadastraDependenteComDadosCarregadosDaReceitaFederal();
    }

    @Test
    public void cadastraBeneficiarioNormalComSucesso() throws InterruptedException {
        CriaContratoFormPage criaContratoFormPage = new CriaContratoFormPage(this.navegador);
        criaContratoFormPage
                .acessaAbaBeneficiario();
        CadastroBeneficiarioFormPage cadastroBeneficiarioForm = new CadastroBeneficiarioFormPage(this.navegador);
        cadastroBeneficiarioForm
                .insereCPFBeneficiario("061.367.980-69")
                .fechaAlertaCPFNaoEncontradoNaReceita()
                .insereNomeBeneficiario("titular add via automaçao 2")
                .insereNomedaMae("nome mamais titular")
                .insereDataNascimento("01011999")
                .selecionaEstadoCivil("SOLTEIRO")
                .selecionaSexo("Masculino")
                .insereCNS("32132131231231")
                .selecionaFormaDePagamentoSemDadosDaReceita("Carnê")
                .selecionaPlanoBeneficiarioSemDadosDaReceita("72 - PARCERIA")
                .selecionaVendedorBeneficiarioSemDadosDaReceita()
                .clicaAbaEnderecoBeneficiario()
                .insereEnderecoBeneficiario("83035020","154")
                .clicaAbaDadosBasicosBeneficiario()
                .clicaSalvaCadastroBeneficiario();
        cadastraDependenteComDadosCarregadosDaReceitaFederal();

    }
    @Test
    public void cadastraDependenteComDadosCarregadosDaReceitaFederal() throws InterruptedException {
        CriaContratoFormPage criaContratoFormPage = new CriaContratoFormPage(this.navegador);
        criaContratoFormPage
                .acessaAbaBeneficiario();
        CadastroDependenteFormPage cadastroDependenteFormPage = new CadastroDependenteFormPage(this.navegador);
        cadastroDependenteFormPage
                .clicaLupaCarregaTitutlar()
                .selecionaTitularAtivo("00202544493100000201");


    }
}
