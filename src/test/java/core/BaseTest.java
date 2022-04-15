package core;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;
import static java.util.Collections.replaceAll;
import static org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Conversions.replace;


public class BaseTest {

    public static String nomeClasse;

    @BeforeAll
    static void inicializa2(TestInfo testInfo) throws IOException {

        nomeClasse = String.valueOf(testInfo.getTestClass());

        nomeClasse = nomeClasse.substring(0, nomeClasse.length() - 1).replace("Optional[class tests.", "");
        System.out.println(nomeClasse);


        boolean diretorio = new File("target" + File.separator + "screenshot" + File.separator + nomeClasse + File.separator).mkdir();
        if (diretorio) {
            FileUtils.forceMkdir(new File("target" + File.separator + "screenshot" + File.separator + nomeClasse + File.separator));
        }
        FileUtils.cleanDirectory(new File("target" + File.separator + "screenshot" + File.separator + nomeClasse + File.separator));

    }

    @AfterEach
    void fecharJanela(TestInfo testInfo) throws IOException {

        TakesScreenshot ss = (TakesScreenshot) getDriver();

        File arquivo = ss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + File.separator + nomeClasse + File.separator + testInfo.getDisplayName() + ".jpg"));

        if (Propriedades.FECHAR_BROWSER) {
            killDriver();
        }
    }
}
