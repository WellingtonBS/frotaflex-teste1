package core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = true;


	public static Browsers browser = Browsers.CHROME;

	/* Defini o formato de exeção
	 * false = utiliza execução browser
	 * true = utiliza execução selenium hub */
	public static boolean seleniumHub = true ;

	public static String url = "https://demo.frotaflex.com.br/" ;

	public static String urlSeleniumHub = "http://localhost:4444/wd/hub";

	public enum Browsers {
		CHROME,
		FIREFOX
	}

}
