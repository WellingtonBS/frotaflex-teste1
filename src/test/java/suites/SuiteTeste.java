package suites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

import tests.TestCompras;
import tests.TestLogin;
import tests.TestVeiculo;


@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Suite de testes")
@SelectClasses({TestLogin.class,
        TestCompras.class,
        TestVeiculo.class})
public class SuiteTeste {

}
