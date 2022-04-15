package pageObjects;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;


public class VeiculoObjects {

	private WebDriver driver;

	@FindBy(id = "navi-item-link-veiculos")
	private WebElement menuVeiculo;

	@FindBy(className = "add-button")
	private WebElement inputButton;
	
	@FindBy(xpath = "//*[@id=\"overlay\"]/flow-component-renderer/div/div/vaadin-form-layout/vaadin-text-field[1]")
	private WebElement placa;
	
	@FindBy(xpath = "//*[@id=\"overlay\"]/flow-component-renderer/div/div/vaadin-form-layout/vaadin-number-field")
    private WebElement limiteDeCredito;
	
	@FindBy(xpath ="//*[@id=\"overlay\"]/flow-component-renderer/div/div/vaadin-form-layout/vaadin-combo-box[1]")
	private WebElement utilizaLimiteDeCredito;
	
	@FindBy(xpath = "//*[@id=\"overlay\"]/flow-component-renderer/div/div/vaadin-form-layout/vaadin-combo-box[2]")
	private WebElement bloqueado;
	
	@FindBy(id = "/html/body/vaadin-dialog-overlay/flow-component-renderer/div/div/vaadin-form-layout/vaadin-text-field[2]//div/div[1]/slot[2]/input")
	private WebElement numeroCartao;
	
	@FindBy(xpath = "/html/body/vaadin-dialog-overlay/flow-component-renderer/div/div/vaadin-form-layout/vaadin-password-field")
	private WebElement senha;
	
	@FindBy(xpath = "/html/body/vaadin-dialog-overlay/flow-component-renderer/div/div/vaadin-form-layout/vaadin-text-field[3]")
	private WebElement motorista;
	
	@FindBy(id = "/html/body/vaadin-dialog-overlay/flow-component-renderer/div/div/vaadin-form-layout/vaadin-combo-box[3]//vaadin-text-field//div/div[1]/slot[2]/input")
	private WebElement limitarAosCombustiveisAbaixo;
	
	@FindBy (xpath = "/html/body/vaadin-dialog-overlay/flow-component-renderer/div/div/vaadin-form-layout/vaadin-text-field[4]")
	private WebElement descricaoDoVeiculo;
	
	@FindBy (id = "/html/body/vaadin-dialog-overlay/flow-component-renderer/div/div/vaadin-form-layout/vaadin-combo-box[4]//vaadin-text-field//div/div[1]/slot[2]/input")
	private WebElement limitarAosProdutosAbaixo;
	
	@FindBy(xpath = "/html/body/vaadin-dialog-overlay/flow-component-renderer/div/div/vaadin-form-layout/vaadin-text-field[5]")
	private WebElement observacao;

	@FindBy(xpath = "/html/body/vaadin-dialog-overlay/flow-component-renderer/div/footer/vaadin-button[2]")
	private WebElement ok;
     
	@FindBy(xpath = "//*[@id=\"ROOT-2521314\"]/vaadin-app-layout/div/div[1]/div[1]/vaadin-text-field")
	private WebElement pesquisar;

	@FindBy(xpath = "//*[@id=\"vaadin-checkbox-4\"]")
	private WebElement selecionar;

	@FindBy(xpath = "//*[@id=\"ROOT-2521314\"]/vaadin-app-layout/div/div[1]/div[2]/vaadin-button[1]")
	private WebElement excluir;

	@FindBy(xpath = "//*[@id=\"overlay\"]/flow-component-renderer/div/div/vaadin-button[1]")
	private WebElement confirmar;

	public VeiculoObjects() throws MalformedURLException {

		this.driver = getDriver();

		PageFactory.initElements( getDriver() , this);
	}

	public WebElement getMenuVeiculo() {
		return menuVeiculo;
	}

	public void setMenuVeiculo(WebElement menuVeiculo) {
		this.menuVeiculo = menuVeiculo;
	}

	public WebElement getInputButton() {
		return inputButton;
	}

	public void setInputButton(WebElement inputButton) {
		this.inputButton = inputButton;
	}

	public WebElement getPlaca() {
		return placa;
	}

	public void setPlaca(WebElement placa) {
		this.placa = placa;
	}

	public WebElement getLimiteDeCredito() {
		return limiteDeCredito;
	}

	public void setLimiteDeCredito(WebElement limiteDeCredito) {
		this.limiteDeCredito = limiteDeCredito;
	}

	public WebElement getUtilizaLimiteDeCredito() {
		return utilizaLimiteDeCredito;
	}

	public void setUtilizaLimiteDeCredito(WebElement utilizaLimiteDeCredito) {
		this.utilizaLimiteDeCredito = utilizaLimiteDeCredito;
	}

	public WebElement getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(WebElement bloqueado) {
		this.bloqueado = bloqueado;
	}

	public WebElement getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(WebElement numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public WebElement getSenha() {
		return senha;
	}

	public void setSenha(WebElement senha) {
		this.senha = senha;
	}

	public WebElement getMotorista() {
		return motorista;
	}

	public void setMotorista(WebElement motorista) {
		this.motorista = motorista;
	}

	public WebElement getLimitarAosCombustiveisAbaixo() {
		return limitarAosCombustiveisAbaixo;
	}

	public void setLimitarAosCombustiveisAbaixo(WebElement limitarAosCombustiveisAbaixo) {
		this.limitarAosCombustiveisAbaixo = limitarAosCombustiveisAbaixo;
	}

	public WebElement getDescricaoDoVeiculo() {
		return descricaoDoVeiculo;
	}

	public void setDescricaoDoVeiculo(WebElement descricaoDoVeiculo) {
		this.descricaoDoVeiculo = descricaoDoVeiculo;
	}

	public WebElement getLimitarAosProdutosAbaixo() {
		return limitarAosProdutosAbaixo;
	}

	public void setLimitarAosProdutosAbaixo(WebElement limitarAosProdutosAbaixo) {
		this.limitarAosProdutosAbaixo = limitarAosProdutosAbaixo;
	}

	public WebElement getObservacao() {
		return observacao;
	}

	public void setObservacao(WebElement observacao) {
		this.observacao = observacao;
	}

	public WebElement getOk() {
		return ok;
	}

	public void setOk(WebElement ok) {
		this.ok = ok;
	}

	public WebElement getPesquisar() {
		return pesquisar;
	}

	public void setPesquisar(WebElement pesquisar) {
		this.pesquisar = pesquisar;
	}

	public WebElement getSelecionar() {
		return selecionar;
	}

	public void setSelecionar(WebElement selecionar) {
		this.selecionar = selecionar;
	}

	public WebElement getExcluir() {
		return excluir;
	}

	public void setExcluir(WebElement excluir) {
		this.excluir = excluir;
	}

	public WebElement getConfirmar() {
		return confirmar;
	}

	public void setConfirmar(WebElement confirmar) {
		this.confirmar = confirmar;
	}
}
