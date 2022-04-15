package actions;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.interactions.Actions;
import pageObjects.VeiculoObjects;

import java.net.MalformedURLException;

public class VeiculoActions {
	
	static VeiculoObjects objVeiculo;
	private Actions act;

	public VeiculoActions() throws MalformedURLException {

		objVeiculo = new VeiculoObjects();
		act = new Actions(getDriver());

	}
	
	public void cadastrarVeiculo(String placa, String limiteDeCredito, String utilizaLimiteDeCredito, String bloqueado, String senha, String motorista,  String descricaoDoVeiculo, String observacao) {
		objVeiculo.getMenuVeiculo().click();
		objVeiculo.getInputButton().click();
		objVeiculo.getPlaca().sendKeys(placa);
		objVeiculo.getLimiteDeCredito().sendKeys(limiteDeCredito);
		act.doubleClick(objVeiculo.getUtilizaLimiteDeCredito()).sendKeys(utilizaLimiteDeCredito).build().perform();
		act.doubleClick(objVeiculo.getBloqueado()).sendKeys(bloqueado).build().perform();
		//objhome.getNumeroCartao().sendKeys(numeroDoCartao);
		objVeiculo.getSenha().sendKeys(senha);
		objVeiculo.getMotorista().sendKeys(motorista);
		//objhome.getLimitarAosCombustiveisAbaixo().sendKeys(limitarAosCombustiveisAbaixo);
		objVeiculo.getDescricaoDoVeiculo().sendKeys(descricaoDoVeiculo);
		//objhome.getLimitarAosProdutosAbaixo().sendKeys(limitarAosProdutosAbaixo);
		objVeiculo.getObservacao().sendKeys(observacao);
		objVeiculo.getOk().click();
			
	}

	public void pesquisar (String pesquisa) {

		objVeiculo.getMenuVeiculo().click();
		objVeiculo.getPesquisar().sendKeys(pesquisa);

	}

	public void remover() {

		objVeiculo.getSelecionar().click();
		objVeiculo.getExcluir().click();
		objVeiculo.getConfirmar().click();

	}


}

