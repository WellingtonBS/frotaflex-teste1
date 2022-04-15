package tests;

import actions.ComprasActions;
import actions.LoginActions;
import core.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static core.DriverFactory.killDriver;

public class TestCompras extends BaseTest {

    static ComprasActions actCompras;
    static LoginActions actLogin;

    @Test
    public void exportarCompras() throws Exception {

        actLogin = new LoginActions();

        actCompras = new ComprasActions();

        actLogin.Login("40842828000101", "cThB3wVQkzyzCuy");

        new Thread().sleep(2000);
        actCompras.ExportarCompras("RMP-0E80");

    }

    @AfterEach
    void fecharJanela() {
        killDriver();

    }
}
