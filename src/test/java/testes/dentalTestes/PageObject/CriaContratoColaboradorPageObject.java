package testes.dentalTestes.PageObject;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import testes.dentalTestes.PageObject.Page.LoginPage.LoginFormPage;
import testes.dentalTestes.PageObject.Page.LoginPage.LoginPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.MenuContratoPage.CadastroBeneficiarioFormPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.MenuContratoPage.CriaContratoFormPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.MenuContratoPage.MenuContratoPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.ModuloContratoPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloPage;
import testes.dentalTestes.SUPORTE.WebNavegador;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CriaContratoColaboradorPageObject {
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
    }
    @Test
    public void novoContratoPJComSucessoTeste() throws InterruptedException {
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
                .novoContratoTela();
        CriaContratoFormPage criaContratoFormPage = new CriaContratoFormPage(this.navegador);
        criaContratoFormPage
                .selecionaTipoContrato("Empresarial")
                .selecionaAbrangenciaContrato("//a[contains(text(),'Municipal')]")
                .insereDataInicioVigencia("17052023")
                .insereDataPrimeiraMensalidade("17052023")
                .selecionaDiaVencimento("10")
                .insereCodigoEmpresa("444941")
                .validaEmpresaInseridaComSucesso()
                .validaContratoCriadoComSucesso();
        criaContratoFormPage
                .pegaCodigoContratoCriado();
    }
    @Test
    public void novoContratoPFComSucessoTeste() throws InterruptedException {
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
                .novoContratoTela();
        CriaContratoFormPage criaContratoFormPage = new CriaContratoFormPage(this.navegador);
        criaContratoFormPage
                .selecionaTipoContrato("Pessoa Física")
                .selecionaAbrangenciaContrato("//a[contains(text(),'Municipal')]")
                .insereDataInicioVigencia("01062023")
                .insereDataPrimeiraMensalidade("01062023")
                .selecionaDiaVencimento("10")
                .clicaSalvaCadastroContratoNovo()
                .validaContratoCriadoComSucesso();
        criaContratoFormPage
                .pegaCodigoContratoCriado();

    }
    @Test
    public void consultaContratoNovoTeste() throws InterruptedException {
        ModuloPage moduloPage = new ModuloPage(this.navegador);
        CriaContratoFormPage criaContratoFormPage = new CriaContratoFormPage(this.navegador);
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
                .consultaContratoExistentePelaTeladeListagem("443690")
                .clicaBotaoConsultar()
                .clicaCodigoContratoRetornadoDaConsulta();
        criaContratoFormPage
                .acessaAbaPlanoContrato()
                .validaSeJaTemPlano()
                .acessaAbaVendedorContrato()
                .validaExistenciaDeVendendor();
    }

}
