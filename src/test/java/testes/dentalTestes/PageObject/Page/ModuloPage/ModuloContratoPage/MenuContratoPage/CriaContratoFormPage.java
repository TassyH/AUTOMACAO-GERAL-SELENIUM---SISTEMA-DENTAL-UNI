package testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.MenuContratoPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.opentest4j.AssertionFailedError;

import java.util.concurrent.TransferQueue;

public class CriaContratoFormPage extends MenuContratoPage{
    protected String nomeVendedor;

    public CriaContratoFormPage(WebDriver navegador) {
        super(navegador);
    }
    public CriaContratoFormPage selecionaTipoContrato(String tipoContrato){
        WebElement selectTipoContrato = this.navegador.findElement(By.name("contrato.tipoContrato"));
        new Select(selectTipoContrato).selectByVisibleText(tipoContrato);
        return this;
    }
    public CriaContratoFormPage selecionaAbrangenciaContrato(String abrangencia){
        WebElement spanAbrangenciaContrato = this.navegador.findElement(By.xpath("//fieldset[@id='dir']/fieldset/form/fieldset/label[3]/span/a/span"));
        spanAbrangenciaContrato.click();
        WebElement selecionaAbrangencia= this.navegador.findElement(By.xpath(abrangencia));
        selecionaAbrangencia.click();
        return this;
    }
    public CriaContratoFormPage insereDataInicioVigencia(String iniVigencia){
        WebElement campoDataVigencia = this.navegador.findElement(By.name("contrato.dataEntradaString"));
        campoDataVigencia.sendKeys(iniVigencia);
        return this;
    }
    public CriaContratoFormPage insereDataPrimeiraMensalidade(String dataMensalidade){
        WebElement campoDataMensal = this.navegador.findElement(By.name("contrato.dataPrimeiraMensalidadeString"));
        campoDataMensal.sendKeys(dataMensalidade);
        return this;
    }
    public CriaContratoFormPage selecionaDiaVencimento(String diaVencimento){
        WebElement spanDiaVencimento = this.navegador.findElement(By.xpath("//fieldset[@id='dir']/fieldset/form/fieldset/label[6]/span/a/span"));
        spanDiaVencimento.click();
        WebElement selecionaDiaVencimento = this.navegador.findElement(By.linkText(diaVencimento));
        selecionaDiaVencimento.click();
        return this;
    }
    public CriaContratoFormPage insereCodigoEmpresa(String codEmpresa) throws InterruptedException {
        WebElement campoCodEmpresa = this.navegador.findElement(By.name("contrato.empresa.codigo"));
        campoCodEmpresa.sendKeys(codEmpresa);
        WebElement clicaPraDesfocar = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset/h1[2]"));
        clicaPraDesfocar.click();
        Thread.sleep(2000);
        return this;
    }
    public CriaContratoFormPage validaEmpresaInseridaComSucesso(){
        boolean campoNotNull = true;
        WebElement campoRazaoSocialEmpresa = this.navegador.findElement(By.name("contrato.empresa.razaoSocial"));
        System.out.println(campoRazaoSocialEmpresa.getText());
        if(campoRazaoSocialEmpresa.isEnabled() == true){
            System.out.println("Codigo da empresa nao encontrato");
            Assert.fail();
        }else{
            clicaSalvaCadastroContratoNovo();
        }

        return this;
    }
    public CriaContratoFormPage clicaSalvaCadastroContratoNovo(){
        WebElement botaoSalvarContrato = this.navegador.findElement(By.name("botoescadastro_salvar_texto"));
        botaoSalvarContrato.click();
        return this;
    }
    public CriaContratoFormPage pegaCodigoContratoCriado(){
        WebElement labelCodigoContrato = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset[2]/div[2]"));
        String codContrato = labelCodigoContrato.getText().substring(7);
        System.out.println(codContrato);
        return this;
    }
    public CriaContratoFormPage validaContratoCriadoComSucesso(){
        WebElement popupContratoCadastrado = this.navegador.findElement(By.xpath("//div[@id='popup_content']"));
        try{
            popupContratoCadastrado.getText().contains("Dados salvos com sucesso");
        }catch (AssertionError erroTextoPopup) {
            System.out.println("Contrato nao foi criado com sucesso");
            erroTextoPopup.printStackTrace();
        }
        WebElement botaoOkPopup = this.navegador.findElement(By.xpath("//*[@id=\"popup_ok\"]"));
        botaoOkPopup.click();
        return this;
    }
    public CriaContratoFormPage acessaAbaPlanoContrato(){
        WebElement botaoAbaPlanos = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset[1]/a[2]"));
        botaoAbaPlanos.click();
        return this;
    }
    public CriaContratoFormPage validaSeJaTemPlano() throws InterruptedException {
        try{
            WebElement tabelaDePlanosContrato = this.navegador.findElement(By.xpath("/html/body/div[5]/fieldset/table/tbody/tr/td/fieldset/fieldset/form/table"));
            if(tabelaDePlanosContrato.isDisplayed()){
                acessaAbaVendedorContrato();
            }else{
                clicaLupaCarregaPlano();
            }
        }catch (NoSuchElementException noSuchElementException){
            clicaLupaCarregaPlano();
        }

    return this;
    }
    public CriaContratoFormPage pesquisaNomePlano(String nomePlano){
        WebElement campoNomePlano = this.navegador.findElement(By.name("plano.planoPadrao.nome"));
        campoNomePlano.sendKeys(nomePlano);
        return this;
    }
    public CriaContratoFormPage clicaLupaCarregaPlano() throws InterruptedException {
        Thread.sleep(2000);
        WebElement lupaPesquisaPlano = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset[2]/label[2]/a"));
        lupaPesquisaPlano.click();
        this.navegador.switchTo().frame(0);
        Thread.sleep(2000);
        WebElement selecionaPlanoTabela = this.navegador.findElement(By.xpath("/html/body/fieldset/table/tbody/tr[2]/td[2]/a"));
        selecionaPlanoTabela.click();
        this.navegador.switchTo().parentFrame();
        try{
            WebElement subAbaPlanoCarregado = this.navegador.findElement(By.xpath("/html/body/div[5]/fieldset/table/tbody/tr/td/fieldset/fieldset/form/fieldset[2]/a[1]"));
            subAbaPlanoCarregado.isDisplayed();
            confirmaInserirPlano();
        }catch (AssertionFailedError error){
            error.fillInStackTrace();
            System.out.println("erro ao carregar plano");
        }
        return this;
    }
    public CriaContratoFormPage confirmaInserirPlano() throws InterruptedException {
        WebElement btnIncluirPlano = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/div[9]/a"));
        btnIncluirPlano.click();
        Thread.sleep(2000);
        try{
            WebElement alertCarenciaPlano = this.navegador.findElement(By.xpath("/html/body/div[10]/div/div[2]/input[1]"));
            alertCarenciaPlano.click();
            Thread.sleep(2000);
            WebElement botaoOKalertPlanoInserido = this.navegador.findElement(By.id("popup_ok"));
            botaoOKalertPlanoInserido.click();
        }catch (NoSuchElementException elementException) {
            WebElement alertPlanoInserido = this.navegador.findElement(By.xpath("//*[@id=\"popup_container\"]"));
            alertPlanoInserido.isDisplayed();
            WebElement botaoOKalertPlanoInserido = this.navegador.findElement(By.id("popup_ok"));
            botaoOKalertPlanoInserido.click();
        }

        return this;
    }
    public CriaContratoFormPage acessaAbaVendedorContrato(){
        WebElement clicaAbaVendedor = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset[1]/a[3]"));
        clicaAbaVendedor.click();
        return this;
    }
    public CriaContratoFormPage validaExistenciaDeVendendor() throws InterruptedException {
        try{
            WebElement tabelaVendedorCadastrado = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset[2]/table"));
            if(tabelaVendedorCadastrado.isDisplayed()){
                acessaAbaBeneficiario();
            }else{
                insereNomeVendedor(this.nomeVendedor);
                clicaLupaCarregaVendedor();
                clicaBotaoSalvaVendedor();
            }
        }catch (NoSuchElementException | InterruptedException noSuchElementException){
            clicaLupaCarregaVendedor();
            clicaBotaoSalvaVendedor();
        }
        return this;
    }
    public CriaContratoFormPage insereNomeVendedor(String nomeVendedor){
        WebElement campoNomeVendedor = this.navegador.findElement(By.name("vendedor.vendedor.nome"));
        campoNomeVendedor.sendKeys(nomeVendedor);
        return this;
    }
    public CriaContratoFormPage clicaLupaCarregaVendedor() throws InterruptedException {
        WebElement lupaCarregaVendedor = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset[2]/label[3]/a"));
        lupaCarregaVendedor.click();
        Thread.sleep(2000);
        this.navegador.switchTo().frame(0);
        WebElement selecionaVendedorRetornado = this.navegador.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/a"));
        selecionaVendedorRetornado.click();
        Thread.sleep(2000);
        this.navegador.switchTo().parentFrame();
        return this;
    }
    public CriaContratoFormPage clicaBotaoSalvaVendedor() throws InterruptedException {
        Thread.sleep(2000);
        WebElement botaoSalvaVendedor = this.navegador.findElement(By.xpath("/html/body/div[5]/fieldset/table/tbody/tr/td/fieldset/fieldset/form/fieldset[2]/div[4]/a"));
        botaoSalvaVendedor.click();
        validaVendedorInseridoComSucesso();
        return this;
    }
    public CriaContratoFormPage validaVendedorInseridoComSucesso() throws InterruptedException {
        Thread.sleep(2000);
        try{
            WebElement popupVendedorInserido = this.navegador.findElement(By.xpath("/html/body/div[8]/div/div[2]/input"));
            popupVendedorInserido.click();
            WebElement tabelaVendedorInserido = this.navegador.findElement(By.xpath("/html/body/div[5]/fieldset/table/tbody/tr/td/fieldset/fieldset/form/fieldset[2]/table"));
            if(tabelaVendedorInserido.isDisplayed()){
                acessaAbaBeneficiario();
            }else{
                System.out.println("Vendedor nao inserido no contrato!");
            }
        }catch (AssertionFailedError erro){
            erro.fillInStackTrace();
            System.out.println("erro no método de validar inserção de vendedor");

        }
        return this;
    }
    public CriaContratoFormPage acessaAbaBeneficiario() throws InterruptedException {
        Thread.sleep(2000);
        WebElement clicaAbaBeneficiario = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset[1]/a[4]"));
        clicaAbaBeneficiario.click();
        return this;
    }

}
