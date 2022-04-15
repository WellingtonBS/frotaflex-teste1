package pageObjects;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class LoginObjects {

    private WebDriver driver;

    @FindBy(id="user-field")
    private WebElement user;

    @FindBy(id="pass-field")
    private WebElement senha;

    @FindBy(id="confirm-btn")
    private WebElement butConfirm;

    @FindBy(id="register-btn")
    private WebElement butCadastrar;

    public LoginObjects() throws MalformedURLException {
        this.driver = getDriver();
        PageFactory.initElements(getDriver(), this);

    }

    public WebElement getUser() {
        return user;
    }

    public void setUser(WebElement user) {
        this.user = user;
    }

    public WebElement getSenha() {
        return senha;
    }

    public void setSenha(WebElement senha) {
        this.senha = senha;
    }

    public WebElement getButConfirm() {
        return butConfirm;
    }

    public void setButConfirm(WebElement butConfirm) {
        this.butConfirm = butConfirm;
    }

    public WebElement getButCadastrar() {
        return butCadastrar;
    }

}
