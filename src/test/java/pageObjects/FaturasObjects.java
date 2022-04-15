package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaturasObjects {

    private WebDriver driver;

    @FindBy(id = "navi-item-link-faturas")
    private WebElement menuFaturas;

    @FindBy(xpath = "//*[@id=\"ROOT-2521314\"]/vaadin-app-layout/div/div[2]/div[2]/div[1]/div[1]")
    private WebElement card;

    @FindBy(xpath = "//*[@id=\"ROOT-2521314\"]/vaadin-app-layout/div/div[2]/div[2]/div[1]/div[2]/vaadin-button[1]//div" )
    private WebElement danfe;

    @FindBy(xpath = "//*[@id=\"ROOT-2521314\"]/vaadin-app-layout/div/div[2]/div[2]/div[1]/div[2]/vaadin-button[2]//div")
    private WebElement xml;

    @FindBy(xpath = "//*[@id=\"ROOT-2521314\"]/vaadin-app-layout/div/div[2]/div[2]/div[1]/div[2]/vaadin-button[3]//div")
    private WebElement pagar;

    public FaturasObjects(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements( driver , this);
    }

    public WebElement getMenuFaturas() {
        return menuFaturas;
    }

    public void setMenuFaturas(WebElement menuFaturas) {
        this.menuFaturas = menuFaturas;
    }

    public WebElement getCard() {
        return card;
    }

    public void setCard(WebElement card) {
        this.card = card;
    }

    public WebElement getDanfe() {
        return danfe;
    }

    public void setDanfe(WebElement danfe) {
        this.danfe = danfe;
    }

    public WebElement getXml() {
        return xml;
    }

    public void setXml(WebElement xml) {
        this.xml = xml;
    }

    public WebElement getPagar() {
        return pagar;
    }

    public void setPagar(WebElement pagar) {
        this.pagar = pagar;
    }
}
