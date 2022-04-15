package tests;

import static core.DriverFactory.getDriver;

import actions.LoginActions;
import core.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogin extends BaseTest {

    private static LoginActions actLogin;

    @Test
    void loginSucessoCliente() throws InterruptedException, MalformedURLException {

        actLogin = new LoginActions();

        actLogin.Login("teste", "123");

        new Thread().sleep(8000);

        assertEquals("https://demo.frotaflex.com.br/faturas", getDriver().getCurrentUrl());

    }

    @Test
    public void loginSenhaInvalido() throws InterruptedException, MalformedURLException {
        actLogin = new LoginActions();

        actLogin.Login("Admin", "123235");

        new Thread().sleep(6000);

        String mensagem = getDriver().findElement(By.xpath("/html/body/vaadin-notification-container/vaadin-notification-card/flow-component-renderer/div/label")).getText();

        assertEquals("Usuário e/ou senha inválidos", mensagem);

    }

    @Test
    public void loginUsuarioInvalido() throws InterruptedException, MalformedURLException {
        actLogin = new LoginActions();

        actLogin.Login("suport", "123");

        new Thread().sleep(6000);

        String mensagem = getDriver().findElement(By.xpath("/html/body/vaadin-notification-container/vaadin-notification-card/flow-component-renderer/div/label")).getText();

        assertEquals("Usuário e/ou senha inválidos", mensagem);

    }

    @Test
    public void loginSucessoCRM() throws InterruptedException, MalformedURLException {
        actLogin = new LoginActions();

        actLogin.Login("well", "123Mud@r");

        new Thread().sleep(6000);

        assertEquals("https://demo.frotaflex.com.br/duplicatas", getDriver().getCurrentUrl());

    }



}
