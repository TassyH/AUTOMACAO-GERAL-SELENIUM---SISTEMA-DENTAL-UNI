package testes.dentalTestes.PageObject.Page.ModuloPage.ModuloContratoPage.MenuContratoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.opentest4j.AssertionFailedError;

public class CadastroBeneficiarioFormPage extends CriaContratoFormPage{
    protected String numCartao;
    public CadastroBeneficiarioFormPage(WebDriver navegador) {
        super(navegador);
    }
    public CadastroBeneficiarioFormPage insereCPFBeneficiario(String cpfBenef) throws InterruptedException {
        WebElement campoCpf = this.navegador.findElement(By.name("usuario.cpf"));
        campoCpf.sendKeys(cpfBenef);
        WebElement clicaPraDesfocar = this.navegador.findElement(By.xpath("//*[@id=\"ABAS02\"]/div/div[1]/fieldset/label[1]"));
        clicaPraDesfocar.click();
        Thread.sleep(4000);
        return this;
    }
    public CadastroBeneficiarioFormPage validaDadosCarregadosDaReceita() throws InterruptedException {
        WebElement campoNomeBenef = this.navegador.findElement(By.name("usuario.nomeCompleto"));
        boolean nome = campoNomeBenef.getText() != null;
        return this;
    }
    public CadastroBeneficiarioFormPage selecionaEstadoCivil(String estadoCivil) throws InterruptedException {
        Thread.sleep(2000);
        Actions acaoMouse = new Actions(this.navegador);
        acaoMouse.moveToElement(this.navegador.findElement(By.name("usuario_codigoEstadoCivil_autocomplete"))).build().perform();
        WebElement clicaSpanEstadoCivil = this.navegador.findElement(By.name("usuario_codigoEstadoCivil_autocomplete"));
        clicaSpanEstadoCivil.click();
        clicaSpanEstadoCivil.sendKeys(estadoCivil);
        WebElement estadoCivilSelec = this.navegador.findElement(By.linkText(estadoCivil));
        estadoCivilSelec.click();
        return this;
    }
    public CadastroBeneficiarioFormPage selecionaFormaDePagamentoComDadosDaReceita(String formaPagamento) throws InterruptedException {
        Thread.sleep(2000);
        WebElement clicaSpanFormaDePagamento = this.navegador.findElement(By.xpath("//*[@id=\"ABAS02\"]/div/div[1]/fieldset/label[50]/span/a/span[1]"));
        clicaSpanFormaDePagamento.click();
        WebElement selecionaPagamento = this.navegador.findElement(By.linkText(formaPagamento));
        selecionaPagamento.click();
        return this;
    }
    public CadastroBeneficiarioFormPage selecionaFormaDePagamentoSemDadosDaReceita(String formaPagamento){
        Actions mouse = new Actions(this.navegador);
        // mouse.moveToElement(this.navegador.findElement(By.name("associado.formaPagamento"))).build().perform();
        WebElement clicaSpanFormaDePagamento = this.navegador.findElement(By.xpath("//*[@id=\"ABAS02\"]/div/div[1]/fieldset/label[48]/span/a/span[1]"));
        clicaSpanFormaDePagamento.click();
        WebElement selecionaPagamento = this.navegador.findElement(By.linkText(formaPagamento));
        selecionaPagamento.click();
        return this;
    }
    public CadastroBeneficiarioFormPage selecionaPlanoBeneficiarioDaReceita(String nomePlano){
        Actions actions = new Actions(this.navegador);
        actions.moveToElement(this.navegador.findElement(By.xpath("/html/body/div[5]/fieldset/table/tbody/tr/td/fieldset/fieldset/form/div[7]/div/div[1]/fieldset/label[56]/span/a/span[1]"))).build().perform();
        WebElement spanPlano = this.navegador.findElement(By.xpath("/html/body/div[5]/fieldset/table/tbody/tr/td/fieldset/fieldset/form/div[7]/div/div[1]/fieldset/label[56]/span/a/span[1]"));
        spanPlano.click();
        WebElement selecionaPlano = this.navegador.findElement(By.xpath(nomePlano));
        selecionaPlano.click();
        return this;
    }
    public CadastroBeneficiarioFormPage selecionaPlanoBeneficiarioSemDadosDaReceita(String nomePlano){
        WebElement spanPlano = this.navegador.findElement(By.xpath("//*[@id=\"ABAS02\"]/div/div[1]/fieldset/label[54]/span/a/span[1]"));
        spanPlano.click();
        WebElement selecionaPlano = this.navegador.findElement(By.linkText(nomePlano));
        selecionaPlano.click();
        return this;
    }
    public CadastroBeneficiarioFormPage selecionaVendedorBeneficiarioDaReceita(){
        WebElement clicaSpanVendedor = this.navegador.findElement(By.xpath("//*[@id=\"ABAS02\"]/div/div[1]/fieldset/label[59]/span/a/span[1]"));
        clicaSpanVendedor.click();
        WebElement selecionaVendedor = this.navegador.findElement(By.xpath("//*[@id=\"ui-id-21\"]/li[2]"));
        selecionaVendedor.click();
        return this;
    }
    public CadastroBeneficiarioFormPage selecionaVendedorBeneficiarioSemDadosDaReceita() {
        WebElement clicaSpanVendedor = this.navegador.findElement(By.xpath("/html/body/div[5]/fieldset/table/tbody/tr/td/fieldset/fieldset/form/div[7]/div/div[1]/fieldset/label[57]/span/a/span[1]"));
        clicaSpanVendedor.click();
        WebElement selecionaVendedor = this.navegador.findElement(By.xpath("//ul[@id='ui-id-20']/li[2]/a"));
        selecionaVendedor.click();
        return this;
    }
    public CadastroBeneficiarioFormPage clicaAbaEnderecoBeneficiario(){
        Actions acaoMouse = new Actions(this.navegador);
        acaoMouse.moveToElement(this.navegador.findElement(By.xpath("//li[contains(.,'Dados Residenciais')]")))
                .build()
                .perform();
        WebElement abaEndereco = this.navegador.findElement(By.xpath("//li[contains(.,'Dados Residenciais')]"));
        abaEndereco.click();
        return this;
    }
    public CadastroBeneficiarioFormPage insereEnderecoBeneficiario(String cepBenef, String numEndereco) throws InterruptedException {
        WebElement campoCEP = this.navegador.findElement(By.name("associado.endereco.cep"));
        campoCEP.sendKeys(cepBenef);
        WebElement campoNumero = this.navegador.findElement(By.name("associado.endereco.numero"));
        campoNumero.sendKeys(numEndereco);
        Thread.sleep(3000);
        return this;
    }
    public CadastroBeneficiarioFormPage clicaAbaDadosBasicosBeneficiario(){
        WebElement abaDadosBasicos = this.navegador.findElement(By.xpath("//*[@id=\"ABAS02\"]/ul/li[1]"));
        abaDadosBasicos.click();
        return this;
    }
    public CadastroBeneficiarioFormPage insereNomeBeneficiario(String nomeBenef){
        WebElement campoNomeBenef = this.navegador.findElement(By.name("usuario.nomeCompleto"));
        campoNomeBenef.sendKeys(nomeBenef);
        return this;
    }
    public CadastroBeneficiarioFormPage clicaSalvaCadastroBeneficiario(){
        Actions acaomouse = new Actions(this.navegador);
        acaomouse.moveToElement(this.navegador.findElement(By.xpath("//*[@id=\"dir\"]/fieldset/form/table[1]/tbody/tr/td/div/table/tbody/tr"))).perform();
        WebElement botaoSalvar = this.navegador.findElement(By.xpath("(//a[contains(@href, 'javascript:salvar();')])[2]"));
        botaoSalvar.click();
        return this;
    }
    public CadastroBeneficiarioFormPage insereCNS(String cns){
        WebElement campoCNS = this.navegador.findElement(By.name("usuario.cartaoSus"));
        campoCNS.sendKeys(cns);
        return this;
    }
    public CadastroBeneficiarioFormPage validaBeneficiarioCadastradoComSucesso(){
        try{
            WebElement popupBenefCadastrado = this.navegador.findElement(By.id("popup_container"));
            String mensagemPopup = popupBenefCadastrado.getText();
            mensagemPopup.contains("Salvo/Atualizado com sucesso");
            WebElement textoPopUp = this.navegador.findElement(By.xpath("//*[@id=\"popup_content\"]"));
            this.numCartao = textoPopUp.getText().replaceAll("\\D", "");
            System.out.println(this.numCartao);
            WebElement fechaPopupBotao = this.navegador.findElement(By.xpath("/html/body/div[8]/div/div[2]/input"));
            fechaPopupBotao.click();
        }catch (AssertionFailedError erroValidacao){
            erroValidacao.fillInStackTrace();
            System.out.println("Erro no cadastro do beneficiário!");
        }
        return this;
    }
    public CadastroBeneficiarioFormPage insereNomedaMae(String nomeMae){
        WebElement campoNomeMae = this.navegador.findElement(By.name("usuario.mae"));
        campoNomeMae.sendKeys(nomeMae);
        return this;
    }
    public CadastroBeneficiarioFormPage insereDataNascimento(String dataNascimento){
        WebElement campoDataNasc = this.navegador.findElement(By.name("usuario.dataNascimentoString"));
        campoDataNasc.sendKeys(dataNascimento);
        return this;
    }
    public CadastroBeneficiarioFormPage selecionaSexo(String sexo){
        WebElement spanSexo = this.navegador.findElement(By.xpath("//div[@id='ABAS02']/div/div/fieldset/label[8]/span/a/span"));
        spanSexo.click();
        WebElement selecionaSexo = this.navegador.findElement(By.linkText(sexo));
        selecionaSexo.click();
        return this;
    }
    public CadastroBeneficiarioFormPage fechaAlertaCPFNaoEncontradoNaReceita() throws InterruptedException {
        try{
            WebElement botaoOKAlertaReceita = this.navegador.findElement(By.id("popup_ok"));
            botaoOKAlertaReceita.click();
        }catch (NoSuchElementException noSuchElementException){
            validaDadosCarregadosDaReceita();
        }

        return this;
    }
    public CadastroBeneficiarioFormPage validaCPFExistente() throws InterruptedException {
        try{
            WebElement frameCPFDuplicado = this.navegador.findElement(By.xpath("//label[contains(.,'Esse cpf está duplicado para o(s) beneficiário(s):')]"));
            frameCPFDuplicado.isDisplayed();
            NoSuchElementException erro = null;
            erro.printStackTrace();

        }catch (NoSuchElementException elementException){
            fechaAlertaCPFNaoEncontradoNaReceita();
        }
        return this;
    }

}
