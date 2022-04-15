package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class FaturasActions {

    static FaturasActions objFaturas;
    private Actions act;


    public FaturasActions (WebDriver driver){

        objFaturas = new FaturasActions(driver);
        act = new Actions(driver);

    }


    }
