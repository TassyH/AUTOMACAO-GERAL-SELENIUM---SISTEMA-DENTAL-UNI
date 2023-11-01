package testes.dentalTestes.PageObject;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import testes.dentalTestes.PageObject.Page.LoginPage.LoginFormPage;
import testes.dentalTestes.PageObject.Page.LoginPage.LoginPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.MenuEmpresaPage.CriaEmpresaFormPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.MenuEmpresaPage.MenuEmpresaPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.ModuloContratoPage;
import testes.dentalTestes.PageObject.Page.ModuloPage.ModuloPage;
import testes.dentalTestes.SUPORTE.WebNavegador;

public class CriaEmpresaColaboradorPageObject {
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
    @DisplayName("Teste: cadastrar nova empresa inserindo apenas um CNPJ valido para pegar os dados da receita e data de faturamento")
    @Test
    public void criaEmpresaNovaPelosDadosBasicosDaReceitaComSucesso() throws InterruptedException {
        ModuloPage moduloPage = new ModuloPage(navegador);
        moduloPage.clicaModuloContrato();
        ModuloContratoPage moduloContratoPage = new ModuloContratoPage(navegador);
        moduloContratoPage.acessaMenuEmpresa();
        moduloContratoPage.acessaTelaEmpresa();
        MenuEmpresaPage menuEmpresaPage = new MenuEmpresaPage(navegador);
        menuEmpresaPage.criaNovaEmpresa();
        CriaEmpresaFormPage criaEmpresaFormPage = new CriaEmpresaFormPage(this.navegador);
        criaEmpresaFormPage
                .preencheCPNJ("03.146.414/0001-11")
                .selecionaDiaFaturamento("10");
        criaEmpresaFormPage
                .selecionaperiodoDiaFaturamento();
        menuEmpresaPage.cadastraEmpresa();
    }
    @DisplayName("Teste: cadastrar nova empresa pela função adicionar Contatos da Empresa")
    @Test
    public void criaEmpresaAdicionandoContatosDaEmpresaComSucesso() throws InterruptedException {
        ModuloPage moduloPage = new ModuloPage(navegador);
        moduloPage.clicaModuloContrato();
        ModuloContratoPage moduloContratoPage = new ModuloContratoPage(navegador);
        moduloContratoPage.acessaMenuEmpresa();
        moduloContratoPage.acessaTelaEmpresa();
        MenuEmpresaPage menuEmpresaPage = new MenuEmpresaPage(navegador);
        menuEmpresaPage.criaNovaEmpresa();
        CriaEmpresaFormPage criaEmpresaFormPage = new CriaEmpresaFormPage(this.navegador);
        criaEmpresaFormPage
                .preencheCPNJ("61.412.110/0001-55")
                .selecionaDiaFaturamento("10");
        criaEmpresaFormPage
                .selecionaperiodoDiaFaturamento();
        criaEmpresaFormPage
                .insereNomeContatoEmpresa("CONTATO EMPRESA UM")
                .insereDataNascimentoContatoEmpresa("01011999")
                .insereEmailContatoEmpresa("teste_um@gmail.com")
                .insereCargoContatoEmpresa("cargo teste 1")
                .insereDepartamentoContatoEmpresa("depart teste 1")
                .selecionaClassificacaoContatoEmpresa()
                .clicaAdicionarContatoEmpresaBotao()
                .validaContatoEmpresaInseridoComSucesso()
                .validaMensagemEmpresaCriadaComSecesso();
    }
    @Test
    public void cadastraEmpresaAdicionandoTelefoneComSucesso() throws InterruptedException {
        ModuloPage moduloPage = new ModuloPage(navegador);
        moduloPage.clicaModuloContrato();
        ModuloContratoPage moduloContratoPage = new ModuloContratoPage(navegador);
        moduloContratoPage.acessaMenuEmpresa();
        moduloContratoPage.acessaTelaEmpresa();
        MenuEmpresaPage menuEmpresaPage = new MenuEmpresaPage(navegador);
        menuEmpresaPage.criaNovaEmpresa();
        CriaEmpresaFormPage criaEmpresaFormPage = new CriaEmpresaFormPage(this.navegador);
        criaEmpresaFormPage
                .preencheCPNJ("73.631.392/0001-60")
                .selecionaDiaFaturamento("10");
        criaEmpresaFormPage
                .selecionaperiodoDiaFaturamento()
                .insereDDDTelefoneEmpresa("//a[contains(text(),'41')]")
                .insereNumeroTelefone("9888777570")
                .selecionaRadioTipoTelefone("//*[@id=\"dir\"]/fieldset/form/fieldset/div[5]/div[20]/input[2]")
                .insereObservacaoNumeroTelefone("TESTE 1")
                .clicaBotaoAdicionarTelefoneEmpresa()
                .validaTelefoneAdicionadoComSucesso()
                .validaMensagemEmpresaCriadaComSecesso();
    }
    @Test
    public void cadastrarEmpresaAdicionandoResponsavelComSucesso() throws InterruptedException {
        ModuloPage moduloPage = new ModuloPage(navegador);
        moduloPage.clicaModuloContrato();
        ModuloContratoPage moduloContratoPage = new ModuloContratoPage(navegador);
        moduloContratoPage.acessaMenuEmpresa();
        moduloContratoPage.acessaTelaEmpresa();
        MenuEmpresaPage menuEmpresaPage = new MenuEmpresaPage(navegador);
        menuEmpresaPage.criaNovaEmpresa();
        CriaEmpresaFormPage criaEmpresaFormPage = new CriaEmpresaFormPage(this.navegador);
        criaEmpresaFormPage
                .preencheCPNJ("03.455.069/0001-06")
                .selecionaDiaFaturamento("10");
        criaEmpresaFormPage
                .selecionaperiodoDiaFaturamento()
                .insereNomeResponsavelEmpresa("RESPONSAVEL TESTE 1")
                .insereCargoResponsavelEmpresa("TESTE 1")
                .insereRGresponsavelEmpresa("12345TESTE")
                .insereCPFResponsavelEmpresa("04236317214")
                .insereDataNascimentoResponsavelEmpresa("01021999")
                .clicaBotaoAdicionarResponsavelEmpresa()
                .validaRepresentanteEmpresaInserido()
                .validaMensagemEmpresaCriadaComSecesso();
    }
}
