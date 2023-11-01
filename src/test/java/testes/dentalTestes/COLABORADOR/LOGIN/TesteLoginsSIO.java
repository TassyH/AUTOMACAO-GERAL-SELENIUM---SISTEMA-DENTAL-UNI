package testes.dentalTestes.COLABORADOR.LOGIN;
import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import testes.dentalTestes.SUPORTE.WebNavegador;

public class TesteLoginsSIO {

    private WebDriver navegador;
    private String baseUrl;
    private JavascriptExecutor js;

    @DisplayName("ABRINDO O NAVEGADOR E O SITE DO SIO")
    @Before
    public void testaAbrirNavegadorSiteSIO() throws Exception {
        this.navegador = WebNavegador.abreChrome();
    }

    @Test
    @DisplayName("TESTE DE LOGIN VALIDO DE COLABORADOR")
    public void loginSIOValidadoColaborador() throws InterruptedException {

        this.navegador.switchTo().frame(1);
        WebElement divTelaLogin = this.navegador.findElement(By.xpath("/html/body/form/div/div/div[1]"));
        divTelaLogin.findElement(By.xpath("/html/body/form/div/div/div[1]")).submit();
        WebElement popupLoginMensagem = this.navegador.findElement(By.id("popup_container"));
        popupLoginMensagem.findElement(By.id("popup_ok")).click();

        WebElement comboTipoUsuario = this.navegador.findElement(By.name("usuario.tipoPerfil"));
        new Select(comboTipoUsuario).selectByVisibleText("COLABORADOR");
        WebElement divLoginColaborador = this.navegador.findElement(By.xpath("/html/body/form/div/div/div[2]"));
        divLoginColaborador.findElement(By.name("usuario.login")).click();
        divLoginColaborador.findElement(By.name("usuario.login")).sendKeys("11901");
        WebElement divSenhaColaborador = this.navegador.findElement(By.xpath("/html/body/form/div/div/div[3]"));
        divSenhaColaborador.findElement(By.name("usuario.senha")).sendKeys("1234");
        divSenhaColaborador.click();
        WebElement btnAcessar = this.navegador.findElement(By.xpath("/html/body/form/div/div/div[4]/a"));
        btnAcessar.findElement(By.xpath("/html/body/form/div/div/div[4]/a")).click();
    }

    @Test
    @DisplayName("TESTE DE LOGIN VALIDO DE COLABORADOR")
    public void loginSIOValidadoEmpresa() throws Exception {

        this.navegador.switchTo().frame(1);
        this.navegador.findElement(By.xpath("/html/body/form/div/div/div[1]")).submit();
        this.navegador.findElement(By.id("popup_container"));
        this.navegador.findElement(By.id("popup_ok")).click();
        this.navegador.findElement(By.name("usuario.tipoPerfil"));
        new Select(this.navegador.findElement(By.name("usuario.tipoPerfil"))).selectByVisibleText("EMPRESA");

        this.navegador.findElement(By.name("usuario.tipoPerfil")).click();
        this.navegador.findElement(By.name("usuario.login")).click();
        this.navegador.findElement(By.name("usuario.login")).sendKeys("444316");
        this.navegador.findElement(By.name("usuario.senha")).click();
        this.navegador.findElement(By.name("usuario.senha")).sendKeys("1234");
        this.navegador.findElement(By.className("btn_acessar"));
        this.navegador.findElement(By.className("btn_acessar")).click();

    }

    @Test
    @DisplayName("TESTE DE LOGIN VALIDO DE DENTISTA")
    public void loginSIOValidadoDentistaCooperado() throws Exception {

        this.navegador.switchTo().frame(1);
        this.navegador.findElement(By.xpath("/html/body/form/div/div/div[1]")).submit();
        this.navegador.findElement(By.id("popup_container"));
        this.navegador.findElement(By.id("popup_ok")).click();
        this.navegador.findElement(By.name("usuario.tipoPerfil"));
        new Select(this.navegador.findElement(By.name("usuario.tipoPerfil"))).selectByVisibleText("CIRURGIÃO DENTISTA");
        this.navegador.findElement(By.name("usuario.tipoPerfil")).click();
        this.navegador.findElement(By.name("usuario.login")).click();
        this.navegador.findElement(By.name("usuario.login")).sendKeys("2014");
        new Select(navegador.findElement(By.name("usuario.estado.codigo"))).selectByVisibleText("PR");
        this.navegador.findElement(By.name("usuario.senha")).sendKeys("123456");
        this.navegador.findElement(By.className("btn_acessar"));
        this.navegador.findElement(By.className("btn_acessar")).click();
    }

    @Test
    @DisplayName("TESTE DE LOGIN VALIDO DE DENTISTA")
    public void loginSIOValidadoDentistaCredenciadoPF() throws Exception {

        this.navegador.switchTo().frame(1);
        this.navegador.findElement(By.xpath("/html/body/form/div/div/div[1]")).submit();
        this.navegador.findElement(By.id("popup_container"));
        this.navegador.findElement(By.id("popup_ok")).click();
        this.navegador.findElement(By.name("usuario.tipoPerfil"));
        new Select(this.navegador.findElement(By.name("usuario.tipoPerfil"))).selectByVisibleText("CIRURGIÃO DENTISTA");
        this.navegador.findElement(By.name("usuario.tipoPerfil")).click();
        this.navegador.findElement(By.name("usuario.login")).click();
        this.navegador.findElement(By.name("usuario.login")).sendKeys("2017");
        new Select(navegador.findElement(By.name("usuario.estado.codigo"))).selectByVisibleText("PR");
        this.navegador.findElement(By.name("usuario.senha")).sendKeys("12345");
        this.navegador.findElement(By.className("btn_acessar"));
        this.navegador.findElement(By.className("btn_acessar")).click();

    }

    @Test
    @DisplayName("TESTE DE LOGIN VALIDO DE DENTISTA")
    public void loginSIOValidadoDentistaCredenciadoPJ() throws Exception {

        this.navegador.switchTo().frame(1);
        this.navegador.findElement(By.xpath("/html/body/form/div/div/div[1]")).submit();
        this.navegador.findElement(By.id("popup_container"));
        this.navegador.findElement(By.id("popup_ok")).click();
        this.navegador.findElement(By.name("usuario.tipoPerfil"));
        new Select(this.navegador.findElement(By.name("usuario.tipoPerfil"))).selectByVisibleText("CIRURGIÃO DENTISTA");
        this.navegador.findElement(By.name("usuario.tipoPerfil")).click();
        this.navegador.findElement(By.name("usuario.login")).click();
        this.navegador.findElement(By.name("usuario.login")).sendKeys("2016");
        new Select(navegador.findElement(By.name("usuario.estado.codigo"))).selectByVisibleText("PR");
        this.navegador.findElement(By.name("usuario.senha")).sendKeys("641924E9");
        this.navegador.findElement(By.className("btn_acessar"));
        this.navegador.findElement(By.className("btn_acessar")).click();

    }
}
