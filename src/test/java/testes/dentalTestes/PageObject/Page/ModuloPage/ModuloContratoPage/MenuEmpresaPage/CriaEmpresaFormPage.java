package testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.MenuEmpresaPage;

import com.sun.xml.internal.ws.policy.AssertionValidationProcessor;
import com.sun.xml.internal.ws.policy.sourcemodel.AssertionData;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CriaEmpresaFormPage extends MenuEmpresaPage {
    protected  String codigoEmpresa;
    public CriaEmpresaFormPage(WebDriver navegador) {
        super(navegador);
    }
    public CriaEmpresaFormPage preencheCPNJ(String cnpj) throws InterruptedException {
        WebElement campoCNPJ = this.navegador.findElement(By.name("empresa.cnpj"));
        campoCNPJ.sendKeys(cnpj);
        WebElement clicaPraDesfocar = this.navegador.findElement(By.id("NDA"));
        clicaPraDesfocar.click();
//
//        try{
//            Assert.assertNotNull(campoCNPJ);
//        }catch (AssertionError erroBuscaCNPJ){
//            erroBuscaCNPJ.fillInStackTrace();
//            erroBuscaCNPJ.printStackTrace();
//            System.out.println("CNPJ INVALIDO");
//        }
        Thread.sleep(3000);
        return this;
    }
    public String selecionaDiaFaturamento(String diaFaturamento) throws InterruptedException {
        Thread.sleep(3000);
        WebElement elementodiaFaturamento = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset/div[5]/div[8]/label[2]/span/input"));
        elementodiaFaturamento.click();
        elementodiaFaturamento.sendKeys(diaFaturamento);
        WebElement desfocaMouseClique = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset/div[5]/div[8]/h1"));
        desfocaMouseClique.click();
        Thread.sleep(3000);
        return diaFaturamento;
    }
    public CriaEmpresaFormPage selecionaperiodoDiaFaturamento (){
        WebElement campoDiaFaturamento = this.navegador.findElement(By.xpath("//fieldset[@id='dir']/fieldset/form/fieldset/div[5]/div[8]/div[3]/span/a/span"));
        campoDiaFaturamento.click();
        WebElement selecionaCombo = this.navegador.findElement(By.xpath("//a[@id='ui-id-13']"));
        selecionaCombo.click();
        WebElement desfocaMouse = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset/div[5]/div[8]/h1"));
        desfocaMouse.click();
        return this;
    }
    public CriaEmpresaFormPage insereNomeContatoEmpresa(String nomeContato){
        WebElement campoNomeContato = this.navegador.findElement(By.name("contato.nomeContato"));
        campoNomeContato.sendKeys(nomeContato);
        WebElement checkboxContatoAtual = this.navegador.findElement(By.name("contato.indAtual"));
        checkboxContatoAtual.isSelected();
        return this;
    }
    public CriaEmpresaFormPage insereDataNascimentoContatoEmpresa(String dataNascimento){
        WebElement dataNascimentoContato = this.navegador.findElement(By.name("contato.dtNascimentoString"));
        dataNascimentoContato.sendKeys(dataNascimento);
        return this;
    }
    public CriaEmpresaFormPage insereEmailContatoEmpresa(String emailContato){
        WebElement campoEmailContato = this.navegador.findElement(By.name("contato.email"));
        campoEmailContato.sendKeys(emailContato);
        return this;
    }
    public CriaEmpresaFormPage insereCargoContatoEmpresa(String cargoContato){
        WebElement campoCargoContato = this.navegador.findElement(By.name("contato.cargo"));
        campoCargoContato.sendKeys(cargoContato);
        return this;
    }
    public CriaEmpresaFormPage insereDepartamentoContatoEmpresa(String departamentoContato){
        WebElement campoDepartamentoContato = this.navegador.findElement(By.name("contato.departamento"));
        campoDepartamentoContato.sendKeys(departamentoContato);
        return this;
    }
    public CriaEmpresaFormPage selecionaClassificacaoContatoEmpresa(){
        WebElement clicaComboClassficacao = this.navegador.findElement(By.xpath("//fieldset[@id='dir']/fieldset/form/fieldset/div[5]/div[15]/label[8]/span/a"));
        clicaComboClassficacao.click();
        WebElement selecionaClassificacaoContato = this.navegador.findElement(By.xpath("//ul[10]/li[2]/a"));
        selecionaClassificacaoContato.click();
        return this;
    }
    public CriaEmpresaFormPage clicaAdicionarContatoEmpresaBotao(){
        WebElement botaoAdicionarContato = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset/div[5]/div[15]/label[9]/a"));
        botaoAdicionarContato.click();
        return this;
    }
    public void validaMensagemEmpresaCriadaComSecesso(){
        WebElement popupEmpresaContatoAdicionado = this.navegador.findElement(By.xpath("//*[@id=\"popup_container\"]"));
        WebElement popupEmpresaCriada = this.navegador.findElement(By.xpath("//*[@id=\"popup_message\"]"));
        String texto = popupEmpresaCriada.getText();
        String palavraSucessoDaPopup = "sucesso";
        System.out.println(texto);
        boolean mensagemSucesso = true;

        if(texto.toLowerCase().contains(palavraSucessoDaPopup.toLowerCase())){
            Assert.assertTrue(mensagemSucesso);
        }else{
            Assert.assertFalse(mensagemSucesso);
        }
    }
    public CriaEmpresaFormPage validaContatoEmpresaInseridoComSucesso(){
        WebElement tabelaContatoInserido = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset/div[5]/div[17]/table"));
        tabelaContatoInserido.isDisplayed();
        return this;
    }
    public CriaEmpresaFormPage insereDDDTelefoneEmpresa(String dddTelefone){
        WebElement clicaSpanDDDTelefone = this.navegador.findElement(By.xpath("//fieldset[@id='dir']/fieldset/form/fieldset/div[5]/div[18]/span/a/span"));
        clicaSpanDDDTelefone.click();
        WebElement selecionaDDD = this.navegador.findElement(By.xpath(dddTelefone));
        selecionaDDD.click();
        return this;
    }
    public CriaEmpresaFormPage selecionaRadioTipoTelefone(String tipoTelefone){
        WebElement radioButtonTipoTelefone = this.navegador.findElement(By.xpath(tipoTelefone));
        radioButtonTipoTelefone.click();
        return this;
    }
    public CriaEmpresaFormPage insereObservacaoNumeroTelefone(String obsTelefone){
        WebElement campoObservacaoTelefone = this.navegador.findElement(By.name("telefone.observacao"));
        campoObservacaoTelefone.sendKeys(obsTelefone);
        return this;
    }
    public CriaEmpresaFormPage insereNumeroTelefone(String numeroTelefone){
        WebElement campoNumeroTelefone = this.navegador.findElement(By.name("telefone.numeroTelefone"));
        campoNumeroTelefone.sendKeys(numeroTelefone);
        return this;
    }
    public CriaEmpresaFormPage clicaBotaoAdicionarTelefoneEmpresa(){
        WebElement btnAdicionarTelefone = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset/div[5]/label[27]/a"));
        btnAdicionarTelefone.click();
        return this;
    }
    public CriaEmpresaFormPage validaTelefoneAdicionadoComSucesso(){
        boolean telefoneCadastrado = true;
        WebElement tabelaTelefoneInserido = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset/div[5]/table"));
        if(tabelaTelefoneInserido.isDisplayed()){
            Assert.assertTrue(telefoneCadastrado);
        }else{
            Assert.assertFalse(telefoneCadastrado);
        }
        return this;
    }
    public void pegaCodigoEmpresaCadastrada(){
        WebElement labelCodEmpresa = this.navegador.findElement(By.xpath(""));
        labelCodEmpresa.getText();
    }
    public CriaEmpresaFormPage insereNomeResponsavelEmpresa(String nomeResponsavel){
        WebElement campoNomeResponsavel = this.navegador.findElement(By.name("responsavelEmpresa.nome"));
        campoNomeResponsavel.sendKeys(nomeResponsavel);
        return this;
    }
    public CriaEmpresaFormPage insereCargoResponsavelEmpresa(String cargoResponsaval){
        WebElement campoCargoResponsavel = this.navegador.findElement(By.name("responsavelEmpresa.cargo"));
        campoCargoResponsavel.sendKeys(cargoResponsaval);
        return this;
    }
    public CriaEmpresaFormPage insereDataNascimentoResponsavelEmpresa(String dataNasc){
        WebElement campoDataNascimento = this.navegador.findElement(By.name("responsavelEmpresa.dtNascimentoString"));
        campoDataNascimento.sendKeys(dataNasc);
        return this;
    }
    public CriaEmpresaFormPage insereRGresponsavelEmpresa(String rgRepresentante){
        WebElement campoRgResponsavelEmpresa = this.navegador.findElement(By.name("responsavelEmpresa.rg"));
        campoRgResponsavelEmpresa.sendKeys(rgRepresentante);
        return this;
    }
    public CriaEmpresaFormPage insereCPFResponsavelEmpresa(String cpfResponsavel){
        WebElement campoCpfResponsavelEmpresa = this.navegador.findElement(By.name("responsavelEmpresa.cpf"));
        campoCpfResponsavelEmpresa.sendKeys(cpfResponsavel);
        return this;
    }
    public CriaEmpresaFormPage clicaBotaoAdicionarResponsavelEmpresa() throws InterruptedException {
        WebElement botaoAdicionarResponsavel = this.navegador.findElement(By.xpath("/html/body/div[5]/fieldset/table/tbody/tr/td/fieldset/fieldset/form/fieldset/div[5]/div[22]/label[6]/a"));
        botaoAdicionarResponsavel.click();
        Thread.sleep(2000);
        return this;
    }
    public CriaEmpresaFormPage validaRepresentanteEmpresaInserido(){
        boolean representanteCadastrado = true;
        WebElement tabelaRepresentanteInserido = this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/fieldset/div[5]/div[25]/table"));
        if (tabelaRepresentanteInserido.isDisplayed()){
            Assert.assertTrue(representanteCadastrado);
        }else{
            Assert.assertFalse(representanteCadastrado);
        }
        return this;
    }
}
