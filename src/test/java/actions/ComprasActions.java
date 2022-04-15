package actions;

import org.openqa.selenium.interactions.Actions;
import pageObjects.ComprasObjects;

import java.net.MalformedURLException;

import static core.DriverFactory.getDriver;

public class ComprasActions {

    static ComprasObjects objCompras;
    public Actions act;

    public ComprasActions () throws MalformedURLException {

        objCompras = new ComprasObjects( );
        act = new Actions( getDriver());

    }

    public void ExportarCompras(String placa) throws InterruptedException {
        objCompras.getMenuCompras().click();

        objCompras.getPesquisarPlaca().sendKeys(placa);

        new Thread().sleep(2000);
        objCompras.getSelecionartodos().click();

        objCompras.getExportar().click();
    }

}
