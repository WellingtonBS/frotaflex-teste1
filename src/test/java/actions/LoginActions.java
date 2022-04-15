package actions;

import pageObjects.LoginObjects;

import java.net.MalformedURLException;

public class LoginActions {

    static LoginObjects objLogin;


    public LoginActions() throws MalformedURLException {

        objLogin = new LoginObjects();
    }

    public void  Login(String user,String senha) {

        objLogin.getUser().sendKeys(user);
        objLogin.getSenha().sendKeys(senha);
        objLogin.getButConfirm().click();

    }

    public void Cadastrar(String user,String senha) {

        objLogin.getUser().sendKeys(user);
        objLogin.getSenha().sendKeys(senha);
        objLogin.getButCadastrar().click();
    }

}
