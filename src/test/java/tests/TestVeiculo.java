package tests;

import actions.LoginActions;
import actions.VeiculoActions;
import core.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import core.Connections;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestVeiculo extends BaseTest {

    static VeiculoActions actVeiculo;
    static LoginActions actLogin;

    String placa = "PXB1011";

    @Order(1)
    @Test
    void cadastrarVeiculos() throws Exception {
        actLogin = new LoginActions();

        actVeiculo = new VeiculoActions();

        String placaCadastrada = Connections.sqlScript("SELECT num_placa FROM tab_veiculo_cliente WHERE num_placa = 'PXB1011'");

        if (placaCadastrada != "") {
            Connections.execute("DELETE FROM tab_veiculo_cliente WHERE num_placa = 'PXB1011'");
        }

        actLogin.Login("40842828000101", "cThB3wVQkzyzCuy");

        actVeiculo.cadastrarVeiculo(placa, "1000", "Não", "Sim", "1234", "RAFA", "CIVIC", "VEICULO TESTE");

        Thread.sleep(4000);
        String mensagem = getDriver().findElement(By.xpath("/html/body/vaadin-notification-container/vaadin-notification-card/flow-component-renderer/div/label")).getText();
        assertEquals("Registro incluído com sucesso", mensagem);

        assertEquals(placa, Connections.sqlScript("SELECT num_placa FROM tab_veiculo_cliente WHERE num_placa = 'PXB1011'"));
    }

    @Order(2)
    @Test
    void veiculoCadastrado() throws Exception {
        actLogin = new LoginActions();

        actVeiculo = new VeiculoActions();

        actLogin.Login("40842828000101", "cThB3wVQkzyzCuy");

        String placaCadastrada = Connections.sqlScript("SELECT num_placa FROM tab_veiculo_cliente WHERE num_placa = 'PXB1011'");

        if (placaCadastrada == null) {
            actVeiculo.cadastrarVeiculo(placa, "1000", "Não", "Sim", "1234", "RAFA", "CIVIC", "VEICULO TESTE");
        }

        Thread.sleep(2000);
        actVeiculo.cadastrarVeiculo(placa, "1000", "Não", "Sim", "1234", "RAFA", "CIVIC", "VEICULO TESTE");

        Thread.sleep(2000);
        String mensagem = getDriver().findElement(By.xpath("/html/body/vaadin-notification-container/vaadin-notification-card/flow-component-renderer/div/label")).getText();

        assertEquals("Placa já cadastrada", mensagem);
    }

    @Order(3)
    @Test
    void pesquisarPlaca() throws Exception {
        actLogin = new LoginActions();

        actVeiculo = new VeiculoActions();

        actLogin.Login("40842828000101", "cThB3wVQkzyzCuy");

        actVeiculo.pesquisar(placa);

        Thread.sleep(2000);

        assertEquals(placa,
                getDriver().findElement(By.xpath("//*[@id=\"ROOT-2521314\"]/vaadin-app-layout/div/vaadin-grid/vaadin-grid-cell-content[36]/vaadin-item/div/strong")).getText());

        Thread.sleep(2000);
        assertEquals(placa, Connections.sqlScript("SELECT num_placa FROM tab_veiculo_cliente WHERE num_placa = 'PXB1011'"));

    }

    @Test
    @Order(4)
    void remover() throws InterruptedException, MalformedURLException {
        actLogin = new LoginActions();

        actVeiculo = new VeiculoActions();

        actLogin.Login("40842828000101", "cThB3wVQkzyzCuy");

        actVeiculo.pesquisar(placa);

        Thread.sleep(2000);
        actVeiculo.remover();

        Thread.sleep(2000);
        assertNotEquals(placa, Connections.sqlScript("SELECT num_placa FROM tab_veiculo_cliente WHERE num_placa = 'PXB1011'"));

    }

    @AfterEach
    void fecharJanela() {
        killDriver();

    }

}



