package testes.dentalTestes.SUPORTE;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebNavegador {
    private WebDriver navegador;
    private static String baseUrl;
    private static JavascriptExecutor js;
    public static WebDriver abreChrome(){
        System.setProperty("webdriver.chrome.driver", "C:\\driveChrome\\chromedriver-win64\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        js = (JavascriptExecutor)navegador;
        navegador.manage().window().maximize();
        navegador.get("https://sio-teste.fswise.com.br/UnioTeste/Uniweb.do");
        return navegador;
    }
}
