package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

import static core.DriverFactory.getDriver;

public class ComprasObjects {

    private WebDriver driver;

    @FindBy(id = "navi-item-link-compras")
    private WebElement menuCompras;

    @FindBy(xpath = "//*[@id=\"ROOT-2521314\"]/vaadin-app-layout/div/div[1]/div/vaadin-text-field")
    private WebElement pesquisarPlaca ;

    @FindBy (xpath = "//*[@id=\"vaadin-checkbox-3\"]")
    private WebElement selecionartodos;

    @FindBy (xpath = "//*[@id=\"ROOT-2521314\"]/vaadin-app-layout/div/div[1]/div/vaadin-button[1]")
    private WebElement exportar;

    public ComprasObjects() throws MalformedURLException {

        this.driver =  getDriver();

        PageFactory.initElements( getDriver(), this);
    }

    public WebElement getMenuCompras() {
        return menuCompras;
    }

    public void setMenuCompras(WebElement menuCompras) {
        this.menuCompras = menuCompras;
    }

    public WebElement getPesquisarPlaca() {
        return pesquisarPlaca;
    }

    public void setPesquisarPlaca(WebElement pesquisarPlaca) {
        this.pesquisarPlaca = pesquisarPlaca;
    }

    public WebElement getSelecionartodos() {
        return selecionartodos;
    }

    public void setSelecionartodos(WebElement selecionartodos) {
        this.selecionartodos = selecionartodos;
    }

    public WebElement getExportar() {
        return exportar;
    }

    public void setExportar(WebElement exportar) {
        this.exportar = exportar;
    }
}
